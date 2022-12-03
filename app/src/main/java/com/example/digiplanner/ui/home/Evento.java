package com.example.digiplanner.ui.home;

public class Evento {

    String nombre;
    String hora;
    String fecha;

    public Evento(String nombre, String hora, String fecha) {
        this.nombre = nombre;
        this.hora = hora;
        this.fecha = fecha;
    }

    public Evento(){};

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }







}
