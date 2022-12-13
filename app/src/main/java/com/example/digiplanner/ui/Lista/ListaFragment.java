package com.example.digiplanner.ui.Lista;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.digiplanner.R;
import com.example.digiplanner.ui.AdaptadorRecyclerLista;

import java.util.ArrayList;
import java.util.List;

public class ListaFragment extends Fragment {

    RecyclerView listaTareas;
    List<String> elementoshora1;
    List<String> elementoshora2;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista,container,false);


        //Tareas de casa ID
        listaTareas = view.findViewById(R.id.recyclerview_listafragment);
        elementoshora1 = new ArrayList<>();
        elementoshora2 = new ArrayList<>();
        elementoshora1.add("7:00");
        elementoshora1.add("8:00");
        elementoshora1.add("9:00");
        elementoshora1.add("10:00");
        elementoshora1.add("11:00");
        elementoshora1.add("12:00");
        elementoshora1.add("13:00");
        elementoshora1.add("14:00");
        elementoshora1.add("15:00");
        elementoshora1.add("16:00");
        elementoshora1.add("17:00");
        elementoshora1.add("18:00");
        elementoshora1.add("19:00");
        elementoshora1.add("20:00");
        elementoshora1.add("21:00");
        elementoshora1.add("22:00");
        elementoshora1.add("23:00");

        elementoshora2.add("8:00");
        elementoshora2.add("9:00");
        elementoshora2.add("10:00");
        elementoshora2.add("11:00");
        elementoshora2.add("12:00");
        elementoshora2.add("13:00");
        elementoshora2.add("14:00");
        elementoshora2.add("15:00");
        elementoshora2.add("16:00");
        elementoshora2.add("17:00");
        elementoshora2.add("18:00");
        elementoshora2.add("19:00");
        elementoshora2.add("20:00");
        elementoshora2.add("21:00");
        elementoshora2.add("22:00");
        elementoshora2.add("23:00");
        elementoshora2.add("00:00");


        AdaptadorRecyclerLista adaptador = new AdaptadorRecyclerLista(getActivity(),elementoshora1,elementoshora2);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),1,GridLayoutManager.VERTICAL,false);
        listaTareas.setLayoutManager(gridLayoutManager);
        listaTareas.setAdapter(adaptador);


        return view;
    }


}