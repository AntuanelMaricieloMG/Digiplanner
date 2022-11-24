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

import com.example.digiplanner.ui.home.HomeFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class AccederApp extends AppCompatActivity {

    EditText emailentrar,contraseñaentrar;
    RelativeLayout entrar, crearCuenta;
    TextView olvideContraseña;
    FirebaseAuth firebaseAutenticacion;
    FirebaseUser firebaseUsuario;

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

        firebaseAutenticacion = FirebaseAuth.getInstance();
        firebaseUsuario = firebaseAutenticacion.getCurrentUser();


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

                    firebaseAutenticacion.signInWithEmailAndPassword(email,constraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                verificaionEmail();
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"No existe",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });
/*
       if(firebaseUsuario!=null)
        {
            finish();
            startActivity(new Intent(AccederApp.this,MainActivity.class));
        }

        else
        {

        }
*/
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
        }
    }
}
