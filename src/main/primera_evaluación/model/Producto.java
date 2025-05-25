package main.primera_evaluación.model;

import java.util.Objects;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private String categoria;

    public Producto() {
    }

    public Producto(int id, String nombre, double precio, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public Producto id(int id) {
        this.id = id;
        return this;
    }

    public Producto nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Producto precio(double precio) {
        this.precio = precio;
        return this;
    }

    public Producto categoria(String categoria) {
        this.categoria = categoria;
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    //Desafio extra 2
    //Lo cree desde el generate de intellij excluyendo el atributo categoria, no se si vale
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return id == producto.id && Double.compare(precio, producto.precio) == 0 && Objects.equals(nombre, producto.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, precio);
    }

    @Override
    public String toString() {
        return "| Producto id = " + id +
                " | " + nombre +
                " | precio = $" + precio +
                " | categoria = " + categoria +
                " |";
    }







}
