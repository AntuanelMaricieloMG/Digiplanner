package com.example.digiplanner.ui.anadir;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.digiplanner.R;
import com.example.digiplanner.ui.AdaptadorGridDias;
import com.example.digiplanner.ui.AdaptadorGridTareas;
import com.example.digiplanner.ui.postits.PostitsFragment;

import java.util.ArrayList;
import java.util.List;


public class AnadirFragment extends Fragment {
    Context context;
    RecyclerView listaTareas;
    List<String> elementosTarea;
    List<Integer> images;
    TextView textviewtituloTareas;




    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_anadir,container,false);


        //Tareas de casa ID
        listaTareas = view.findViewById(R.id.lista_tareas);
        textviewtituloTareas = view.findViewById(R.id.textView_añadirtitulo1);
        elementosTarea = new ArrayList<>();
        images = new ArrayList<>();
        elementosTarea.add("Limpieza");
        elementosTarea.add("Documentos");
        elementosTarea.add("Muebles");
        elementosTarea.add("Decoración");
        elementosTarea.add("Compras");
        elementosTarea.add("Cita medica");
        elementosTarea.add("Medicación");
        elementosTarea.add("Documentación");
        elementosTarea.add("Eventos familiares");
        elementosTarea.add("Examen");
        elementosTarea.add("Tareas");
        elementosTarea.add("Trabajos");
        elementosTarea.add("Links importantes");
        elementosTarea.add("Links informacion");
        images.add(R.drawable.ic_baseline_cleaning_services_24);
        images.add(R.drawable.ic_baseline_document_scanner_24);
        images.add(R.drawable.ic_baseline_warehouse_24);
        images.add(R.drawable.ic_baseline_desk_24);
        images.add(R.drawable.ic_baseline_shopping_bag_24);
        images.add(R.drawable.ic_baseline_note_add_24);
        images.add(R.drawable.ic_baseline_local_pharmacy_24);
        images.add(R.drawable.ic_baseline_note_alt_24);
        images.add(R.drawable.ic_baseline_groups_24);
        images.add(R.drawable.ic_baseline_library_books_24);
        images.add(R.drawable.ic_baseline_self_improvement_24);
        images.add(R.drawable.ic_baseline_home_work_24);
        images.add(R.drawable.ic_baseline_checklist_rtl_24);
        images.add(R.drawable.ic_baseline_dvr_24);

        AdaptadorGridTareas adaptador = new AdaptadorGridTareas(getActivity(),elementosTarea,images);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2,GridLayoutManager.VERTICAL,false);
        listaTareas.setLayoutManager(gridLayoutManager);
        listaTareas.setAdapter(adaptador);


        return view;
    }


}