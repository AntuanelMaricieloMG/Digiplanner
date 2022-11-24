package com.example.digiplanner.ui.postits;

public class PostitRecyclerView {

    String tituloPost;
    String contenidoPost;

    public PostitRecyclerView(String tituloPost,String contenidoPost){
        this.tituloPost=tituloPost;
        this.contenidoPost=contenidoPost;
    }

    public PostitRecyclerView(){

    }

    public String getTituloPost() {
        return tituloPost;
    }

    public void setTituloPost(String tituloPost) {
        this.tituloPost = tituloPost;
    }

    public String getContenidoPost() {
        return contenidoPost;
    }

    public void setContenidoPost(String contenidoPost) {
        this.contenidoPost = contenidoPost;
    }
}
