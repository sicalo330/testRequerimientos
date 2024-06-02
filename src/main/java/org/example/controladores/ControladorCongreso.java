package org.example.controladores;

import org.example.model.Evento;
import org.example.repositorio.BaseDatosCongreso;

public class ControladorCongreso {
    private Evento evento;
    private BaseDatosCongreso baseDatosCongreso;

    public ControladorCongreso(BaseDatosCongreso baseDatosCongreso){
    this.baseDatosCongreso = baseDatosCongreso;
    }

    public Evento evaluarEvento(Evento evento){
        return baseDatosCongreso.evaluarSolicitud(evento);
    }

    public Evento crearEvento(Evento evento){
        return baseDatosCongreso.crearEvento(evento);
    }
}
