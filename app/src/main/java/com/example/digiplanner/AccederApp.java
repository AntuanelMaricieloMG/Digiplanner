package com.example.digiplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;

import org.w3c.dom.Text;

public class AccederApp extends MainActivity{

    EditText emailentrar,contraseñaentrar;
    RelativeLayout entrar, crearCuenta;
    TextView olvideContraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.principal_acceder_app);
        getSupportActionBar().hide();

        emailentrar = findViewById(R.id.text_login_email);
        contraseñaentrar = findViewById(R.id.text_login_contraseña);
        entrar = findViewById(R.id.login_usuario);
        crearCuenta = findViewById(R.id.crear_nuevo_user);
        olvideContraseña = findViewById(R.id.olvide_mi_contraseña);

        crearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AccederApp.this,AccederAppNuevoUsuario.class));
            }
        });

        olvideContraseña.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AccederApp.this,AccederAppOlvidadoUsuario.class));
            }
        });

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailentrar.getText().toString().trim();
                String constraseña = contraseñaentrar.getText().toString().trim();

                if(email.isEmpty() || constraseña.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Rellena los campos", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    startActivity(new Intent(AccederApp.this,MainActivity.class));
                }
            }
        });
    }
}
