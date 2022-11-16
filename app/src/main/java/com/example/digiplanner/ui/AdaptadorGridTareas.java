package com.example.digiplanner.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digiplanner.R;

import java.util.List;

public class AdaptadorGridTareas extends RecyclerView.Adapter<AdaptadorGridTareas.ViewHolder> {

    List<String> nombreElementos;
    List<Integer> images;
    Context context;

    LayoutInflater inflater;

    public AdaptadorGridTareas(Context context,List<String> nombreElementos, List<Integer> images ){
        this.nombreElementos=nombreElementos;
        this.images=images;
        this.inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.grid_tareas,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.elemento.setText(nombreElementos.get(position));
        holder.icon.setImageResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        return nombreElementos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView elemento;
        ImageView icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            elemento = itemView.findViewById(R.id.textView);
            icon = itemView.findViewById(R.id.imageView);
        }
    }
}
