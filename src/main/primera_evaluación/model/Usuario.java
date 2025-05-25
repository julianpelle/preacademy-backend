package main.primera_evaluación.model;

import java.util.Objects;

public class Usuario {

    private Long id;
    private String nombreUsuario;
    private String contraseña;

    public Usuario(Long id, String nombreUsuario, String contraseña) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    public Usuario() {
    }

    // NO ESPECIFICA PATRON BUILDER LA CONSIGNA, DECIDÍ HACERLO POR LA FLEXIBILIDAD
    public Usuario id(Long id){
        this.id = id;
        return this;
    }
    public Usuario nombreUsuario(String nombreUsuario){
        this.nombreUsuario = nombreUsuario;
        return this;
    }
    public Usuario contraseña(String contraseña){
        this.contraseña = contraseña;
        return this;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(nombreUsuario, usuario.nombreUsuario) && Objects.equals(contraseña, usuario.contraseña);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombreUsuario, contraseña);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }
}
