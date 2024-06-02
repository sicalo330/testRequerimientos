package org.example.controladores;

import org.example.model.Deportista;
import org.example.model.Evento;
import org.example.model.Juego;
import org.example.model.Organizador;
import org.example.repositorio.BaseDatosCongreso;
import org.example.repositorio.BaseDatosInicioSesion;
import org.example.repositorio.BaseDatosRegistro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ControladorDeportistasTest {

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
    void verEstadisticasJuegos(){
        Juego juegoEntrada =
                new Juego("Baloncesto","en algún moemento", "élite","Contacto físico entre hombres","Momentos importante, puntos, ligas, ganadores y perdedores",baseDatosCongreso);
        Juego juegoSalida =
                new Juego("Baloncesto","en algún moemento", "élite","Contacto físico entre hombres","Momentos importante, puntos, ligas, ganadores y perdedores",baseDatosCongreso);
        ControladorDeportistas controladorDeportistas = new ControladorDeportistas(baseDatosCongreso);
        Mockito.when(baseDatosCongreso.obtenerEstadisticasJuegos(juegoEntrada)).thenReturn(juegoSalida);
        Juego juegoResultado = controladorDeportistas.verEstadistica(juegoEntrada);
        System.out.println(juegoResultado);
        System.out.println(juegoSalida);
        System.out.println(juegoEntrada);

        Assertions.assertEquals(juegoResultado,juegoSalida);
    }

    @Test
    void verTiempoJuegos(){
        Juego juegoEntrada =
                new Juego("Baloncesto","en algún moemento", "élite","Contacto físico entre hombres","Momentos importante, puntos, ligas, ganadores y perdedores",baseDatosCongreso);
        Juego juegoSalida =
                new Juego("Baloncesto","en algún moemento", "élite","Contacto físico entre hombres","Momentos importante, puntos, ligas, ganadores y perdedores",baseDatosCongreso);
        ControladorDeportistas controladorDeportistas = new ControladorDeportistas(baseDatosCongreso);
        Mockito.when(baseDatosCongreso.obtenerAtributosJuego(juegoEntrada)).thenReturn(juegoSalida);
        Juego juegoResultado = controladorDeportistas.verTiempoJuego(juegoEntrada);
        System.out.println(juegoResultado);
        System.out.println(juegoSalida);
        System.out.println(juegoEntrada);

        Assertions.assertEquals(juegoResultado,juegoSalida);
    }
    //2 testeos
}