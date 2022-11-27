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

    public String getEVENTOS() {
        return EVENTOS;
    }

    public String getTIEMPO() {
        return TIEMPO;
    }

    public String getDATE() {
        return DATE;
    }

    public String getMONTH() {
        return MONTH;
    }

    public String getYEAR() {
        return YEAR;
    }

    public void setEVENT(String EVENTOS) {
        this.EVENTOS = EVENTOS;
    }

    public void setTIME(String TIEMPO) {
        this.TIEMPO = TIEMPO;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    public void setMONTH(String MONTH) {
        this.MONTH = MONTH;
    }

    public void setYEAR(String YEAR) {
        this.YEAR = YEAR;
    }
}
