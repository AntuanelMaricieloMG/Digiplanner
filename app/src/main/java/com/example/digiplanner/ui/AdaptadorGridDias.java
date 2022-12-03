package com.example.digiplanner.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.digiplanner.R;
import com.example.digiplanner.ui.home.EventoCalendario;

import org.checkerframework.checker.units.qual.A;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AdaptadorGridDias extends ArrayAdapter {

    List<Date> dates;
    Calendar fechaMes;
    List<EventoCalendario> eventos;
    LayoutInflater inflater;
    String date,mes,año;

    public AdaptadorGridDias(@NonNull Context context, List<Date> dates, Calendar fechaMes , List<EventoCalendario> eventos) {
        super(context,R.layout.grid_dias );
        this.dates=dates;
        this.fechaMes=fechaMes;
        this.eventos=eventos;
        inflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Date monthDate = dates.get(position);
        Calendar dateCalendar = Calendar.getInstance();
        dateCalendar.setTime(monthDate);
        int DayNo = dateCalendar.get(Calendar.DAY_OF_MONTH);
        int displayMonth = dateCalendar.get(Calendar.MONTH)+1;
        int displayYear = dateCalendar.get(Calendar.YEAR);
        int currentMonth = fechaMes.get(Calendar.MONTH)+1;
        int currentYear = fechaMes.get(Calendar.YEAR);

        View view = convertView;
        if(view == null){
            view  = inflater.inflate(R.layout.grid_dias,parent,false);
        }
        if(displayMonth == currentMonth && displayYear == currentYear){
            view.setBackgroundColor(getContext().getResources().getColor(R.color.blue));
        }
        else
        {
            view.setBackgroundColor(Color.parseColor("#FFFF0000"));
        }

        TextView Day_number = view.findViewById(R.id.grid_numero_dia);
        TextView numeroDeEvento = view.findViewById(R.id.grid_espacio);
        Day_number.setText(String.valueOf(DayNo));
        //PRUEBA guarda evento en lista array
        /*Toast.makeText(getContext(),date+mes+año,Toast.LENGTH_SHORT).show();

        Calendar CalendarioDeEventos = Calendar.getInstance();
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i=0;i<eventos.size();i++)
        {
            CalendarioDeEventos.setTime(FechaString(eventos.get(i).getDATE()));
            if(DayNo == CalendarioDeEventos.get(Calendar.DAY_OF_MONTH)
               && displayMonth == CalendarioDeEventos.get(Calendar.MONTH)+1
               && displayYear == CalendarioDeEventos.get(Calendar.YEAR))
            {
                arrayList.add(eventos.get(i).getEVENTOS());
                numeroDeEvento.setText(arrayList.size()+"eventos");
            }
        }*/


        return view;
    }

    @Override
    public int getCount() {
        return dates.size();
    }

    @Override
    public int getPosition(@Nullable Object item) {
        return dates.indexOf(item);
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }

    public void  Guardar(String mes, String date, String año){
        this.mes= mes;
        this.date = date;
        this.año = año;
    }
    private Date FechaString(String eventDate){
        SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-ddd", Locale.ENGLISH);
        Date diaFecha = null;
        try
        {
            diaFecha = format.parse(eventDate);
        }catch (ParseException e)
        {
            e.printStackTrace();
        }
        return diaFecha;

    /*Context context;
    String[] numeroDia;
    TextView textDia;

    LayoutInflater inflater;

    public AdaptadorGridDias(Context context,String[] numeroDia){
        this.context=context;
        this.numeroDia=numeroDia;
    }

    @Override
    public int getCount() {
        return numeroDia.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grid_dias, parent,false);

        }

        textDia =(TextView) convertView.findViewById(R.id.grid_numero_dia);
        textDia.setText(numeroDia[position]);
        return convertView;

    }*/
}}
