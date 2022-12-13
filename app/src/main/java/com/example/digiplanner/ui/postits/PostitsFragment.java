package com.example.digiplanner.ui.postits;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.example.digiplanner.MainActivity;
import com.example.digiplanner.R;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;


public class PostitsFragment extends Fragment {

    RecyclerView listaDePost;
    RelativeLayout botonCreaPostit;
    FirebaseAuth firebaseAutenticacion;
    FirebaseUser firebaseUsuario;
    FirebaseFirestore firebaseFirestore;
    FirestoreRecyclerAdapter<PostitRecyclerView,PositViewHolder>adaptadorParaPostitFirebase;
    StaggeredGridLayoutManager ordenarRecycleView;
    Bundle bundle;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_postits,container,false);

        //ID
        botonCreaPostit = view.findViewById(R.id.boton_crea_postit);
        listaDePost = view.findViewById(R.id.ListaDinamica);
        //FIREBASE
        firebaseAutenticacion = FirebaseAuth.getInstance();
        firebaseUsuario = FirebaseAuth.getInstance().getCurrentUser();
        firebaseFirestore = FirebaseFirestore.getInstance();
        bundle= new Bundle();

         botonCreaPostit.setOnClickListener(v -> {
             CrearPost crearPost= new CrearPost();
             FragmentTransaction transaction = getFragmentManager().beginTransaction();
             transaction.replace(R.id.nav_host_fragment_activity_main, crearPost);
             transaction.commit();
         });

        Query query = firebaseFirestore.collection("posts").document(firebaseUsuario.getUid()).collection("mi post").orderBy("titulo",Query.Direction.ASCENDING);
        FirestoreRecyclerOptions<PostitRecyclerView> listaDeTodo = new FirestoreRecyclerOptions.Builder<PostitRecyclerView>().setQuery(query,PostitRecyclerView.class).build();
        adaptadorParaPostitFirebase = new FirestoreRecyclerAdapter<PostitRecyclerView,PositViewHolder>(listaDeTodo){
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            protected void onBindViewHolder(@NonNull PositViewHolder positViewHolder, int i,@NonNull PostitRecyclerView postitRecyclerView) {

                ImageView menutresopciones = positViewHolder.itemView.findViewById(R.id.menudelospostits);
                positViewHolder.crearposttitulo.setText(postitRecyclerView.getTitulo());
                positViewHolder.crearpostcontenido.setText(postitRecyclerView.getContenido());
                String iddocumento = adaptadorParaPostitFirebase.getSnapshots().getSnapshot(i).getId();

                positViewHolder.itemView.setOnClickListener(v -> {

                });

                menutresopciones.setOnClickListener(v -> {
                    PopupMenu popupMenu = new PopupMenu(v.getContext(),v);
                    popupMenu.setGravity(Gravity.END);

                    popupMenu.getMenu().add("Eliminar").setOnMenuItemClickListener(item -> {

                        DocumentReference documentoReferenciado = firebaseFirestore.collection("posts").document(firebaseUsuario.getUid()).collection("mi post").document(iddocumento);
                        documentoReferenciado.delete().addOnSuccessListener(unused -> Toast.makeText(getContext(),"Postit eliminado",Toast.LENGTH_SHORT).show()).addOnFailureListener(e -> Toast.makeText(getContext(),"Fallo al borrar el Postit ",Toast.LENGTH_SHORT).show());

                        return false;
                    });
                    popupMenu.show();
                });
            }

            @NonNull
            @Override
            public PositViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = inflater.inflate(R.layout.post_recycle,container,false);
                return new PositViewHolder(view);
            }

        };

        listaDePost.setHasFixedSize(true);
        ordenarRecycleView = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        listaDePost.setLayoutManager(ordenarRecycleView);
        listaDePost.setAdapter(adaptadorParaPostitFirebase);

        return view;
    }
    public static class PositViewHolder extends RecyclerView.ViewHolder{
        TextView crearposttitulo;
        TextView crearpostcontenido;
        LinearLayout postlinearlayout;

        public PositViewHolder(@NonNull View itemView){
            super(itemView);
            crearposttitulo = itemView.findViewById(R.id.crearposttitulo);
            crearpostcontenido = itemView.findViewById(R.id.crearpostcontenido);
            postlinearlayout = itemView.findViewById(R.id.postlinearlayout);
        }

    }

    @Override
    public void onStart() {
        super.onStart();
        adaptadorParaPostitFirebase.startListening();
    }
    @Override
    public void onStop() {
        super.onStop();
        if(adaptadorParaPostitFirebase!=null)
        {
            adaptadorParaPostitFirebase.stopListening();
        }
    }
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menuopciones_postitsfragment,menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.salir) {
            firebaseAutenticacion.signOut();
            getActivity().onBackPressed();
            startActivity(new Intent(getContext(), MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}