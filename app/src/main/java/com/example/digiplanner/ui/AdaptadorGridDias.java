package com.example.digiplanner.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.digiplanner.R;
import com.example.digiplanner.ui.home.EventoCalendario;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AdaptadorGridDias extends ArrayAdapter {

    List<Date> dates;
    Calendar fechaMes;
    List<EventoCalendario> eventos;
    LayoutInflater inflater;


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
            view.setBackgroundResource(R.drawable.grid_dias_design);
        }
        else
        {
            view.setBackgroundResource(R.drawable.grid_dias_design2);
        }

        TextView Day_number = view.findViewById(R.id.grid_numero_dia);
        Day_number.setText(String.valueOf(DayNo));


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





}
