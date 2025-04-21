package main;

import main.Exception.SaldoInsuficienteException;
import main.models.CajaAhorro;
import main.models.Cuenta;
import main.models.CuentaCorriente;

public class BankExercice {
    public static void main(String[] args) throws SaldoInsuficienteException {

        // TODO: ¡Bienvenidos! Hoy van a programar para un banco en Java 😱
        // Este ejercicio les permitirá practicar herencia, encapsulamiento, métodos estáticos
        // y organización de clases aplicando Programación Orientada a Objetos.

        // CONSIGNA 1:
        // Crear una clase abstracta llamada "Cuenta" dentro del package models.
        // La clase debe tener los siguientes atributos privados:
        // - double saldo
        // - String numeroCuenta

        // CONSIGNA 2:
        // En la clase Cuenta, crear un constructor que reciba ambos atributos por parámetro
        // y los asigne correctamente.

        // CONSIGNA 3:
        // Crear métodos públicos para:
        // - depositar(double monto): suma el monto al saldo.
        // - retirar(double monto): resta el monto del saldo, si hay suficiente dinero.
        // - mostrarSaldo(): imprime el saldo actual. (Este puede ser protected)

        // CONSIGNA 4:
        // Crear los métodos getter y setter para el atributo saldo (pueden incluir controles dentro de los mismos, por ejemplo, para informar que no tiene saldo).

        // CONSIGNA 5:
        // Crear un método estático llamado transferir(Cuenta origen, Cuenta destino, double monto)
        // que reste el dinero de la cuenta origen y lo deposite en la cuenta destino.
        // Si no hay saldo suficiente, debe mostrar un mensaje de error.

        // CONSIGNA 6:
        // Crear dos clases que hereden de Cuenta:
        // - CajaAhorro
        // - CuentaCorriente
        // Cada una debe tener su constructor y heredar correctamente el comportamiento de Cuenta.

        // CONSIGNA 7:
        // Desde este método main, crear un objeto CajaAhorro y otro CuentaCorriente.
        // Probar los métodos depositar, retirar, mostrarSaldo y transferir.

        // CONSIGNA 8 (DESAFÍO EXTRA):
        // Sobreescribir el método retirar en CuentaCorriente para permitir saldo negativo
        // (por ejemplo, permitir que el saldo llegue hasta -1000)

        // TODO: ↓ Acá podés comenzar a resolver desde el main:

        // ¡A programar!

        CajaAhorro cajaDeAhorro1 = new CajaAhorro(1000,"ABC123)");
        CuentaCorriente cuentaCorriente1 = new CuentaCorriente(500,"DEF123)");


        System.out.println("===================== \nCaja de ahorro: ");
        cajaDeAhorro1.depositar(300);
        try{
            cajaDeAhorro1.retirar(2300);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        cajaDeAhorro1.retirar(300);

        cajaDeAhorro1.mostrarSaldo();

        System.out.println("===================== \nCuenta corriente: ");
        cuentaCorriente1.depositar(300);
        cuentaCorriente1.retirar(1800);
        cuentaCorriente1.mostrarSaldo();
        System.out.println("===================== \n");

    }
}

