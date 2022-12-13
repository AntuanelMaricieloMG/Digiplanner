package com.example.digiplanner.ui.anadir;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.example.digiplanner.R;
import com.example.digiplanner.ui.home.HomeFragment;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public class AnadirTareaCaracteristicas extends Fragment {

    TextView tituloTarea,horaSeleccionadatarea,fechaSeleccionadatarea ;
    EditText tareaNueva;
    RelativeLayout elegirHora,elegirFecha,tareaCreada;
    int numero,dia,mes,year;
    FirebaseFirestore firebaseFirestore;
    FirebaseUser firebaseUsuario;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_anadirtareacaracteristicas,container,false);
        //ID
        tituloTarea = view.findViewById(R.id.titulo_anadirtarea);
        tareaNueva = view.findViewById(R.id.escribe_nuevatarea);
        horaSeleccionadatarea = view.findViewById(R.id.texto_horaseleccionadatarea);
        fechaSeleccionadatarea = view.findViewById(R.id.texto_fechaseleccionadatarea);
        elegirHora = view.findViewById(R.id.boton_selectorhoratarea);
        elegirFecha = view.findViewById(R.id.boton_selectorfechatarea);
        tareaCreada = view.findViewById(R.id.boton_creartareanueva);
        //BBDD
        firebaseUsuario = FirebaseAuth.getInstance().getCurrentUser();
        firebaseFirestore = FirebaseFirestore.getInstance();


        switch (numero){
            case 0 :
                tituloTarea.setText("Limpieza");
                break;
            case 1 :
                tituloTarea.setText("Documentos");
                break;
            case 2 :
                tituloTarea.setText("Muebles");
                break;
            case 3 :
                tituloTarea.setText("Decoración");
                break;
            case 4 :
                tituloTarea.setText("Compras");
                break;
            case 5 :
                tituloTarea.setText("Cita medica");
                break;
            case 6 :
                tituloTarea.setText("Medicación");
                break;
            case 7 :
                tituloTarea.setText("Documentación");
                break;
            case 8 :
                tituloTarea.setText("Eventos familiares");
                break;
            case 9 :
                tituloTarea.setText("Examen");
                break;
            case 10 :
                tituloTarea.setText("Tareas");
                break;
            case 11 :
                tituloTarea.setText("Trabajos");
                break;
            case 12 :
                tituloTarea.setText("Links importantes");
                break;
            case 13 :
                tituloTarea.setText("Links informacion");
                break;


        }
        elegirFecha.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            year = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), (view12, year, month, dayOfMonth) -> {
                String format_dia,format_mes;
                if(dayOfMonth < 10)
                {
                    format_dia = "0" + dayOfMonth;

                }else
                {
                    format_dia = String.valueOf(dayOfMonth);
                }

                int monthofcalendar = month +1;

                if(monthofcalendar <10)
                {
                    format_mes = "0" + monthofcalendar;
                }else
                {
                    format_mes = String.valueOf(monthofcalendar);
                }

                fechaSeleccionadatarea.setText(format_dia+ "/"+format_mes+"/"+year);
            },dia,mes,year);
            datePickerDialog.show();
        });

        elegirHora.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int horas = calendar.get(Calendar.HOUR_OF_DAY);
            int minutos = calendar.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), android.R.style.Theme_Holo_Dialog
                    , (view1, hourOfDay, minute) -> {
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
                cal.set(Calendar.MINUTE, minute);
                cal.setTimeZone(TimeZone.getDefault());
                SimpleDateFormat hformate = new SimpleDateFormat("K:mm a", Locale.ENGLISH);
                String event_Time = hformate.format(cal.getTime());
                horaSeleccionadatarea.setText(event_Time);
                Toast.makeText(getActivity().getApplicationContext(),event_Time,Toast.LENGTH_SHORT).show();


            },horas,minutos,false);
            timePickerDialog.show();
        });

        tareaCreada.setOnClickListener(v -> {
            Toast.makeText(getActivity().getApplicationContext(),"Listo",Toast.LENGTH_SHORT).show();
            String tt = tituloTarea.getText().toString().trim();
            String tn = tareaNueva.getText().toString().trim();
            String fs = fechaSeleccionadatarea.getText().toString().trim();

            Map<String,Object> map = new HashMap<>();
            map.put("nombre",tt);
            map.put("hora",tn);
            map.put("fecha",fs);
            firebaseFirestore.collection("evento").add(map).addOnSuccessListener(documentReference -> {
            }).addOnFailureListener(e -> {
            });

            HomeFragment calendario= new HomeFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.nav_host_fragment_activity_main, calendario);
            transaction.commit();
        });
        return view;
    }

    public int setTextNumero(int numero){
        this.numero=numero;
        return numero;
    }

}