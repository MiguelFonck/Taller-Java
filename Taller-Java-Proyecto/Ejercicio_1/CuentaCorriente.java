package Ejercicio_1;

public class CuentaCorriente extends CuentaBancaria{

    protected double sobregiro;

    public CuentaCorriente(String titular, double saldo, String pin) {
        super(titular, saldo, pin);
        sobregiro=1000000;
    }
    @Override
    public boolean retirar(double monto){
        if (monto>0 && monto<=saldo + sobregiro){
            saldo -= monto;
            String texto = "Retiro: " + "-$"+monto;
            registrarMovimiento(texto);
            return true;
        }
        return false;
    }
}