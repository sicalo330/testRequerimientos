package org.example.model;

import org.example.repositorio.BaseDatosOrganizadores;

import java.util.Objects;

public class  Organizador extends Usuario {
    private BaseDatosOrganizadores baseDatosOrganizadores;
    public Organizador(Integer id, Integer identificaion, Integer telefono, String correo, String contraseña, String genero, String primerNombre, String segundoNombre,String rol) {
        super(id, identificaion, telefono, correo, contraseña, genero, primerNombre, segundoNombre,rol);
    }

    public void verLogistica(){

    }

    public void organizarEvento(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organizador that = (Organizador) o;
        return Objects.equals(baseDatosOrganizadores, that.baseDatosOrganizadores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseDatosOrganizadores);
    }
}
