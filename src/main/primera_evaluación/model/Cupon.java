package main.primera_evaluación.model;

import java.util.Objects;

public class Cupon {

    private String codigo;
    private double porcentajeDescuento;

    public Cupon() {
    }

    public Cupon(String codigo, double porcentajeDescuento) {
        this.codigo = codigo;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public Cupon codigo(String codigo){
        this.codigo = codigo;
        return this;
    }

    public Cupon porcentajeDescuento(double porcentajeDescuento){
        this.porcentajeDescuento = porcentajeDescuento;
        return this;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cupon cupon = (Cupon) o;
        return Double.compare(porcentajeDescuento, cupon.porcentajeDescuento) == 0 && Objects.equals(codigo, cupon.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, porcentajeDescuento);
    }

    @Override
    public String toString() {
        return "Cupon{" +
                "codigo='" + codigo + '\'' +
                ", porcentajeDescuento=" + porcentajeDescuento +
                '}';
    }
}
