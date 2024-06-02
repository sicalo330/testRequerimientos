package org.example.controladores;

import org.example.model.Producto;
import org.example.model.Usuario;
import org.example.repositorio.BaseDatosRegistro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ControladorRegistroTest {
    @Mock
    private BaseDatosRegistro baseDatosRegistro;

    @Test
    void registrar(){
        Usuario usuarioEntrada =
                new Usuario(1,100000,31023123,"example@gmail.com","12345","M","Pepito","Perez","");
        Usuario usuarioSalida =
                new Usuario(1,100000,31023123,"example@gmail.com","12345","M","Pepito","Perez","");
        ControladorRegistro controladorRegistro = new ControladorRegistro(baseDatosRegistro);

        Mockito.when(baseDatosRegistro.guardar(usuarioEntrada)).thenReturn(null);
        Mockito.when(baseDatosRegistro.obtener(usuarioEntrada.getId())).thenReturn(usuarioSalida);//Debe retornar aunque en realidad fuera nulo

        Usuario usuarioResultado = controladorRegistro.registrar(usuarioEntrada);//usuario salida

        Assertions.assertEquals(usuarioResultado,usuarioSalida);
    }
    //1 testeo
}