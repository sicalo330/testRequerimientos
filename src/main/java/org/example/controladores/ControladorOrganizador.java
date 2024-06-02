package org.example.controladores;

import org.example.model.Deportista;
import org.example.model.Evento;
import org.example.model.Organizador;
import org.example.repositorio.BaseDatosDeportistas;
import org.example.repositorio.BaseDatosEventos;
import org.example.repositorio.BaseDatosOrganizadores;
import org.example.repositorio.BaseDatosRegistro;

public class ControladorOrganizador {
    private BaseDatosDeportistas baseDatosDeportistas;
    private BaseDatosEventos baseDatosEventos;
    private BaseDatosOrganizadores baseDatosOrganizadores;
    private Evento evento;
    private ControladorCongreso controladorCongreso;

    public ControladorOrganizador(BaseDatosDeportistas baseDatosDeportistas, BaseDatosEventos baseDatosEventos, BaseDatosOrganizadores baseDatosOrganizadores, ControladorCongreso controladorCongreso){
        this.baseDatosDeportistas = baseDatosDeportistas;
        this.baseDatosEventos = baseDatosEventos;
        this.baseDatosOrganizadores = baseDatosOrganizadores;
        this.controladorCongreso = controladorCongreso;
    }

    public Deportista consultarInformacionEquipo(Deportista deportista){
        return  baseDatosDeportistas.obtener(deportista.getId());
    }

    public Evento consultarInformacionEvento(Evento evento){
        return baseDatosEventos.obtenerEvento(evento.getId());
    }

    public Evento consultarInformacionLogistica(Evento evento){
        return baseDatosEventos.actualizarEvento(evento);
    }

    public Organizador consultarInformacionOrganizador(Organizador organizador){
        return baseDatosOrganizadores.obtener(organizador.getId());
    }

    public Evento solicitarCrearEvento(Evento evento,ControladorCongreso controladorCongreso){
        return controladorCongreso.evaluarEvento(evento);
    }

    public Evento crearEvento(Evento evento){
        return controladorCongreso.crearEvento(evento);
    }
}
