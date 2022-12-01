package com.example.digiplanner.ui.postits;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.digiplanner.MainActivity;
import com.example.digiplanner.R;

public class CaracteristicasPostit extends Fragment {

    TextView tituloCaracteristicaspostit,contenidoCaracteristicaspostit;
    Button botonGuardarCaracteristicaspostit;
    Toolbar toolbarCaracteristicaspostit;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_caracteristicaspostit,container,false);
        //ID
        tituloCaracteristicaspostit = view.findViewById(R.id.titulo_caracteristicaspostit);
        contenidoCaracteristicaspostit = view.findViewById(R.id.contenido_caracteristicaspostit);
        botonGuardarCaracteristicaspostit= view.findViewById(R.id.boton_guardar_caracteristicaspostit) ;
        toolbarCaracteristicaspostit = view.findViewById(R.id.toolbar_caracteristicaspostit);



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
