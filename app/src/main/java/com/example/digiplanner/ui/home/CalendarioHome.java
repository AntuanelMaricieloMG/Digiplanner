package com.example.digiplanner.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.digiplanner.R;
import com.example.digiplanner.databinding.FragmentHomeBinding;
import com.example.digiplanner.ui.AdaptadorGridDias;

import org.w3c.dom.ls.LSException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CalendarioHome extends LinearLayout {

    Button botonVolver,botonSiguiente;
    TextView FechaMes;
    GridView gridMes;
    Context context;
    static final int CALENDAR_DAYS = 42;
    Calendar calendario = Calendar.getInstance(Locale.ENGLISH);

    List<Date> fecha = new ArrayList<>();
    List<EventoCalendario> calendar = new ArrayList<>();

    SimpleDateFormat formatofecha = new SimpleDateFormat("MMMM yyyy",Locale.ENGLISH);
    SimpleDateFormat formatofechames = new SimpleDateFormat("MMMM" , Locale.ENGLISH);
    SimpleDateFormat formatofechaaño = new SimpleDateFormat("yyyy",Locale.ENGLISH);


    public CalendarioHome(Context context) {
        super(context);
    }

    public CalendarioHome(Context context,@Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.calendario_home,this);

        //ID
        botonSiguiente = view.findViewById(R.id.boton_Siguiente);
        botonVolver = view.findViewById(R.id.boton_Volver);
        FechaMes = view.findViewById(R.id.MesCalendario);
        gridMes = (GridView) view.findViewById(R.id.gridViewMes);
        //AdaptadorGridDias adaptador= new AdaptadorGridDias(getActivity(),numero);
        //gridMes.setAdapter(adaptador);
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

    }
    private void Setup(){
        String dateFechaCalendario = formatofecha.format(calendario.getTime());
        FechaMes.setText(dateFechaCalendario);
    }
}