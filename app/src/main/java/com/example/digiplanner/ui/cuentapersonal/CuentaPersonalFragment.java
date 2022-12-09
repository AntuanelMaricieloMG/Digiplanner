package com.example.digiplanner.ui.cuentapersonal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;



import com.example.digiplanner.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.concurrent.Executor;


public class CuentaPersonalFragment extends Fragment {

    ImageView imagenCuenta;
    TextView textoNombre,textoCorreo ,textoNotificaciones ;
    TextView nombreUsuario,correoUsuario  ,telefonoUsuario;
    Switch interruptor;
    CardView vistaCirculo;

    FirebaseAuth.AuthStateListener authStateListener;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    String idUser;



    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cuentapersonal,container,false);

        //ID
        imagenCuenta = (ImageView) view.findViewById(R.id.imageCuenta);
        textoNombre = (TextView) view.findViewById(R.id.textNombre);
        textoCorreo = (TextView) view.findViewById(R.id.textCorreo);
        textoNotificaciones = (TextView) view.findViewById(R.id.textNotificaciones);
        nombreUsuario = view.findViewById(R.id.texto_nombreusuario);
        correoUsuario = view.findViewById(R.id.texto_correoelect);
        telefonoUsuario = view.findViewById(R.id.texto_telefonousuario);
        interruptor = view.findViewById(R.id.switch_interruptor);
        vistaCirculo = (CardView) view.findViewById(R.id.vistaCircular);

        interruptor.isChecked();


        firebaseAuth= FirebaseAuth.getInstance();
        final FirebaseUser user = firebaseAuth.getCurrentUser();
        firebaseFirestore = FirebaseFirestore.getInstance();
        idUser = firebaseAuth.getCurrentUser().getUid();

        correoUsuario.setText(user.getEmail());
        nombreUsuario.setText(user.getUid());

        DocumentReference documentReference = firebaseFirestore.collection("datos").document(idUser);
        documentReference.addSnapshotListener( (EventListener<DocumentSnapshot>) new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                nombreUsuario.setText(value.getString("nombre"));
                telefonoUsuario.setText(value.getString("telefono"));
            }
        });
        return view;
    }

}