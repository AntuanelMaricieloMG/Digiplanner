package com.example.digiplanner;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;

public class AccederAppOlvidadoUsuario extends AppCompatActivity {

    EditText olvideContraseña;
    Button botonRecuperarContraseña;
    TextView olvideVuelveatras;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.principal_acceder_app_olvidadousuario);
        getSupportActionBar().hide();
        olvideContraseña = findViewById(R.id.text_olvide_contraseña);
        botonRecuperarContraseña = findViewById(R.id.boton_recuperar_contraseña);
        olvideVuelveatras = findViewById(R.id.olvidecontraseña_vuelveatras);

        olvideVuelveatras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail= olvideContraseña.getText().toString().trim();
                if(mail.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"introduce email",Toast.LENGTH_SHORT).show();
                }
                else
                {

                }
            }
        });
    }
}



