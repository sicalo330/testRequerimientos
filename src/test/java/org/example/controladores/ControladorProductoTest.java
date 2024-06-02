package org.example.controladores;

import org.example.model.Producto;
import org.example.repositorio.AccesoBaseDeDatos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ControladorProductoTest {

    @Mock
    private AccesoBaseDeDatos accesoBaseDeDatos;

    @Test
    void guardarProducto() {
        Producto productoEntrada =
                new Producto(1, 1, "Perro Doble", "Pan, salchicha, queso", 20000.);
        Producto productoEsperado =
                new Producto(1, 1, "Perro Doble", "Pan, salchicha, queso", 20000.);
        ControladorProducto controladorProducto = new ControladorProducto(accesoBaseDeDatos);
        Mockito.when(accesoBaseDeDatos.guardar(productoEntrada)).thenReturn(null);
        Mockito.when(accesoBaseDeDatos.obtener(productoEntrada.getId())).thenReturn(productoEsperado);

        Producto productoResultado = controladorProducto.guardarProducto(productoEntrada);

        Assertions.assertEquals(productoResultado, productoEsperado);

    }
}