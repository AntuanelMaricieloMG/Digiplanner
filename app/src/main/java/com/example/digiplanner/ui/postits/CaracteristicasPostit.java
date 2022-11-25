package com.example.digiplanner.ui.postits;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.digiplanner.R;
import com.example.digiplanner.databinding.FragmentHomeBinding;

public class CaracteristicasPostit extends Fragment {

    TextView tituloCaracteristicaspostit,contenidoCaracteristicaspostit;
    Button botonGuardarCaracteristicaspostit;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,container,false);
        //ID
        tituloCaracteristicaspostit = view.findViewById(R.id.titulo_caracteristicaspostit);
        contenidoCaracteristicaspostit = view.findViewById(R.id.contenido_caracteristicaspostit);
        botonGuardarCaracteristicaspostit= view.findViewById(R.id.boton_guardar_caracteristicaspostit) ;


        botonGuardarCaracteristicaspostit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getArguments() != null){
                    String dataReceiveT = getArguments().getString("Titulo");
                    String dataReceiveC = getArguments().getString("Contenido");
                    String dataReceiveP = getArguments().getString("Postid");
                }
            }
        });

        tituloCaracteristicaspostit.setText(getString(Integer.parseInt("Titulo")));
        contenidoCaracteristicaspostit.setText(getString(Integer.parseInt("Contenido")));


        return view;
    }
}
