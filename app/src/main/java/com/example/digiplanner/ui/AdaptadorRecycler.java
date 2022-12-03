package com.example.digiplanner.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digiplanner.R;
import com.example.digiplanner.ui.home.Evento;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.util.ArrayList;


public class AdaptadorRecycler extends FirestoreRecyclerAdapter <Evento,AdaptadorRecycler.ViewHolder>{


    public AdaptadorRecycler(@NonNull FirestoreRecyclerOptions<Evento> options){
        super(options);
    }
    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int position, @NonNull Evento evento) {
        viewHolder.nombre.setText(evento.getNombre());
        viewHolder.hora.setText(evento.getHora());
        viewHolder.fecha.setText(evento.getFecha());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new ViewHolder (v);
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nombre,hora,fecha;
        public ViewHolder (@NonNull View itemView){
            super(itemView);
            nombre = itemView.findViewById(R.id.texto_muestraeventoguardado);
            hora = itemView.findViewById(R.id.texto_muestrahoraguardada);
            fecha = itemView.findViewById(R.id.texto_muestrafechaguardada);
        }

    }
}
