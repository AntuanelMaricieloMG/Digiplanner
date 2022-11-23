package com.example.digiplanner.ui.postits;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digiplanner.AccederApp;
import com.example.digiplanner.MainActivity;
import com.example.digiplanner.R;
import com.example.digiplanner.databinding.FragmentPostitsBinding;
import com.example.digiplanner.ui.AdaptadorGridDias;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;


public class PostitsFragment extends Fragment {

    RecyclerView listaDePost;
    Button botonCreaPostit;
    FirebaseAuth firebaseAutenticacion;
    FirebaseUser firebaseUsuario;
    FirebaseFirestore firebaseFirestore;
    FirestoreRecycleAdapter<PostitRecyclerView,PositViewModel>adaptadorParaPostFirebase;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_postits,container,false);

        //ID
        botonCreaPostit = view.findViewById(R.id.boton_crea_postit);
        //FIREBASE
        firebaseAutenticacion = FirebaseAuth.getInstance();
        firebaseUsuario = FirebaseAuth.getInstance().getCurrentUser();
        firebaseFirestore = FirebaseFirestore.getInstance();

        botonCreaPostit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CrearPost crearPost= new CrearPost();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main, crearPost);
                transaction.commit();
            }
        });

        return view;
    }
}