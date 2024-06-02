package org.example.controladores;

import org.example.model.Usuario;
import org.example.repositorio.BaseDatosRegistro;

public class ControladorRegistro {
    private BaseDatosRegistro baseDatosRegistro;
    private Usuario usuario;

    public ControladorRegistro(BaseDatosRegistro baseDatosRegistro){
        this.baseDatosRegistro = baseDatosRegistro;
    }

    public Usuario registrar(Usuario usuario){
        baseDatosRegistro.guardar(usuario);//null
        return baseDatosRegistro.obtener(usuario.getId());
    }

}
