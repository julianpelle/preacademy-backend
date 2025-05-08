package main.bank.models;

public class CuentaCorriente extends Cuenta{

    public CuentaCorriente() {
    }

    public CuentaCorriente(double saldo, String numeroCuenta) {
        super(saldo, numeroCuenta);
    }

    @Override
    public void retirar(double monto){
        if(this.getSaldo() - monto < -1000){
            System.out.println("No se puede exceder mas del limite permitido");
        }else{
            this.setSaldo(this.getSaldo()-monto);
        }
    }
    @Override
    public void setSaldo(double saldo) {
        if (saldo < -1000) {
            System.out.println("El saldo no puede ser menor a -1000 en Caja Corriente");
        } else {
            this.saldo = saldo;
        }
    }
}
