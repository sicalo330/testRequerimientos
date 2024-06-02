package org.example.controladores;

import org.example.model.Usuario;
import org.example.repositorio.BaseDatosInicioSesion;
import org.example.repositorio.BaseDatosRegistro;

public class ControladorInicioSesion {
    private BaseDatosInicioSesion baseDatosInicioSesion;
    private Usuario usuario;

    public ControladorInicioSesion(BaseDatosInicioSesion baseDatosInicioSesion){
        this.baseDatosInicioSesion = baseDatosInicioSesion;
    }

    public Usuario buscarUsuario(Usuario usuario){
        return baseDatosInicioSesion.consultarEnvio(usuario);//usuario entrada
    }
}
