package Ejercicio_1;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        GestionCajero menu = new GestionCajero(banco);
        menu.iniciar();
    }
}
