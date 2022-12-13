package com.example.digiplanner.ui.home;

import androidx.fragment.app.Fragment;

public class EventoCalendario extends Fragment {
    String EVENTOS,TIEMPO,DATE,MONTH,YEAR;

    //CONSTRUCTOR RECIBE PARAMETROS
    public EventoCalendario(String EVENTOS, String TIEMPO, String DATE, String MONTH , String YEAR){
        this.EVENTOS = EVENTOS;
        this.TIEMPO = TIEMPO;
        this.DATE = DATE;
        this.MONTH = MONTH;
        this.YEAR = YEAR;
    }

}
