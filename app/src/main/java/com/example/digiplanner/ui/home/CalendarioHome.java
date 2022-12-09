package com.example.digiplanner.ui.home;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digiplanner.R;
import com.example.digiplanner.ui.AdaptadorGridDias;
import com.example.digiplanner.ui.AdaptadorGridTareas;
import com.example.digiplanner.ui.AdaptadorRecycler;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class CalendarioHome extends LinearLayout {

    ImageButton botonVolver,botonSiguiente;
    TextView FechaMes;
    GridView gridMes;

    Context context;
    static final int todosDiasCalendario = 42;
    Calendar calendario = Calendar.getInstance(Locale.ENGLISH);
    AdaptadorGridDias adaptadorGridDias;
    String m ,y;


    List<Date> fecha = new ArrayList<>();
    List<EventoCalendario> ListaDeEventos = new ArrayList<>();

    SimpleDateFormat formatofecha = new SimpleDateFormat("MMMM yyyy",Locale.ENGLISH);
    SimpleDateFormat formatofechames = new SimpleDateFormat("MMMM" , Locale.ENGLISH);
    SimpleDateFormat formatofechaaño = new SimpleDateFormat("yyyy",Locale.ENGLISH);




    public CalendarioHome(Context context) {
        super(context);
    }

    @SuppressLint("MissingInflatedId")
    public CalendarioHome(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.calendario_home,this);



        //ID
        botonSiguiente = view.findViewById(R.id.boton_Siguiente);
        botonVolver = view.findViewById(R.id.boton_Volver);
        FechaMes = view.findViewById(R.id.MesCalendario);
        gridMes = (GridView) view.findViewById(R.id.gridViewMes);
        Setup();

        botonVolver.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                calendario.add(Calendar.MONTH,-1);
                Setup();
            }
        });
        botonSiguiente.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                calendario.add(Calendar.MONTH,1);
                Setup();
            }
        });

        gridMes.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context,"a",Toast.LENGTH_SHORT).show();
                final String date = formatofecha.format(fecha.get(position));
                final String mes = formatofechames.format(fecha.get(position));
                final String año = formatofechaaño.format(fecha.get(position));
                Toast.makeText(context,date+mes+año,Toast.LENGTH_SHORT).show();
                /*AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setCancelable(true);
                View vistaNuevoEvento = LayoutInflater.from(parent.getContext()).inflate(R.layout.calendario_nuevoevento,parent,false);

                //ID
                @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText EventName = vistaNuevoEvento.findViewById(R.id.grid_espacio);
                TextView EventTime = vistaNuevoEvento.findViewById(R.id.texto_horaseleccionada);
                Button SetTime = vistaNuevoEvento.findViewById(R.id.boton_selectorhora);
                Button AddEvent = vistaNuevoEvento.findViewById(R.id.boton_eventocreado);


                SetTime.setOnClickListener(v -> {
                    Calendar calendar = Calendar.getInstance();
                    int horas = calendar.get(Calendar.HOUR_OF_DAY);
                    int minutos = calendar.get(Calendar.MINUTE);
                    TimePickerDialog timePickerDialog = new TimePickerDialog(vistaNuevoEvento.getContext(), androidx.appcompat.R.style.Theme_AppCompat_Dialog
                            , (view1, hourOfDay, minute) -> {
                        Calendar cal = Calendar.getInstance();
                        cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        cal.set(Calendar.MINUTE, minute);
                        cal.setTimeZone(TimeZone.getDefault());
                        SimpleDateFormat hformate = new SimpleDateFormat("K:mm a",Locale.ENGLISH);
                        String event_Time = hformate.format(cal.getTime());
                        EventTime.setText(event_Time);

                    },horas,minutos,false);
                    timePickerDialog.show();
                });
                final String date = formatofecha.format(fecha.get(position));
                final String mes = formatofechames.format(fecha.get(position));
                final String año = formatofechaaño.format(fecha.get(position));



                AddEvent.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Obtener fecha
                        Toast.makeText(context,"boton funciona evento nuevo",Toast.LENGTH_SHORT).show();

                        //adaptadorGridDias.Guardar(date,mes,año);
                        //GuardarEvento(EventName.getText().toString(),EventTime.getText().toString(),date,mes,año);

                        Setup();
                        alertDialog.dismiss();

                    }
                });
                builder.setView(vistaNuevoEvento);
                alertDialog = builder.create();
                alertDialog.show();*/
            }

        });

    }

    public CalendarioHome(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    private void Setup(){
        String dateFechaCalendario = formatofecha.format(calendario.getTime());
        FechaMes.setText(dateFechaCalendario);
        fecha.clear();
        Calendar calendarioMuestraMes = (Calendar) calendario.clone();
        calendarioMuestraMes.set(Calendar.DAY_OF_MONTH,1);
        int primerDiaMes = calendarioMuestraMes.get(Calendar.DAY_OF_WEEK)-1;
        calendarioMuestraMes.add(Calendar.DAY_OF_MONTH, -primerDiaMes);
        //EventosPorMes(m,y);
        
        while(fecha.size() < todosDiasCalendario){
            fecha.add(calendarioMuestraMes.getTime());
            calendarioMuestraMes.add(Calendar.DAY_OF_MONTH , 1);

        }

        adaptadorGridDias = new AdaptadorGridDias(context,fecha,calendario,ListaDeEventos);
        gridMes.setAdapter(adaptadorGridDias);

    }

}