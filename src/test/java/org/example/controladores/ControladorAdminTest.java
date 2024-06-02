package org.example.controladores;

import org.example.model.Usuario;
import org.example.repositorio.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.naming.ldap.Control;

import static org.junit.jupiter.api.Assertions.*;

class ControladorAdminTest {

    @Mock
    private BaseDatosInicioSesion baseDatosInicioSesion;
    @Mock
    private BaseDatosRegistro baseDatosRegistro;
    @Mock
    private BaseDatosCongreso baseDatosCongreso;
    @Mock
    private BaseDatosEventos baseDatosEventos;
    @Mock
    private BaseDatosOrganizadores baseDatosOrganizadores;
    @Mock
    private BaseDatosDeportistas baseDatosDeportistas;


    @BeforeEach
    void setUp() {
        baseDatosInicioSesion = Mockito.mock(BaseDatosInicioSesion.class);
        baseDatosRegistro = Mockito.mock(BaseDatosRegistro.class);
        baseDatosCongreso = Mockito.mock(BaseDatosCongreso.class);
        baseDatosDeportistas = Mockito.mock(BaseDatosDeportistas.class);
        baseDatosEventos = Mockito.mock(BaseDatosEventos.class);
        baseDatosOrganizadores = Mockito.mock(BaseDatosOrganizadores.class);
    }

    @Test
    void eliminarUsuario(){
        Usuario usuarioEntrada =
                new Usuario(1,100000,31023123,"example@gmail.com","12345","M","Pepito","Perez","");
        Usuario usuarioEsperado =
                new Usuario(1,100000,31023123,"example@gmail.com","12345","M","Pepito","Perez","");
        ControladorAdmin controlador = new ControladorAdmin(baseDatosDeportistas, baseDatosCongreso, baseDatosRegistro, baseDatosInicioSesion, baseDatosOrganizadores, baseDatosEventos);
        Mockito.when(baseDatosRegistro.borrar(usuarioEntrada)).thenReturn(null);
        Usuario usuarioResultado = controlador.eliminarUsuario(usuarioEntrada);//De ser nulo
        System.out.println(usuarioResultado);
        System.out.println(usuarioEntrada);
        System.out.println(usuarioEsperado);

        Assertions.assertNotEquals(usuarioResultado,usuarioEsperado);

    }
    //1 testeo
}