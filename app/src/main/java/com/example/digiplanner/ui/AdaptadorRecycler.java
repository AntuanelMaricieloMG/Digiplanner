package com.example.digiplanner.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digiplanner.R;
import com.example.digiplanner.ui.home.Evento;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class AdaptadorRecycler extends FirestoreRecyclerAdapter <Evento,AdaptadorRecycler.ViewHolder>{
    FirebaseFirestore firebaseFirestore;

    public AdaptadorRecycler(@NonNull FirestoreRecyclerOptions<Evento> options){
        super(options);
    }
    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int position, @NonNull Evento evento) {
        viewHolder.nombre.setText(evento.getNombre());
        viewHolder.hora.setText(evento.getHora());
        viewHolder.fecha.setText(evento.getFecha());

        DocumentSnapshot documentSnapshot = getSnapshots().getSnapshot(viewHolder.getAdapterPosition());
        String id = documentSnapshot.getId();
        viewHolder.eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarEvento(id);
            }
        });
    }
    public void eliminarEvento(String id){
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("evento").document(id).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {

            }
        }).addOnFailureListener(new OnFailureListener() {
             @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new ViewHolder (v);
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageButton eliminar;
        TextView nombre,hora,fecha;
        public ViewHolder (@NonNull View itemView){
            super(itemView);
            nombre = itemView.findViewById(R.id.texto_muestraeventoguardado);
            hora = itemView.findViewById(R.id.texto_muestrahoraguardada);
            fecha = itemView.findViewById(R.id.texto_muestrafechaguardada);
            eliminar = itemView.findViewById(R.id.boton_eliminarevento);
        }

    }
}
