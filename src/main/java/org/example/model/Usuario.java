package org.example.model;

import org.example.controladores.ControladorInicioSesion;
import org.example.controladores.ControladorRegistro;

import java.util.Objects;

public class Usuario {
    private ControladorRegistro controladorRegistro;

    private ControladorInicioSesion controladorInicioSesion;
    private Integer id;

    public ControladorInicioSesion getControladorInicioSesion() {
        return controladorInicioSesion;
    }

    public void setControladorInicioSesion(ControladorInicioSesion controladorInicioSesion) {
        this.controladorInicioSesion = controladorInicioSesion;
    }

    private Integer identificaion;
    private Integer telefono;
    private String correo;
    private String contraseña;
    private String genero;
    private String primerNombre;
    private String segundoNombre;
    private String rol;

    public Usuario(Integer id, Integer identificaion, Integer telefono, String correo, String contraseña, String genero, String primerNombre, String segundoNombre, String rol) {
        this.id = id;
        this.identificaion = identificaion;
        this.telefono = telefono;
        this.correo = correo;
        this.contraseña = contraseña;
        this.genero = genero;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.rol = rol;
    }

    public ControladorRegistro getControladorRegistro() {
        return controladorRegistro;
    }

    public void setControladorRegistro(ControladorRegistro controladorRegistro) {
        this.controladorRegistro = controladorRegistro;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdentificaion() {
        return identificaion;
    }

    public void setIdentificaion(Integer identificaion) {
        this.identificaion = identificaion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(controladorRegistro, usuario.controladorRegistro) && Objects.equals(controladorInicioSesion, usuario.controladorInicioSesion) && Objects.equals(id, usuario.id) && Objects.equals(identificaion, usuario.identificaion) && Objects.equals(telefono, usuario.telefono) && Objects.equals(correo, usuario.correo) && Objects.equals(contraseña, usuario.contraseña) && Objects.equals(genero, usuario.genero) && Objects.equals(primerNombre, usuario.primerNombre) && Objects.equals(segundoNombre, usuario.segundoNombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(controladorRegistro, controladorInicioSesion, id, identificaion, telefono, correo, contraseña, genero, primerNombre, segundoNombre);
    }
}
