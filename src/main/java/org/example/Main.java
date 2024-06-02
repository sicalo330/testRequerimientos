package org.example;

import org.example.controladores.ControladorProducto;
import org.example.model.Deportista;
import org.example.model.Producto;
import org.example.model.Usuario;
import org.example.repositorio.AccesoBaseDeDatos;

import java.beans.JavaBean;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Deportista deportista = new Deportista(1,100000,31023123,"example@gmail.com","123sads45","M","Pepito","Perez","Deportista");
        System.out.println(deportista.getId());
    }
}