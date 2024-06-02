package org.example.model;

public class CongresoDeportivo {
    private String nombre;
    private String lugar;
    private String fechaCreacion;
    private Organizador organizador;
    private Deportista deportista;

    public CongresoDeportivo(String nombre, String lugar, String fechaCreacion, Organizador organizador, Deportista deportista) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fechaCreacion = fechaCreacion;
        this.organizador = organizador;
        this.deportista = deportista;
    }

}
