package org.example.model;

import org.example.repositorio.BaseDatosCongreso;

public class MiniJuegos extends Juego{
    public MiniJuegos(String nombre_juego, String fecha, String modalidad, String descripcion, String estadísticas, BaseDatosCongreso baseDatosCongreso) {
        super(nombre_juego, fecha, modalidad, descripcion, estadísticas, baseDatosCongreso);
    }
}
