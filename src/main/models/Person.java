package main.models;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Person {

    private String nombre;
    private String apellido;
    private int edad;
    private LocalDate fechaNacimiento;
    private int dni;
    private String sexo;
    private double peso;
    private double altura;

    public Person(String nombre,String apellido, LocalDate fechaNacimiento, int dni, String sexo, double peso, double altura) {
        this.nombre = nombre;
        this.apellido=apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = this.ObtenerEdad();
        this.dni = dni;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    public Person(int dni) {
        this.nombre = "N";
        this.apellido="A";
        this.fechaNacimiento = LocalDate.of(2000, 1, 1);
        this.edad = this.ObtenerEdad();
        this.dni = dni;
        this.sexo = "F";
        this.peso = 1;
        this.altura = 1;
    }


    public Person(int dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = LocalDate.of(2000, 1, 1);
        this.edad = this.ObtenerEdad();
        this.sexo = "F";
        this.peso = 1;
        this.altura = 1;
    }

    public Person(String nombre, int dni, LocalDate fechaNacimiento, String apellido) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.apellido = apellido;
        this.edad = this.ObtenerEdad();
        this.sexo = "F";
        this.peso = 1;
        this.altura = 1;
    }

    public int ObtenerEdad(){
      LocalDate hoy = LocalDate.now();
      if(hoy.getMonthValue() < fechaNacimiento.getMonthValue() || (hoy.getMonthValue() == fechaNacimiento.getMonthValue() && hoy.getDayOfMonth() < fechaNacimiento.getDayOfMonth())){
          return  hoy.getYear()-this.fechaNacimiento.getYear() -1;
      }
          return  hoy.getYear()-this.fechaNacimiento.getYear() ;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getDni() {
        return dni;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double obtenerIMC(){
        return this.peso / Math.pow(this.altura, 2);
    }

    public boolean estaEnForma(){
        if(this.obtenerIMC() > 18.5 && this.obtenerIMC()<25){
            return  true;
        }
        return false;
    }

    public boolean esCumpleaños(){

        return (this.fechaNacimiento.getMonth().equals(LocalDate.now().getMonth()) && this.fechaNacimiento.getDayOfMonth() == LocalDate.now().getDayOfMonth());
    }

    public boolean esMayor(){
        return this.edad >= 18;
    }

    public boolean puedeVotar(){
        return this.edad >= 16;
    }

    public boolean edadCorrecta(){
        return this.edad == this.ObtenerEdad();
    }

    @Override
    public String toString() {
        return "Datos de: "+this.nombre +" "+ this.apellido
                +"\nDNI: " + this.dni + " Fecha de nacimiento: " + this.fechaNacimiento + " Edad: "+this.edad
                + " Sexo: "+ this.sexo + "\nAltura: "+this.altura+"m, Peso: "+this.peso+"kg";
    }



}



