package main.primera_evaluación.model;

import java.util.Objects;

public class Cliente extends Usuario{
    private String nombreCompleto;

    public Cliente(Long id, String nombreUsuario, String contraseña, String nombreCompleto) {
        super(id, nombreUsuario, contraseña);
        this.nombreCompleto = nombreCompleto;
    }

    public Cliente() {
    }


    /// ME SURGIÓ ACA LA DUDA DE COMO SE TRABAJA EL RETORNO
    // YA QUE PREVIAMENTE SE RETORBNARIAN OBJETOS DE LA CLASE USUARIO (POR LA HERENCIA)
    public Cliente nombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
        return this;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nombreCompleto, cliente.nombreCompleto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nombreCompleto);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                "} " + super.toString();
    }
}
