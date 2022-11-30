package com.example.digiplanner;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class AccederAppOlvidadoUsuario extends AppCompatActivity {

    EditText olvideContraseña;
    RelativeLayout botonRecuperarContraseña;
    TextView olvideVuelveatras;
    FirebaseAuth firebaseAutenticacion;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.principal_acceder_app_olvidadousuario);
        getSupportActionBar().hide();
        olvideContraseña = findViewById(R.id.text_olvide_contraseña);
        botonRecuperarContraseña = findViewById(R.id.boton_recuperar_contraseña);
        olvideVuelveatras = findViewById(R.id.olvidecontraseña_vuelveatras);

        firebaseAutenticacion = FirebaseAuth.getInstance();

        botonRecuperarContraseña.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email= olvideContraseña.getText().toString().trim();
                if(email.isEmpty())
                {
                    //Vuelve al Activity inicial
                    Toast.makeText(getApplicationContext(),"introduce el email",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //Envia correo para recuperar contraseña
                    firebaseAutenticacion.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                            {
                                finish();
                                startActivity(new Intent(AccederAppOlvidadoUsuario.this,AccederApp.class));
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"Correo no válido",Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            }
        });
    }
}



