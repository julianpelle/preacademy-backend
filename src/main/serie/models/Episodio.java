package main.serie.models;

import java.util.Objects;

public class Episodio {
private String titulo;
private String descripcion;
private boolean fueVisto;
private int calificacion;


    public Episodio(String titulo, String descripcion, boolean fueVisto, int calificacion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fueVisto = fueVisto;
        this.calificacion = calificacion;
    }

    public Episodio(String titulo, String descripcion, boolean fueVisto) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fueVisto = fueVisto;
        this.calificacion = -1;
    }


    public Episodio titulo(String value){
        this.titulo = value;
        return this;
    }
    public Episodio calificacion(int value){
        this.calificacion = value;
        return this;
    }



    public Episodio() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isFueVisto() {
        return fueVisto;
    }

    public void setFueVisto(boolean fueVisto) {
        this.fueVisto = fueVisto;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Episodio episodio = (Episodio) o;
        return fueVisto == episodio.fueVisto && calificacion == episodio.calificacion && Objects.equals(titulo, episodio.titulo) && Objects.equals(descripcion, episodio.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, descripcion, fueVisto, calificacion);
    }

    @Override
    public String toString() {
        return "Episodio{" +
                "titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fueVisto=" + fueVisto +
                ", calificacion=" + calificacion +
                '}';
    }
}

