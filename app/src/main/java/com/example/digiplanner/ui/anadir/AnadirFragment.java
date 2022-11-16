package com.example.digiplanner.ui.anadir;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.digiplanner.R;
import com.example.digiplanner.databinding.FragmentAnadirBinding;
import com.example.digiplanner.databinding.FragmentHomeBinding;
import com.example.digiplanner.ui.AdaptadorGridDias;
import com.example.digiplanner.ui.AdaptadorGridTareas;

import java.util.ArrayList;
import java.util.List;


public class AnadirFragment extends Fragment {
    Context context;
    RecyclerView listaTareasCasa;
    List<String> elementosTareaCasa;
    List<Integer> images;
    TextView textviewtituloTareas;
    TextView textviewtituloTareasCasa;

    RecyclerView listaTareasMudanza;
    List<String> elementosTareaMudanza;
    TextView textviewtituloTareasMudanza;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_anadir,container,false);
        //Tareas de casa id
        listaTareasCasa = view.findViewById(R.id.lista_tareas_casa);
        textviewtituloTareas = view.findViewById(R.id.textView_añadirtitulo1);
        textviewtituloTareasCasa = view.findViewById(R.id.textView_añadirtitulo2);

        //Lista tareas de casa
        elementosTareaCasa = new ArrayList<>();
        images = new ArrayList<>();
        elementosTareaCasa.add("Limpieza");
        elementosTareaCasa.add("Documentos");
        images.add(R.drawable.rata);
        images.add(R.drawable.rata);

        AdaptadorGridTareas adaptador = new AdaptadorGridTareas(getActivity(),elementosTareaCasa,images);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2,GridLayoutManager.VERTICAL,false);
        listaTareasCasa.setLayoutManager(gridLayoutManager);
        listaTareasCasa.setAdapter(adaptador);


        //Tareas de Mudanza id
        listaTareasMudanza = view.findViewById(R.id.lista_tareas_mudanza);
        textviewtituloTareasMudanza = view.findViewById(R.id.textView_añadirtitulo3);
        elementosTareaMudanza = new ArrayList<>();
        elementosTareaMudanza.add("Muebles");
        elementosTareaMudanza.add("Decoración");
        elementosTareaMudanza.add("Compras");
        images.add(R.drawable.rata);
        images.add(R.drawable.rata);

        AdaptadorGridTareas adaptador2 = new AdaptadorGridTareas(getActivity(),elementosTareaMudanza,images);
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getActivity(),2,GridLayoutManager.VERTICAL,false);
        listaTareasMudanza.setLayoutManager(gridLayoutManager2);
        listaTareasMudanza.setAdapter(adaptador2);

        return view;
    }
}