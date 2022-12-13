package com.example.digiplanner;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;


public class AccederApp extends AppCompatActivity {

    EditText emailentrar,contraseñaentrar;
    RelativeLayout entrar, crearCuenta;
    TextView olvideContraseña;
    FirebaseAuth firebaseAutenticacion;
    FirebaseUser firebaseUsuario;
    ProgressBar procesocircular;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.principal_acceder_app);
        Objects.requireNonNull(getSupportActionBar()).hide();

        //ID
        emailentrar = findViewById(R.id.text_login_email);
        contraseñaentrar = findViewById(R.id.text_login_contraseña);
        entrar = findViewById(R.id.login_usuario);
        crearCuenta = findViewById(R.id.crear_nuevo_user);
        olvideContraseña = findViewById(R.id.olvide_mi_contraseña);
        procesocircular = findViewById(R.id.progress_acceder);



        firebaseAutenticacion = FirebaseAuth.getInstance();
        firebaseUsuario = firebaseAutenticacion.getCurrentUser();


        crearCuenta.setOnClickListener(v -> startActivity(new Intent(AccederApp.this, AccederAppNuevoUsuario.class)));

        olvideContraseña.setOnClickListener(v -> startActivity(new Intent(AccederApp.this, AccederAppOlvidadoUsuario.class)));

        entrar.setOnClickListener(v -> {
            String email = emailentrar.getText().toString().trim();
            String constraseña = contraseñaentrar.getText().toString().trim();

            if(email.isEmpty() || constraseña.isEmpty())
            {
                Toast.makeText(getApplicationContext(),"Rellena los campos para acceder", Toast.LENGTH_SHORT).show();
            }

            else
            {
                procesocircular.setVisibility(View.VISIBLE);
                firebaseAutenticacion.signInWithEmailAndPassword(email,constraseña).addOnCompleteListener(task -> {
                    if(task.isSuccessful())
                    {
                        verificaionEmail();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"No existe",Toast.LENGTH_SHORT).show();
                        procesocircular.setVisibility(View.VISIBLE);
                    }
                });

            }
        });

    }
    private void verificaionEmail()
    {
        FirebaseUser firebaseUsuario = firebaseAutenticacion.getCurrentUser();
        if(firebaseUsuario.isEmailVerified() == true )
        {
            Toast.makeText(getApplicationContext(),"listo",Toast.LENGTH_SHORT).show();
            finish();
            startActivity(new Intent(AccederApp.this, MainActivity.class));

        }
        else
        {
            Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_SHORT).show();
            firebaseAutenticacion.signOut();
            procesocircular.setVisibility(View.VISIBLE);
        }
    }
}
