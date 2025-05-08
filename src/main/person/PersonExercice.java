package main.person;

import main.person.models.Person;

import java.time.LocalDate;

public class PersonExercice {
    public static void main(String[] args) {

        // Welcome!
        // En este ejercicio van a trabajar con constructores, atributos por defecto,
        // lógica de validación y cálculo, y encapsulamiento.

        // CONSIGNA 1:
        // Crear una clase llamada "Persona" fuera de esta clase.

        // CONSIGNA 2:
        // La clase debe tener los siguientes atributos privados:
        // - nombre
        // - edad
        // - fechaNacimiento
        // - dni
        // - sexo
        // - peso
        // - altura

        // CONSIGNA 3:
        // Declarar los siguientes valores por defecto para cada atributo:
        // - nombre = "N"
        // - sexo = "F"
        // - fechaNacimiento = 1 de enero de 2000
        // - peso = 1
        // - altura = 1
        // - dni no tiene valor por defecto (es obligatorio)

        // CONSIGNA 4:
        // Crear diferentes constructores para la clase:
        // - Constructor con solo DNI (usa todos los valores por defecto)
        // - Constructor con DNI, nombre y apellido
        // - Constructor con DNI, nombre, apellido y fecha de nacimiento

        // CONSIGNA 5:
        // Agregar los métodos set para cada atributo, excepto el DNI.

        // CONSIGNA 6:
        // Agregar método que retorne el índice de masa corporal (peso en kg / altura en m^2)

        // CONSIGNA 7:
        // Agregar método que devuelva true si el IMC está entre 18.5 y 25 inclusive (la persona esta en forma).

        // CONSIGNA 8:
        // Agregar método que indique si es el día de cumpleaños de la persona:
        // Retorna true si hoy es el día y mes de su cumpleaños.

        // CONSIGNA 9:
        // Agregar método que indique si la persona es mayor de edad (retorna true si tiene más de 18 años).

        // CONSIGNA 10:
        // Agregar método que indique si la persona puede votar (retorna true si tiene 16 años o más).

        // CONSIGNA 11:
        // Agregar método que indique si la relación entre la edad de la persona y la fecha de nacimiento es coherente:
        // Compara la edad con la fecha de nacimiento para verificar si coinciden.

        // CONSIGNA 12:
        // Agregar método para mostrar un resumen de la información de la persona en formato String

        // CONSIGNA 13:
        // Crear al menos 3 objetos Persona con distintos constructores desde este método main.
        // Llamar y probar todos los métodos de instancia desde aquí.

        // ¡A programar!

        LocalDate fecha1 = LocalDate.of(2002,4,22);
        LocalDate fecha2 = LocalDate.of(2004,1,26);

        Person p1 = new Person("Maria",12356478,fecha1,"Perez");
        p1.setAltura(1.60);
        p1.setPeso(55);
        p1.setEdad(14);

        Person p2 = new Person("Juan","Doe",fecha2,12354678,"Masculino",115,1.60);
        Person p3 = new Person(12345678);
        System.out.println("==== \n" + p3.toString()+ "\n==== \n");
        System.out.println("==== \n" + p2.toString()+ "\n==== \n");
        System.out.println("==== \n" + p1.toString()+ "\n==== \n");

        System.out.println(p2.getNombre() +" indice de masa corporal: "+ p2.obtenerIMC()+ " | "+ p1.getNombre() +" indice de masa corporal: "+ +p1.obtenerIMC());

        System.out.println(p2.getNombre() +(p2.estaEnForma() ? " esta en forma ":" no esta en forma ")+ " | "+ p1.getNombre() +(p1.estaEnForma() ? " esta en forma ":" no esta en forma "));

        System.out.println(p2.getNombre() +(p2.esCumpleaños() ? " es su cumpleaños ":" no es su cumpleaños ")+ " | "+ p1.getNombre() +(p1.esCumpleaños() ? " es su cumpleaños ":" no es su cumpleaños "));

        // CONSIGNA 9:
        // Agregar método que indique si la persona es mayor de edad (retorna true si tiene más de 18 años).
        System.out.println(p2.getNombre() +(p2.esMayor() ? " es mayor de edad ":" no es mayor de edad ")+ " | "+ p1.getNombre() +(p1.esMayor() ? " es mayor de edad ":" no es mayor de edad "));

        System.out.println(p2.getNombre() +(p2.puedeVotar() ? " puede votar ":" no puede votar ")+ " | "+ p1.getNombre() +(p1.puedeVotar() ? " puede votar ":" no puede votar "));




        System.out.println(p2.getNombre() +(p2.edadCorrecta() ? " la edad es correcta ":" la edad es incorrecta ")+ " | "+ p1.getNombre() +(p1.edadCorrecta() ? " la edad es correcta ":" la edad es incorrecta "));

    }
}

