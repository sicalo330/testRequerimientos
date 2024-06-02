package org.example.controladores;

import org.example.model.Producto;
import org.example.repositorio.AccesoBaseDeDatos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControladorProducto {
    //TODO Simular una BD
    private AccesoBaseDeDatos accesoBaseDeDatos;

    public ControladorProducto(AccesoBaseDeDatos accesoBaseDeDatos) {
        this.accesoBaseDeDatos = accesoBaseDeDatos;
    }

    public Producto guardarProducto(Producto producto) {
        accesoBaseDeDatos.guardar(producto);
        return accesoBaseDeDatos.obtener(producto.getId());
    }
}
