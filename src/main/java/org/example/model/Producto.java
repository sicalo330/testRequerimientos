package org.example.model;

public class Producto {

    private int id;
    private Integer stock;
    private String nombre;
    private String descripcion;
    private Double precio;

    public Producto() {
    }


    public Producto(Integer id, Integer stock, String nombre, String descripcion, Double precio) {
        this.id = id;
        this.stock = stock;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", stock=" + stock +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                '}';
    }
}
