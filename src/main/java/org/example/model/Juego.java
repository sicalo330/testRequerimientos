package org.example.model;

import org.example.repositorio.BaseDatosCongreso;

public class Juego {
    private String nombre_juego;
    private String fecha;
    private String modalidad;
    private String descripcion;
    private BaseDatosCongreso baseDatosCongreso;
    private String estadísticas;

    public Juego(String nombre_juego, String fecha, String modalidad, String descripcion, String estadísticas ,BaseDatosCongreso baseDatosCongreso) {
        this.nombre_juego = nombre_juego;
        this.fecha = fecha;
        this.modalidad = modalidad;
        this.descripcion = descripcion;
        this.estadísticas = estadísticas;
        this.baseDatosCongreso = baseDatosCongreso;
    }

    public String getNombre_juego() {
        return nombre_juego;
    }

    public void setNombre_juego(String nombre_juego) {
        this.nombre_juego = nombre_juego;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BaseDatosCongreso getBaseDatosCongreso() {
        return baseDatosCongreso;
    }

    public void setBaseDatosCongreso(BaseDatosCongreso baseDatosCongreso) {
        this.baseDatosCongreso = baseDatosCongreso;
    }

    public Juego obtenerJuego(Juego juego){
        return baseDatosCongreso.hacerEvento(juego);
    }
}
