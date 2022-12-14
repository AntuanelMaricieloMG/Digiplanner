package com.example.digiplanner.ui.postits;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.example.digiplanner.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

public class CrearPost extends Fragment {

    EditText titulocreado,contenidocreado;
    RelativeLayout botonguardar;
    ProgressBar procesocircular;
    FirebaseUser firebaseUsuario;
    FirebaseAuth firebaseAutenticacion;
    FirebaseFirestore firebaseFirestore;
    Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_crearpost,container,false);

        //ID
        toolbar= view.findViewById(R.id.toolbar_post);
        botonguardar = view.findViewById(R.id.boton_guardar);
        titulocreado = view.findViewById(R.id.creartitulodelanota);
        contenidocreado = view.findViewById(R.id.crearelcontenidodelanota);
        procesocircular = view.findViewById(R.id.progress_crear);


        //Base de datos

        firebaseAutenticacion=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();
        firebaseUsuario=FirebaseAuth.getInstance().getCurrentUser();

        botonguardar.setOnClickListener(v -> {
            String title=titulocreado.getText().toString();
            String content=contenidocreado.getText().toString();
            if(title.isEmpty()|| content.isEmpty())
            {
                Toast.makeText(getActivity().getApplicationContext(), "Se requieren ambos campos", Toast.LENGTH_SHORT).show();
            }
            else
            {
                procesocircular.setVisibility(View.VISIBLE);
                //En firebase se guardara el post
                DocumentReference documentReference = firebaseFirestore.collection("posts").document(firebaseUsuario.getUid()).collection("mi post").document();
                Map<String,Object> post = new HashMap<>();
                post.put("titulo",title);
                post.put("contenido",content);

                documentReference.set(post).addOnSuccessListener(unused -> {
                    Toast.makeText(getActivity().getApplicationContext(),"post creado",Toast.LENGTH_SHORT).show();
                    procesocircular.setVisibility(View.VISIBLE);
                    PostitsFragment postitsfragment= new PostitsFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.nav_host_fragment_activity_main, postitsfragment);
                    transaction.commit();

                }).addOnFailureListener(e -> {
                    Toast.makeText(getActivity().getApplicationContext(),"no se pudo crear, error",Toast.LENGTH_SHORT).show();
                    procesocircular.setVisibility(View.VISIBLE);
                });
            }


        });

        return view;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
           requireActivity().onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}