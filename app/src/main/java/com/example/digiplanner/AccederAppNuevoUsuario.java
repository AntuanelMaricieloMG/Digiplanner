package com.example.digiplanner;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AccederAppNuevoUsuario extends AppCompatActivity {

    EditText nuevoEmail,nuevaContraseña,nuevoNombre,nuevoTeléfono ;
    RelativeLayout botonnuevoUsuario;
    TextView accede;
    FirebaseAuth firebaseAutentificacion;
    FirebaseFirestore firebaseFirestore;
    FirebaseUser firebaseUsuario;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.principal_acceder_app_nuevousuario);
        Objects.requireNonNull(getSupportActionBar()).hide();
        //ID
        nuevoEmail = findViewById(R.id.text_login_nuevo_email);
        nuevaContraseña = findViewById(R.id.text_login_nueva_contraseña);
        nuevoNombre = findViewById(R.id.text_usuarionombre);
        nuevoTeléfono = findViewById(R.id.text_usuariotelefono);
        botonnuevoUsuario = findViewById(R.id.login_nuevo_usuario);
        accede = findViewById(R.id.tengo_un_usuario);


        //BBDD
        firebaseAutentificacion = FirebaseAuth.getInstance();
        firebaseUsuario = FirebaseAuth.getInstance().getCurrentUser();
        firebaseFirestore = FirebaseFirestore.getInstance();

        accede.setOnClickListener(v -> startActivity(new Intent(AccederAppNuevoUsuario.this,AccederApp.class)));
        botonnuevoUsuario.setOnClickListener(v -> {
            String emailnuevo = nuevoEmail.getText().toString().trim();
            String contrasseñanueva = nuevaContraseña.getText().toString().trim();

            if(emailnuevo.isEmpty() || contrasseñanueva.isEmpty())
            {
                Toast.makeText(getApplicationContext(),"Se requieren todos los campos", Toast.LENGTH_SHORT).show();
            }
            else if(contrasseñanueva.length()<7)
            {
                Toast.makeText(getApplicationContext(),"Contraseña requiere menos de 7 digitos", Toast.LENGTH_SHORT).show();
            }
            else
            {
                //se registra usuario nuevo

                firebaseAutentificacion.createUserWithEmailAndPassword(emailnuevo,contrasseñanueva).addOnCompleteListener(task -> {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(getApplicationContext(),"Registro completo",Toast.LENGTH_SHORT).show();
                        sendEmail();
                        //Guardar datos

                        String nombre = nuevoNombre.getText().toString().trim();
                        String telefono = nuevoTeléfono.getText().toString().trim();

                        Map<String,Object> map = new HashMap<>();
                        map.put("nombre",nombre);
                        map.put("telefono",telefono);


                        firebaseFirestore.collection("datos").add(map).addOnSuccessListener(documentReference -> {
                        }).addOnFailureListener(e -> {

                        });

                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Fallo", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
 
    private void sendEmail(){

        FirebaseUser firebaseUsuario = firebaseAutentificacion.getCurrentUser();
        if(firebaseUsuario != null)
        {
            firebaseUsuario.sendEmailVerification().addOnCompleteListener(task -> {
                Toast.makeText(getApplicationContext(), "verificacion hecha, entra otra vez", Toast.LENGTH_SHORT).show();
                firebaseAutentificacion.signOut();
                finish();
                startActivity(new Intent(AccederAppNuevoUsuario.this,AccederApp.class));
            });
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Fallo", Toast.LENGTH_SHORT).show();
        }
    }
}