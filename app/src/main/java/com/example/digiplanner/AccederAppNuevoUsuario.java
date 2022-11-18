package com.example.digiplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AccederAppNuevoUsuario extends AppCompatActivity {

    private EditText nuevoEmail,nuevaContraseña;
    private RelativeLayout nuevoUsuario;
    private TextView accede;
    private FirebaseAuth firebaseAutentificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.principal_acceder_app_nuevousuario);
        getSupportActionBar().hide();

        //id de elementos Layouts
        nuevoEmail = findViewById(R.id.text_login_nuevo_email);
        nuevaContraseña = findViewById(R.id.text_login_nueva_contraseña);
        nuevoUsuario = findViewById(R.id.login_nuevo_usuario);
        accede = findViewById(R.id.tengo_un_usuario);

        firebaseAutentificacion = FirebaseAuth.getInstance();

        nuevoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                    firebaseAutentificacion.createUserWithEmailAndPassword(emailnuevo,contrasseñanueva).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(getApplicationContext(),"Registro completo",Toast.LENGTH_SHORT).show();
                                sendEmail();
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"Fallo", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
 
    private void sendEmail(){

        FirebaseUser firebaseUsuario = firebaseAutentificacion.getCurrentUser();
        if(firebaseUsuario != null)
        {
            firebaseUsuario.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(getApplicationContext(), "verificacion hecha, entra otra vez", Toast.LENGTH_SHORT).show();
                    firebaseAutentificacion.signOut();
                    finish();
                    startActivity(new Intent(AccederAppNuevoUsuario.this,AccederApp.class));
                }
            });
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Fallo", Toast.LENGTH_SHORT).show();
        }
    }
}