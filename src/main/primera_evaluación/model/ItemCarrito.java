package main.primera_evaluación.model;

import java.util.Objects;

public class ItemCarrito {
    private Producto producto;
    private int cantidad;

    public ItemCarrito() {
    }

    public ItemCarrito(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public ItemCarrito producto(Producto producto) {
        this.producto = producto;
        return this;
    }

    public ItemCarrito cantidad(int cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double calcularSubtotal(){
       return producto.getPrecio() * cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemCarrito that = (ItemCarrito) o;
        return cantidad == that.cantidad && Objects.equals(producto, that.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producto, cantidad);
    }

    @Override
    public String toString() {
        return "ItemCarrito{" +
                "producto=" + producto +
                ", cantidad=" + cantidad +
                '}';
    }
}

