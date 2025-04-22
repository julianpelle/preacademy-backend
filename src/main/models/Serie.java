package main.models;

import main.Exception.TemporadaInvalidaException;

import java.util.ArrayList;
import java.util.Objects;

public class Serie {

private String titulo;
private String descripcion;
private String creador;
private String genero;
private ArrayList<Temporada> temporadas;


    public Serie(String titulo, String descripcion, String creador, String genero) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.creador = creador;
        this.genero = genero;
        this.temporadas = new ArrayList<>();
    }

    public Serie(String titulo, String descripcion, String creador, String genero, ArrayList<Temporada> temporadas) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.creador = creador;
        this.genero = genero;
        this.temporadas = temporadas;
    }

    public Serie() {
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

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public ArrayList<Temporada> getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(ArrayList<Temporada> temporadas) {
        this.temporadas = temporadas;
    }

    public void agregarTemporada(Temporada t){
        this.temporadas.add(t);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return Objects.equals(titulo, serie.titulo) && Objects.equals(descripcion, serie.descripcion) && Objects.equals(creador, serie.creador) && Objects.equals(genero, serie.genero) && Objects.equals(temporadas, serie.temporadas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, descripcion, creador, genero, temporadas);
    }

    @Override
    public String toString() {
        return "Serie{" +
                "titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", creador='" + creador + '\'' +
                ", genero='" + genero + '\'' +
                ", temporadas=" + temporadas +
                '}';
    }

    public void agregarCalificacion(int calificacion,String titulo_episodio){
        if(calificacion>0 && calificacion<=5) {
            for (Temporada t : this.temporadas ) {
                for (Episodio e : t.getEpisodios() ) {
                    if(e.getTitulo().equalsIgnoreCase(titulo_episodio)){
                        if(e.isFueVisto()){
                            e.setCalificacion(calificacion);
                        }else{
                            System.out.println("Para calificar el episodio debe haberlo visto");
                        }
                        return;
                    }
                    System.out.println("Episodio no encontrado con el titulo: " + titulo_episodio + " en la temporada "+ t.getNombre());
                }
            }
        }else {
            System.out.println("Indique una calificacion entre 1 y 5 estrellas");
        }

    }


    public int totalEpisodiosVistos() {
        int vistos = 0;
        for (Temporada t : this.temporadas) {
            vistos += t.totalEpisodiosVistos();
        }
        return vistos;
    }

    public double promedioCalificaciones() {
        int suma = 0;
        int cantidad = 0;
        for (Temporada t : this.temporadas) {
            for (Episodio e : t.getEpisodios()) {
                if (e.isFueVisto() && e.getCalificacion() > 0) {
                    suma += e.getCalificacion();
                    cantidad++;
                }
            }
        }
        return cantidad > 0 ? (double) suma / cantidad : 0;
    }

    public boolean vioTodosLosEpisodios() {
        for (Temporada t : this.temporadas) {
            for (Episodio e : t.getEpisodios()) {
                if (!e.isFueVisto()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean vioTodaLaTemporada(int temp) throws TemporadaInvalidaException {
        if (temp <= 0 || temp > this.temporadas.size()) {
            throw new TemporadaInvalidaException("Número de temporada inválido");
        }else{
            Temporada t = this.temporadas.get(temp-1);
            for(Episodio e : t.getEpisodios()){
                if (!e.isFueVisto()) {
                    return false;
                }
            }
            return true;
        }

    }

    public double promedioCalificacionTemporada(int temp) throws TemporadaInvalidaException {
        if (temp <= 0 || temp > this.temporadas.size()) {
            throw new TemporadaInvalidaException("Número de temporada inválido");
        }else{
            Temporada t = this.temporadas.get(temp-1);
            return t.promedioCalificaciones();
        }

    }


    public void agregarEpisodioATemporada(int temp,Episodio e) throws TemporadaInvalidaException {
        if (temp <= 0 || temp > this.temporadas.size()) {
            throw new TemporadaInvalidaException("Número de temporada inválido");
        }else{
            Temporada t = this.temporadas.get(temp-1);
            t.agregarEpisodio(e);
        }

    }
}
