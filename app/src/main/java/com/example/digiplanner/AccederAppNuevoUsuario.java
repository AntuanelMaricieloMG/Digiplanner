package com.example.digiplanner;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AccederAppNuevoUsuario extends AppCompatActivity {

    EditText nuevoEmail,nuevaContraseña;
    RelativeLayout nuevoUsuario;
    TextView accede;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal_acceder_app_nuevousuario);
        getSupportActionBar().hide();

        nuevoEmail = findViewById(R.id.text_login_nuevo_email);
        nuevaContraseña = findViewById(R.id.text_login_nueva_contraseña);
        nuevoUsuario = findViewById(R.id.login_nuevo_usuario);
        accede = findViewById(R.id.tengo_un_usuario);

        accede.setOnClickListener(new View.OnClickListener() {
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

                }
            }
        });
    }
}