package Ejercicio_5;

public class Alumno {
    private String nombre;
    private double notaParcial1;   // vale 30%
    private double notaParcial2;   // vale 30%
    private double examenFinal;    // vale 40%
    private double notaOriginal;
    private double notaFinal;

    public Alumno(String pNombre, double pNotaParcial1, double pNotaParcial2, double pExamenFinal) {
        nombre = pNombre;
        notaParcial1 = pNotaParcial1;
        notaParcial2 = pNotaParcial2;
        examenFinal = pExamenFinal;
        notaOriginal = calcularNotaOriginal();
        notaFinal = notaOriginal;   // al inicio, la final es igual a la original
    }

    // getters
    public String getNombre() {
        return nombre;
    }

    public double getNotaParcial1() {
        return notaParcial1;
    }

    public double getNotaParcial2() {
        return notaParcial2;
    }

    public double getExamenFinal() {
        return examenFinal;
    }

    public double getNotaOriginal() {
        return notaOriginal;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    // setters
    public void setNombre(String pNombre) {
        nombre = pNombre;
    }

    // Aplica las ponderaciones: 30% + 30% + 40%
    public double calcularNotaOriginal() {
        return notaParcial1 * 0.30 + notaParcial2 * 0.30 + examenFinal * 0.40;
    }

    // Sube la nota final un porcentaje (ej. 10% de 5.0 = +0.5), sin pasar de 10
    public void aplicarCurvaPorcentual(double porcentaje) {
        notaFinal = notaFinal + notaFinal * porcentaje / 100;
        if (notaFinal > 10) {
            notaFinal = 10;
        }
    }

    // Suma puntos fijos a la nota final, sin pasar de 10
    public void aplicarCurva(double puntos) {
        notaFinal = notaFinal + puntos;
        if (notaFinal > 10) {
            notaFinal = 10;
        }
    }

    public boolean estaAprobado() {
        return notaFinal >= 6;
    }

    // Sirve para saber si ya aprobaba ANTES de la curva
    public boolean aprobabaAntes() {
        return notaOriginal >= 6;
    }
}