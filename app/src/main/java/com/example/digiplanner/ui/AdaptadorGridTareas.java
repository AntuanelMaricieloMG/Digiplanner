package com.example.digiplanner.ui;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import com.example.digiplanner.R;
import com.example.digiplanner.ui.anadir.AnadirTareaCaracteristicas;
import java.util.List;

public class AdaptadorGridTareas extends RecyclerView.Adapter<AdaptadorGridTareas.ViewHolder>  {


    List<String> nombreElementos;
    List<Integer> images;

    int numero;
    String numeroString;
    LayoutInflater inflater;
    AppCompatActivity activity;


    public AdaptadorGridTareas(Context context,List<String> nombreElementos, List<Integer> images ){
        this.nombreElementos=nombreElementos;
        this.images=images;
        this.inflater = LayoutInflater.from(context);
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.grid_tareas,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.elemento.setText(nombreElementos.get(position));
        holder.icon.setImageResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        return nombreElementos.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView elemento;
        ImageView icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            elemento = itemView.findViewById(R.id.textView);
            icon = itemView.findViewById(R.id.boton_tareas);
            itemView.setOnClickListener(v -> {
                numero = getAdapterPosition();
                numeroString = String.valueOf(numero);
                Toast.makeText(v.getContext(),numeroString,Toast.LENGTH_SHORT).show();

                activity = (AppCompatActivity)v.getContext();

                AnadirTareaCaracteristicas f = new AnadirTareaCaracteristicas();


                f.setTextNumero(numero);
                FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main, f);

                transaction.addToBackStack(null);
                transaction.commit();

            });
        }
    }
}
