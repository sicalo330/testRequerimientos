package org.example.controladores;

import org.example.model.Deportista;
import org.example.model.Evento;
import org.example.model.Organizador;
import org.example.repositorio.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ControladorOrganizadorTest {
    @Mock
    private BaseDatosDeportistas baseDatosDeportistas;
    @Mock
    private BaseDatosEventos baseDatosEventos;
    @Mock
    private BaseDatosOrganizadores baseDatosOrganizadores;
    @Mock
    private BaseDatosCongreso baseDatosCongreso;

    @BeforeEach//Por alguna razón hace que el error this.algo is null no aparezca
    void setUp() {
        baseDatosDeportistas = Mockito.mock(BaseDatosDeportistas.class);
        baseDatosEventos = Mockito.mock(BaseDatosEventos.class);
        baseDatosOrganizadores = Mockito.mock(BaseDatosOrganizadores.class);
    }



    @Test
    void consultarInformacionEquipo(){
        Deportista deportistaEntrada =
                new Deportista(1,100000,31023123,"example@gmail.com","12345","M","Pepito","Perez","Deportista");
        Deportista deportistaEsperado =
                new Deportista(1,100000,31023123,"example@gmail.com","12345","M","Pepito","Perez","Deportista");
        ControladorCongreso controladorCongreso = new ControladorCongreso(baseDatosCongreso);
        ControladorOrganizador controladorOrganizador = new ControladorOrganizador(baseDatosDeportistas, baseDatosEventos,baseDatosOrganizadores, controladorCongreso);
        Mockito.when(baseDatosDeportistas.obtener(deportistaEntrada.getId())).thenReturn(deportistaEsperado);
        Deportista deportistaResultado = controladorOrganizador.consultarInformacionEquipo(deportistaEntrada);
        System.out.println(deportistaResultado);
        System.out.println(deportistaEntrada);
        System.out.println(deportistaEsperado);

        Assertions.assertEquals(deportistaResultado,deportistaEsperado);
    }

    @Test
    void consultarInformacionEvento(){
        Organizador organizadorFulano =
                new Organizador(1,100000,31023123,"example@gmail.com","12345","M","Fulano","De tal","Organizador");
        Evento eventoEntrada =
                new Evento(1,"Tennis de mesa","2 de febrero 2024","Deportivo perdeira", "Uiverisda de Caldas",5,organizadorFulano);
        Evento eventoEsperado =
                new Evento(1,"Tennis de mesa","2 de febrero 2024","Deportivo perdeira", "Uiverisda de Caldas",5,organizadorFulano);
        ControladorCongreso controladorCongreso = new ControladorCongreso(baseDatosCongreso);
        ControladorOrganizador controladorOrganizador = new ControladorOrganizador(baseDatosDeportistas,baseDatosEventos, baseDatosOrganizadores,controladorCongreso);
        Mockito.when(baseDatosEventos.obtenerEvento(eventoEntrada.getId())).thenReturn(eventoEsperado);
        Evento eventoResultado = controladorOrganizador.consultarInformacionEvento(eventoEntrada);
        System.out.println(eventoEntrada);
        System.out.println(eventoEsperado);
        System.out.println(eventoResultado);

        Assertions.assertEquals(eventoResultado,eventoEsperado);
    }

    @Test
    void consultarInformacionLogistica(){
        Organizador organizadorFulano =
                new Organizador(1,100000,31023123,"example@gmail.com","12345","M","Fulano","De tal","Organizador");
        Evento eventoEntrada =
                new Evento(1,"Tennis de mesa","2 de febrero 2024","Deportivo perdeira", "Uiverisda de Caldas",5,organizadorFulano);
        Evento eventoEsperado =
                new Evento(1,"Tennis de mesa","2 de febrero 2024","Deportivo perdeira", "Uiverisda de Caldas",5,organizadorFulano);
        ControladorCongreso controladorCongreso = new ControladorCongreso(baseDatosCongreso);
        ControladorOrganizador controladorOrganizador = new ControladorOrganizador(baseDatosDeportistas, baseDatosEventos, baseDatosOrganizadores,controladorCongreso);
        Mockito.when(baseDatosEventos.actualizarEvento(eventoEntrada)).thenReturn(eventoEntrada);
        Evento eventoResultado = controladorOrganizador.consultarInformacionLogistica(eventoEntrada);

        Assertions.assertEquals(eventoEsperado, eventoResultado);
    }

    @Test
    void consultarInformacionOrganizadores(){
        Organizador organizadorEntrada =
                new Organizador(1,100000,31023123,"example@gmail.com","12345","M","Fulano","De tal","Organizador");
        Organizador organizadorSalida =
                new Organizador(1,100000,31023123,"example@gmail.com","12345","M","Fulano","De tal","Organizador");
        ControladorCongreso controladorCongreso = new ControladorCongreso(baseDatosCongreso);
        ControladorOrganizador controladorOrganizador = new ControladorOrganizador(baseDatosDeportistas, baseDatosEventos, baseDatosOrganizadores,controladorCongreso);
        Mockito.when(baseDatosOrganizadores.obtener(organizadorEntrada.getId())).thenReturn(organizadorSalida);
        Organizador organizadorResultado = controladorOrganizador.consultarInformacionOrganizador(organizadorEntrada);
        System.out.println(organizadorEntrada);
        System.out.println(organizadorSalida);

        Assertions.assertEquals(organizadorResultado, organizadorSalida);
    }
    //4 testeos
}