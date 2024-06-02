package org.example.controladores;

import org.example.model.Juego;
import org.example.repositorio.BaseDatosCongreso;

public class ControladorDeportistas {

    private BaseDatosCongreso baseDatosCongreso;

    public ControladorDeportistas(BaseDatosCongreso baseDatosCongreso){
        this.baseDatosCongreso = baseDatosCongreso;
    }

    public Juego verEstadistica(Juego juego){
        return baseDatosCongreso.obtenerEstadisticasJuegos(juego);
    }

    public Juego verTiempoJuego(Juego juego){
       return baseDatosCongreso.obtenerAtributosJuego(juego);
    }
}
