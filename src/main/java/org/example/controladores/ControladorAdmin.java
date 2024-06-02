package org.example.controladores;

import org.example.model.Usuario;
import org.example.repositorio.*;

public class ControladorAdmin {
    private BaseDatosDeportistas baseDatosDeportistas;
    private BaseDatosCongreso baseDatosCongreso;
    private BaseDatosRegistro baseDatosRegistro;
    private BaseDatosInicioSesion baseDatosInicioSesion;
    private BaseDatosOrganizadores baseDatosOrganizadores;
    private BaseDatosEventos baseDatosEventos;

    public ControladorAdmin(BaseDatosDeportistas baseDatosDeportistas, BaseDatosCongreso baseDatosCongreso, BaseDatosRegistro baseDatosRegistro, BaseDatosInicioSesion baseDatosInicioSesion, BaseDatosOrganizadores baseDatosOrganizadores, BaseDatosEventos baseDatosEventos) {
        this.baseDatosDeportistas = baseDatosDeportistas;
        this.baseDatosCongreso = baseDatosCongreso;
        this.baseDatosRegistro = baseDatosRegistro;
        this.baseDatosInicioSesion = baseDatosInicioSesion;
        this.baseDatosOrganizadores = baseDatosOrganizadores;
        this.baseDatosEventos = baseDatosEventos;
    }

    public Usuario eliminarUsuario(Usuario usuario){
        return baseDatosRegistro.borrar(usuario);
    }
}
