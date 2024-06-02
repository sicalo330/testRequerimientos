package org.example.controladores;

import org.example.model.Evento;
import org.example.model.Organizador;
import org.example.repositorio.BaseDatosCongreso;
import org.example.repositorio.BaseDatosDeportistas;
import org.example.repositorio.BaseDatosEventos;
import org.example.repositorio.BaseDatosOrganizadores;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.naming.ldap.Control;

import static org.junit.jupiter.api.Assertions.*;

class ControladorCongresoTest {
    @Mock
    private BaseDatosCongreso baseDatosCongreso;
    @Mock
    private BaseDatosDeportistas baseDatosDeportistas;
    @Mock
    private BaseDatosEventos baseDatosEventos;
    @Mock
    private BaseDatosOrganizadores baseDatosOrganizadores;
    @BeforeEach
//Por alguna razón hace que el error this.algo is null no aparezca
    void setUp() {
        baseDatosCongreso = Mockito.mock(BaseDatosCongreso.class);
        baseDatosDeportistas = Mockito.mock(BaseDatosDeportistas.class);
        baseDatosEventos = Mockito.mock(BaseDatosEventos.class);
        baseDatosOrganizadores= Mockito.mock(BaseDatosOrganizadores.class);
    }

    @Test
    void solicitarCrearEvento(){
        Organizador organizadorFulano =
                new Organizador(1,100000,31023123,"example@gmail.com","12345","M","Fulano","De tal","Organizador");
        Evento eventoEntrada =
                new Evento(1,"Tennis de mesa","2 de febrero 2024","Deportivo perdeira", "Univerisda de Caldas",5,organizadorFulano);
        Evento eventoEsperado =
                new Evento(1,"Tennis de mesa","2 de febrero 2024","Deportivo perdeira", "Univerisda de Caldas",5,organizadorFulano);
        ControladorCongreso controladorCongreso = new ControladorCongreso(baseDatosCongreso);
        ControladorOrganizador controladorOrganizador = new ControladorOrganizador(baseDatosDeportistas,  baseDatosEventos, baseDatosOrganizadores,controladorCongreso);
        Mockito.when(baseDatosCongreso.evaluarSolicitud(eventoEntrada)).thenReturn(eventoEsperado);
        Evento eventoResultado = controladorOrganizador.solicitarCrearEvento(eventoEntrada, controladorCongreso);
        System.out.println(eventoResultado);
        System.out.println(eventoEntrada);
        System.out.println(eventoEsperado);

        Assertions.assertEquals(eventoResultado, eventoEsperado);
    }

    @Test
    void crearEvento(){
        Organizador organizadorFulano =
                new Organizador(1,100000,31023123,"example@gmail.com","12345","M","Fulano","De tal","Organizador");
        Evento eventoEntrada =
                new Evento(1,"Tennis de mesa","2 de febrero 2024","Deportivo perdeira", "Univerisda de Caldas",5,organizadorFulano);
        Evento eventoEsperado =
                new Evento(1,"Tennis de mesa","2 de febrero 2024","Deportivo perdeira", "Univerisda de Caldas",5,organizadorFulano);
        ControladorCongreso controladorCongreso = new ControladorCongreso(baseDatosCongreso);
        ControladorOrganizador controladorOrganizador = new ControladorOrganizador(baseDatosDeportistas,  baseDatosEventos, baseDatosOrganizadores, controladorCongreso);
        Mockito.when(baseDatosCongreso.crearEvento(eventoEntrada)).thenReturn(eventoEsperado);
        Evento eventoResultado = controladorOrganizador.crearEvento(eventoEntrada);
        System.out.println(eventoResultado);
        System.out.println(eventoEntrada);
        System.out.println(eventoEsperado);

        Assertions.assertEquals(eventoResultado, eventoEsperado);
    }
    //2 testeos
}