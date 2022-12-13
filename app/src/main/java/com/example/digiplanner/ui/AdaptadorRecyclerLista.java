package com.example.digiplanner.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.digiplanner.R;

import java.util.List;

public class AdaptadorRecyclerLista extends RecyclerView.Adapter<AdaptadorRecyclerLista.ViewHolder>  {


    List<String> hora1;
    List<String> hora2;

    LayoutInflater inflater;


    public AdaptadorRecyclerLista(Context context,List<String> hora1,List<String> hora2){
        this.hora1=hora1;
        this.hora2=hora2;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AdaptadorRecyclerLista.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.tareas_lista,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecyclerLista.ViewHolder holder, int position) {
        holder.h1.setText(hora1.get(position));
        holder.h2.setText(hora2.get(position));
    }

    @Override
    public int getItemCount() {
        return hora1.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView h1;
        TextView h2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            h1 = itemView.findViewById(R.id.horario1);
            h2 = itemView.findViewById(R.id.horario2);
        }
    }
}

