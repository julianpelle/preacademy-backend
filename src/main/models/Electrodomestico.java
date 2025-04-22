package main.models;

import java.util.Objects;

public class Electrodomestico {

   private String nombre;
    private double precio_base;
    private String color;
    private int consumo_energetico;
    private double peso;


    public Electrodomestico() {
        this.nombre = "producto_por_defecto";
        this.precio_base = 100;
        this.color = "gris plata";
        this.consumo_energetico = 10;
        this.peso = 2;
    }

    public Electrodomestico(String nombre, double precio_base, String color, int consumo_energetico, double peso) {
        this.nombre = nombre;
        this.precio_base = precio_base;
        this.color = color;
        this.consumo_energetico = consumo_energetico;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio_base() {
        return precio_base;
    }

    public void setPrecio_base(double precio_base) {
        this.precio_base = precio_base;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getConsumo_energetico() {
        return consumo_energetico;
    }

    public void setConsumo_energetico(int consumo_energetico) {
        this.consumo_energetico = consumo_energetico;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Electrodomestico that = (Electrodomestico) o;
        return Double.compare(precio_base, that.precio_base) == 0 && Double.compare(peso, that.peso) == 0 && Objects.equals(nombre, that.nombre) && Objects.equals(color, that.color) && Objects.equals(consumo_energetico, that.consumo_energetico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, precio_base, color, consumo_energetico, peso);
    }

    @Override
    public String toString() {
        return "Electrodomestico{" +
                "nombre='" + nombre + '\'' +
                ", precio_base=" + precio_base +
                ", color='" + color + '\'' +
                ", consumo_energetico='" + consumo_energetico + '\'' +
                ", peso=" + peso +
                '}';
    }

    public boolean esBajoConsumo(){
        return this.consumo_energetico <= 45;
    }

    public double calcularBalance(){
       return this.precio_base/this.peso;
    }

    public boolean esGamaAlta(){
        return this.calcularBalance() > 3;
    }


}

