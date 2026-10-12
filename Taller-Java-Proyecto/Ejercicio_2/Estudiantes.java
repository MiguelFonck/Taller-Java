package Ejercicio_2;

import java.util.ArrayList;

public class Estudiantes {
    private String nombre;
    private double promedio;
    private int faltas;
    private ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();

    // constructor
    public Estudiantes(String pNombre, ArrayList<Asignatura> pAsignaturas, int pFaltas) {
        nombre = pNombre;
        asignaturas = pAsignaturas;
        faltas= pFaltas;
        calcularPromedio();
    }


    // getters
    public String getNombre() {
        return nombre;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public double getPromedio() {
        return promedio;
    }

    public int getFaltas() {
        return faltas;
    }

    // setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public void calcularPromedio(){
        double suma = 0.0;

        for (int i = 0; i< asignaturas.size(); i++){
            suma= suma + asignaturas.get(i).getNota();
        }
        if (asignaturas.size() > 0) {
            promedio = suma / asignaturas.size();
        } else {
            promedio = 0.0;
        }
    }

    public boolean aprobo(){
        return promedio >= 6 && faltas < 10;
    }


}
