package org.example.model;

public class Noticias {
    private String titulo;
    private String contenido;
    private String autor;
    private String fechaPublicacion;

    public Noticias(String titulo, String contenido, String autor, String fechaPublicacion) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
    }

    // Getters y Setters para los atributos
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    // Método para mostrar la información de la noticia
    public void mostrarNoticia() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Fecha de Publicación: " + fechaPublicacion);
        System.out.println("Contenido: " + contenido);
    }
}
