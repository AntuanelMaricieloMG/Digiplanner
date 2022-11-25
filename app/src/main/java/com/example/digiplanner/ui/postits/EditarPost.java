package com.example.digiplanner.ui.postits;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.widget.Toolbar;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.digiplanner.R;

public class EditarPost  extends Fragment {

    EditText tituloEditarpost;
    EditText contenidoEditarpost;
    Button botonGuardarEditarpost;
    Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,container,false);

        //ID
        tituloEditarpost = view.findViewById(R.id.titulo_editarpost);
        contenidoEditarpost = view.findViewById(R.id.contenido_editarpost);
        botonGuardarEditarpost = view.findViewById(R.id.boton_guardar_editarpost);
        toolbar = view.findViewById(R.id.toolbar_editarpost);

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return view;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            requireActivity().onBackPressed();
            //super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}