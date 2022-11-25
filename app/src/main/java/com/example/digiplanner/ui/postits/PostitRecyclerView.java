package com.example.digiplanner.ui.postits;

public class PostitRecyclerView {

    String titulo;
    String contenido;

    public PostitRecyclerView(String titulo,String contenido){
        this.titulo=titulo;
        this.contenido=contenido;
    }

    public PostitRecyclerView(){

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTituloPost(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
