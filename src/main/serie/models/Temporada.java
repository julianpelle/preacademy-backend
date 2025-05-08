package main.serie.models;

import java.util.ArrayList;
import java.util.Objects;

public class Temporada {

    private String nombre;
    private String descripcion;
    private ArrayList<Episodio> episodios;

    public Temporada(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.episodios = new ArrayList<>();
    }

    public Temporada(String nombre, String descripcion, ArrayList<Episodio> episodios) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.episodios = episodios;
    }

    public Temporada() {
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


    public ArrayList<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(ArrayList<Episodio> episodios) {
        this.episodios = episodios;
    }

    public void agregarEpisodio(Episodio e){
        this.episodios.add(e);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Temporada temporada = (Temporada) o;
        return Objects.equals(nombre, temporada.nombre) && Objects.equals(descripcion, temporada.descripcion) && Objects.equals(episodios, temporada.episodios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, descripcion, episodios);
    }

    @Override
    public String toString() {
        return "Temporada{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", episodios=" + episodios +
                '}';
    }

    public int totalEpisodiosVistos() {
        int vistos = 0;
        for (Episodio e : this.episodios) {
            if (e.isFueVisto()) {
                vistos++;
            }
        }
        return vistos;
    }

    public double promedioCalificaciones() {
        int suma = 0;
        int cantidad = 0;
        for (Episodio e : this.episodios) {
            if (e.isFueVisto() && e.getCalificacion() > 0) {
                suma += e.getCalificacion();
                cantidad++;
            }
        }
        return cantidad > 0 ? (double) suma / cantidad : 0;
    }


}
