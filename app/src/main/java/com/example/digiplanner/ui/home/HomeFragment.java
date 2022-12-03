package com.example.digiplanner.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digiplanner.R;
import com.example.digiplanner.ui.AdaptadorGridDias;
import com.example.digiplanner.ui.AdaptadorRecycler;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class HomeFragment extends Fragment {

    AdaptadorRecycler adaptadorRecycler;
    RecyclerView recyclerLista;
    FirebaseFirestore firebaseFirestore;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,container,false);

        firebaseFirestore = FirebaseFirestore.getInstance();


        recyclerLista = view.findViewById(R.id.recyclerview_lista);
        recyclerLista.setLayoutManager(new LinearLayoutManager(getContext()));
        Query query = firebaseFirestore.collection("evento");
        FirestoreRecyclerOptions<Evento> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<Evento>().setQuery(query, Evento.class).build();

        adaptadorRecycler = new AdaptadorRecycler(firestoreRecyclerOptions);
        adaptadorRecycler.notifyDataSetChanged();
        recyclerLista.setAdapter(adaptadorRecycler);


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        adaptadorRecycler.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adaptadorRecycler.stopListening();
    }
}