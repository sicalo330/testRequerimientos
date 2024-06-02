package org.example.controladores;

import org.example.model.Espectador;
import org.example.model.Juego;
import org.example.model.Noticias;
import org.example.model.Usuario;
import org.example.repositorio.BaseDatosCongreso;
import org.example.repositorio.BaseDatosInicioSesion;
import org.example.repositorio.BaseDatosRegistro;

public class ControladorUsuario {
    private ControladorRegistro controladorRegistro;
    private BaseDatosRegistro baseDatosRegistro;
    private BaseDatosCongreso baseDatosCongreso;
    private BaseDatosInicioSesion baseDatosInicioSesion;
    private Usuario usuario;

    public ControladorUsuario(BaseDatosRegistro baseDatosRegistro, BaseDatosCongreso baseDatosCongreso, BaseDatosInicioSesion baseDatosInicioSesion, Usuario usuario){
        this.baseDatosRegistro = baseDatosRegistro;
        this.baseDatosCongreso = baseDatosCongreso;
        this.baseDatosInicioSesion = baseDatosInicioSesion;
        this.usuario = usuario;
    }


    public Usuario acceder(Usuario usuario){//Sería el equivalente a rellenar los campos de correo y contraseña
        controladorRegistro.registrar(usuario);
        return null;
    }

    public Usuario darPermisosDeRol(Usuario usuario){
        return baseDatosInicioSesion.concederPermisosDeRol(usuario, usuario.getRol());
    }

    public Usuario recuperarContraseña(String string){
        return baseDatosRegistro.obtener(usuario.getId());
    }

    public Usuario solicitarActualización(Usuario usuario){
        baseDatosRegistro.obtener(usuario.getId());
        return baseDatosRegistro.actualizar(usuario);
    }

    public Juego verJuegos(Juego juego){
        return juego.obtenerJuego(juego);
    }

    public Juego verResultados(Juego juego){
        return baseDatosCongreso.obtenerJuego(juego);
    }

    public Juego verinfomrmacionEspecifica(Juego juego){
        return baseDatosCongreso.obtenerAtributosJuego(juego);
    }

    public Noticias verNoticias(Noticias noticias){
        return baseDatosCongreso.obtenerNoticia(noticias);
    }
}
