package org.example.controladores;

import org.example.model.Juego;
import org.example.model.Noticias;
import org.example.model.Usuario;
import org.example.repositorio.BaseDatosCongreso;
import org.example.repositorio.BaseDatosInicioSesion;
import org.example.repositorio.BaseDatosRegistro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ControladorUsuarioTest {

    @Mock
    private BaseDatosInicioSesion baseDatosInicioSesion;
    @Mock
    private BaseDatosRegistro baseDatosRegistro;
    @Mock
    private BaseDatosCongreso baseDatosCongreso;


    @BeforeEach
    void setUp() {
        baseDatosInicioSesion = Mockito.mock(BaseDatosInicioSesion.class);
        baseDatosRegistro = Mockito.mock(BaseDatosRegistro.class);
        baseDatosCongreso = Mockito.mock(BaseDatosCongreso.class);
    }

    @Test
    void acceder(){
        Usuario usuarioEntrada =
                new Usuario(1,100000,31023123,"example@gmail.com","12345","M","Pepito","Perez","");
        Usuario usuariologeado =
                new Usuario(1,100000,31023123,"example@gmail.com","12345","M","Pepito","Perez","");

        ControladorInicioSesion controladorInicioSesion = new ControladorInicioSesion(baseDatosInicioSesion);
        Mockito.when(baseDatosInicioSesion.consultarEnvio(usuarioEntrada)).thenReturn(usuariologeado);
        Usuario usuarioResultado = controladorInicioSesion.buscarUsuario(usuarioEntrada);
        System.out.println(usuariologeado);
        System.out.println(usuarioResultado);

        Assertions.assertEquals(usuarioResultado,usuariologeado);
    }

    @Test
    void recuperarContraseña(){
        Usuario usuarioEntrada =
                new Usuario(1,100000,31023123,"example@gmail.com","12345","M","Pepito","Perez","");
        Usuario usuarioReal =
                new Usuario(1,100000,31023123,"example@gmail.com","12345","M","Pepito","Perez","");
        ControladorUsuario controladorUsuario = new ControladorUsuario(baseDatosRegistro, baseDatosCongreso,baseDatosInicioSesion,usuarioEntrada);
        Mockito.when(baseDatosRegistro.obtener(usuarioEntrada.getId())).thenReturn(usuarioReal);
        Usuario usuarioResultado = controladorUsuario.recuperarContraseña(usuarioEntrada.getCorreo());
        System.out.println(usuarioEntrada);
        System.out.println(usuarioReal);
        System.out.println(usuarioResultado);

        Assertions.assertEquals(usuarioReal.getContraseña(),usuarioResultado.getContraseña());
    }

    @Test
    void solicitarActualizacion(){
        Usuario usuarioEntrada =
                new Usuario(1,100000,31023123,"example@gmail.com","12345","M","Pepito","Perez","");
        Usuario usuarioSalida =
                new Usuario(1,100000,31023123,"example@gmail.com","12345","M","Pepito","Pulgarin","");
        ControladorUsuario controladorUsuario = new ControladorUsuario(baseDatosRegistro, baseDatosCongreso ,baseDatosInicioSesion,usuarioEntrada);
        Mockito.when(baseDatosRegistro.actualizar(usuarioEntrada)).thenReturn(usuarioSalida);
        Mockito.when(baseDatosRegistro.obtener(usuarioEntrada.getId())).thenReturn(null);
        Usuario usuarioResultado = controladorUsuario.solicitarActualización(usuarioEntrada);
        System.out.println(usuarioEntrada);
        System.out.println(usuarioSalida);
        System.out.println(usuarioResultado);

        Assertions.assertNotEquals(usuarioEntrada, usuarioResultado);//El usuario dfe entrada no puede ser igual al usuario actualizado, es decior que cambió
        Assertions.assertEquals(usuarioResultado, usuarioSalida);//El usuario de salida debe ser igual al usuario resultado, es decir que el cambio se ve reflejado
    }

    @Test
    void verJuegos(){
        Usuario usuarioPrueba =
                new Usuario(1,100000,31023123,"example@gmail.com","12345","M","Pepito","Perez","Espectador");
        Juego juegoEntrada =
                new Juego("Tennis de mesa", "6 de febrero del 2024", "recreativo","Un partido amistoso entre personas de la tercera edad","Momentos importante, puntos, ligas, ganadores y perdedores", baseDatosCongreso);
        Juego juegoSalida =
                new Juego("Tennis de mesa", "6 de febrero del 2024", "recreativo","Un partido amistoso entre personas de la tercera edad", "Momentos importante, puntos, ligas, ganadores y perdedores",baseDatosCongreso);
        ControladorUsuario controladorUsuario = new ControladorUsuario(baseDatosRegistro,baseDatosCongreso,baseDatosInicioSesion,usuarioPrueba);
        Mockito.when(baseDatosCongreso.hacerEvento(juegoEntrada)).thenReturn(juegoSalida);
        Juego juegoResultado = controladorUsuario.verJuegos(juegoEntrada);
        System.out.println(juegoEntrada);
        System.out.println(juegoSalida);
        System.out.println(juegoResultado);

        Assertions.assertEquals(juegoResultado, juegoSalida);
    }

    @Test
    void verResultados(){
        Usuario usuarioPrueba =
                new Usuario(1,100000,31023123,"example@gmail.com","12345","M","Pepito","Perez","Deportista");
        Juego juegoEntrada =
                new Juego("Tennis de mesa", "6 de febrero del 2024", "recreativo","Un partido amistoso entre personas de la tercera edad","Momentos importante, puntos, ligas, ganadores y perdedores", baseDatosCongreso);
        Juego juegoSalida =
                new Juego("Tennis de mesa", "6 de febrero del 2024", "recreativo","Un partido amistoso entre personas de la tercera edad","Momentos importante, puntos, ligas, ganadores y perdedores", baseDatosCongreso);
        ControladorUsuario controladorUsuario = new ControladorUsuario(baseDatosRegistro,baseDatosCongreso,baseDatosInicioSesion,usuarioPrueba);
        Mockito.when(baseDatosCongreso.obtenerJuego(juegoEntrada)).thenReturn(juegoSalida);
        Juego juegoResultado = controladorUsuario.verResultados(juegoEntrada);
        System.out.println(juegoEntrada);
        System.out.println(juegoSalida);
        System.out.println(juegoResultado);

        Assertions.assertEquals(juegoResultado, juegoSalida);
    }

    @Test
    void verInformacionEspecífica(){
        Usuario usuarioPrueba =
                new Usuario(1,100000,31023123,"example@gmail.com","12345","M","Pepito","Perez","Deportista");
        Juego juegoEntrada =
                new Juego("Tennis de mesa", "6 de febrero del 2024", "recreativo","Un partido amistoso entre personas de la tercera edad", "Momentos importante, puntos, ligas, ganadores y perdedores",baseDatosCongreso);
        Juego juegoSalida =
                new Juego("Tennis de mesa", "6 de febrero del 2024", "recreativo","Un partido amistoso entre personas de la tercera edad","Momentos importante, puntos, ligas, ganadores y perdedores",baseDatosCongreso);
        ControladorUsuario controladorUsuario = new ControladorUsuario(baseDatosRegistro,baseDatosCongreso,baseDatosInicioSesion,usuarioPrueba);
        Mockito.when(baseDatosCongreso.obtenerAtributosJuego(juegoEntrada)).thenReturn(juegoSalida);
        Juego juegoResultado = controladorUsuario.verinfomrmacionEspecifica(juegoEntrada);

        System.out.println(juegoEntrada);
        System.out.println(juegoSalida);
        System.out.println(juegoResultado);

        Assertions.assertEquals(juegoResultado, juegoSalida);
    }

    @Test
    void verNoticias(){
        Usuario usuarioPrueba =
                new Usuario(1,100000,31023123,"example@gmail.com","12345","M","Pepito","Perez","Espectador");
        Noticias noticiaEntrada =
                new Noticias("Secuestro masivo de princesas", "El chepo gonzales ha secuestrado a la princesa","Parálisis de gluteo","25 de febrero de 2069");
        Noticias noticiaSalida =
                new Noticias("Secuestro masivo de princesas", "El chepo gonzales ha secuestrado a la princesa","Parálisis de gluteo","25 de febrero de 2069");
        ControladorUsuario controladorUsuario = new ControladorUsuario(baseDatosRegistro, baseDatosCongreso,baseDatosInicioSesion,usuarioPrueba);
        Mockito.when(baseDatosCongreso.obtenerNoticia(noticiaEntrada)).thenReturn(noticiaSalida);
        Noticias noticiasResultado = controladorUsuario.verNoticias(noticiaEntrada);

        System.out.println(noticiasResultado);
        System.out.println(noticiaSalida);
        System.out.println(noticiaEntrada);

        Assertions.assertEquals(noticiasResultado,noticiaSalida);
    }

    @Test
    void elegirRolEspectador(){
        Usuario usuarioSinIniciarSesion =
                new Usuario(1,100000,31023123,"example@gmail.com","12345","M","Pepito","Perez","");
        Usuario usuarioEspectador =
                new Usuario(1,100000,31023123,"example@gmail.com","12345","M","Pepito","Perez","Espectador");
        ControladorUsuario controladorUsuario = new ControladorUsuario(baseDatosRegistro, baseDatosCongreso,baseDatosInicioSesion,usuarioSinIniciarSesion);
        Mockito.when(baseDatosInicioSesion.concederPermisosDeRol(usuarioSinIniciarSesion,usuarioSinIniciarSesion.getRol())).thenReturn(usuarioEspectador);
        Usuario usuarioResultado = controladorUsuario.darPermisosDeRol(usuarioSinIniciarSesion);


        Assertions.assertEquals(usuarioResultado,usuarioEspectador);
    }

    @Test
    void elegirRolDeportista(){
        Usuario usuarioSinIniciarSesion =
                new Usuario(1,100000,31023123,"example@gmail.com","12345","M","Pepito","Perez","");
        Usuario usuarioEspectador =
                new Usuario(1,100000,31023123,"example@gmail.com","12345","M","Pepito","Perez","Deportista");
        ControladorUsuario controladorUsuario = new ControladorUsuario(baseDatosRegistro, baseDatosCongreso,baseDatosInicioSesion,usuarioSinIniciarSesion);
        Mockito.when(baseDatosInicioSesion.concederPermisosDeRol(usuarioSinIniciarSesion,usuarioSinIniciarSesion.getRol())).thenReturn(usuarioEspectador);
        Usuario usuarioResultado = controladorUsuario.darPermisosDeRol(usuarioSinIniciarSesion);


        Assertions.assertEquals(usuarioResultado,usuarioEspectador);
    }

    @Test
    void elegirRolOrganizador(){
        Usuario usuarioSinIniciarSesion =
                new Usuario(1,100000,31023123,"example@gmail.com","12345","M","Pepito","Perez","");
        Usuario usuarioEspectador =
                new Usuario(1,100000,31023123,"example@gmail.com","12345","M","Pepito","Perez","organizador");
        ControladorUsuario controladorUsuario = new ControladorUsuario(baseDatosRegistro, baseDatosCongreso,baseDatosInicioSesion,usuarioSinIniciarSesion);
        Mockito.when(baseDatosInicioSesion.concederPermisosDeRol(usuarioSinIniciarSesion,usuarioSinIniciarSesion.getRol())).thenReturn(usuarioEspectador);
        Usuario usuarioResultado = controladorUsuario.darPermisosDeRol(usuarioSinIniciarSesion);

        Assertions.assertEquals(usuarioResultado,usuarioEspectador);
    }
    //10 testeos

}