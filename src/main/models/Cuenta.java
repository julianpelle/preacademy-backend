package main.models;

import main.Exception.SaldoInsuficienteException;

import java.util.Objects;

public abstract class Cuenta {
    protected double saldo; /// Modifique a protected para el override en Cuenta Corriente, si hay una mejor manera de hacerlo avisenme :)
    private String numeroCuenta;

    public Cuenta() {
    }

    public Cuenta(double saldo, String numeroCuenta) {
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        if (saldo <= 0) {
            System.out.println("No tiene saldo disponible");
        }
        return saldo;

    }

    public void setSaldo(double saldo) {
        if (saldo < 0) {
            System.out.println("El saldo no puede ser negativo");
        } else {
            this.saldo = saldo;
        }
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cuenta cuenta = (Cuenta) o;
        return Double.compare(saldo, cuenta.saldo) == 0 && Objects.equals(numeroCuenta, cuenta.numeroCuenta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saldo, numeroCuenta);
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "saldo=" + saldo +
                ", numeroCuenta='" + numeroCuenta + '\'' +
                '}';
    }


    public void depositar(double monto){
        if(monto<0){
            System.out.println("El monto no puede ser negativo o cero.");
        }else{
            this.saldo +=monto;
        }
    }

    public void retirar(double monto)throws SaldoInsuficienteException{
        if(this.saldo < monto){
            throw new SaldoInsuficienteException("No tiene saldo suficiente para retirar el monto seleccionado.");
        }
        this.saldo -=monto;
    }

    public void mostrarSaldo(){
        System.out.println("El saldo actual es : $" + this.saldo);
    }



    // CONSIGNA 5:
    // Crear un método estático llamado transferir(Cuenta origen, Cuenta destino, double monto)
    // que reste el dinero de la cuenta origen y lo deposite en la cuenta destino.
    // Si no hay saldo suficiente, debe mostrar un mensaje de error.

    public static void transferir(Cuenta origen, Cuenta destino, double monto) throws SaldoInsuficienteException {
        if(origen.getSaldo() < monto){
            throw new SaldoInsuficienteException("El monto es mayor al saldo disponible");
        } else if (monto > 0) {
            origen.retirar(monto);
            destino.depositar(monto);
        }
    }



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

}
