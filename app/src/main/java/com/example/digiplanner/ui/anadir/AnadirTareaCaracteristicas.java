package com.example.digiplanner.ui.anadir;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digiplanner.R;

import java.util.List;

public class AnadirTareaCaracteristicas extends Fragment {

    EditText tareaNueva;
    TextView horaSeleccionada;
    Button elegirHora;
    Button tareaCreada;




    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_anadirtareacaracteristicas,container,false);
        //ID
        tareaNueva = view.findViewById(R.id.nueva_tarea);
        horaSeleccionada = view.findViewById(R.id.boton_selectorhoratarea);
        elegirHora = view.findViewById(R.id.boton_creartarea);

        return view;
    }
}