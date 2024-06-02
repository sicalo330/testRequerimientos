package org.example.repositorio;

import org.example.model.Usuario;

public class BaseDatosInicioSesion {//Se supone que usuario ya está creado, aquí el usuario está enviando los datos de los campos rellenados
    private BaseDatosRegistro baseDatosRegistro;

    public BaseDatosInicioSesion(BaseDatosRegistro baseDatosRegistro){
        this.baseDatosRegistro = baseDatosRegistro;
    }
    public Usuario consultarEnvio(Usuario usuario){//Devolverá un usuario registrado, consulta la información enviada
        baseDatosRegistro.obtener(usuario.getId());//usuario logeado
        return usuario;//En teoría retorna lo que el usuario puso en los campos
    }

    public Usuario concederPermisosDeRol(Usuario usuario,String rol){
        if(rol == "Espectador"){
            return baseDatosRegistro.concederPermisosEspectador(usuario);
        }
        if(rol == "Deportista"){
            return baseDatosRegistro.concederPermisosDeportista(usuario);
        }
        if (rol == "Persona normal"){
            return baseDatosRegistro.concederPermisosOrganizador(usuario);
        }
        return null;
    }
}
