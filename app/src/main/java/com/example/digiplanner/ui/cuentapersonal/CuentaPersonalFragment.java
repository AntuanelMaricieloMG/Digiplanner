package com.example.digiplanner.ui.cuentapersonal;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;



import com.example.digiplanner.R;



public class CuentaPersonalFragment extends Fragment {

    ImageView imagenCuenta;
    TextView textoNombre;
    TextView textoCorreo;
    TextView textoContraseña;
    TextView textoNotificaciones;
    TextView textoCerrar;
    TextView textoBorrar;
    CardView vistaCirculo;
    //ºprivate FragmentCuentapersonalBinding fragmentC;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cuentapersonal,container,false);

        //Elementos por ID
        imagenCuenta = (ImageView) view.findViewById(R.id.imageCuenta);
        textoNombre = (TextView) view.findViewById(R.id.textNombre);
        textoCorreo = (TextView) view.findViewById(R.id.textCorreo);
        textoContraseña = (TextView) view.findViewById(R.id.textContraseña);
        textoNotificaciones = (TextView) view.findViewById(R.id.textNotificaciones);
        textoCerrar = (TextView) view.findViewById(R.id.textCerrar);
        textoBorrar = (TextView) view.findViewById(R.id.textBorrar);
        vistaCirculo = (CardView) view.findViewById(R.id.vistaCircular);
        return view;
    }



    /*@Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentC = null;
    }*/
}