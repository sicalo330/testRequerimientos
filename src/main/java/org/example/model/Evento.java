package org.example.model;

import java.util.Objects;

public class Evento {
    private Integer id;
    private String deporte;
    private String fecha;
    private String equipos;
    private String lugar;
    private int hora;
    private Organizador organizador;

    public Evento(Integer id,String deporte, String fecha, String equipos, String lugar, int hora, Organizador organizador) {
        this.id = id;
        this.deporte = deporte;
        this.fecha = fecha;
        this.equipos = equipos;
        this.lugar = lugar;
        this.hora = hora;
        this.organizador = organizador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEquipos() {
        return equipos;
    }

    public void setEquipos(String equipos) {
        this.equipos = equipos;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public Organizador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evento evento = (Evento) o;
        return hora == evento.hora && Objects.equals(id, evento.id) && Objects.equals(deporte, evento.deporte) && Objects.equals(fecha, evento.fecha) && Objects.equals(equipos, evento.equipos) && Objects.equals(lugar, evento.lugar) && Objects.equals(organizador, evento.organizador);
    }

}
