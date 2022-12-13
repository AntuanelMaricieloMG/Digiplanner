package com.example.digiplanner.ui.home;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.example.digiplanner.R;
import com.example.digiplanner.ui.AdaptadorGridDias;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CalendarioHome extends LinearLayout {

    ImageButton botonVolver,botonSiguiente;
    TextView FechaMes;
    GridView gridMes;
    Context context;
    static final int todosDiasCalendario = 42;
    Calendar calendario = Calendar.getInstance(Locale.ENGLISH);
    AdaptadorGridDias adaptadorGridDias;


    List<Date> fecha = new ArrayList<>();
    List<EventoCalendario> ListaDeEventos = new ArrayList<>();

    SimpleDateFormat formatofecha = new SimpleDateFormat("MMMM yyyy",Locale.ENGLISH);
    //SimpleDateFormat formatofechames = new SimpleDateFormat("MMMM" , Locale.ENGLISH);
    //SimpleDateFormat formatofechaaño = new SimpleDateFormat("yyyy",Locale.ENGLISH);

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

        botonVolver.setOnClickListener(v -> {
            calendario.add(Calendar.MONTH,-1);
            Setup();
        });
        botonSiguiente.setOnClickListener(v -> {
            calendario.add(Calendar.MONTH,1);
            Setup();
        });
        /*
        gridMes.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context,"a",Toast.LENGTH_SHORT).show();
                final String date = formatofecha.format(fecha.get(position));
                final String mes = formatofechames.format(fecha.get(position));
                final String año = formatofechaaño.format(fecha.get(position));
                Toast.makeText(context,date+mes+año,Toast.LENGTH_SHORT).show();

            }

        });*/

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

        while(fecha.size() < todosDiasCalendario){
            fecha.add(calendarioMuestraMes.getTime());
            calendarioMuestraMes.add(Calendar.DAY_OF_MONTH , 1);

        }

        adaptadorGridDias = new AdaptadorGridDias(context,fecha,calendario,ListaDeEventos);
        gridMes.setAdapter(adaptadorGridDias);

    }

}