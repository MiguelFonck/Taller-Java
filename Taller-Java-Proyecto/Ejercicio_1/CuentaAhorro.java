package Ejercicio_1;

public class CuentaAhorro extends CuentaBancaria{

    private double tazaInteres;

    public CuentaAhorro(String titular, double saldo, String pin) {
        super(titular, saldo, pin);
        tazaInteres=0.05;
    }

    @Override
    public void depositar(double monto) {
        if (monto>0){
            super.depositar(monto);
            double interes = monto*tazaInteres;
            saldo=saldo+interes;
        }
    }

}

