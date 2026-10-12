package Ejercicio_2;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Curso {
    private ArrayList<Estudiantes> estudiantes = new ArrayList<Estudiantes>();

    public void agregarEstudiante(Estudiantes pEstudiante) {
        estudiantes.add(pEstudiante);
    }

    public double promedioGeneral() {
        double suma = 0;
        for (int i = 0; i < estudiantes.size(); i++) {
            suma = suma + estudiantes.get(i).getPromedio();
        }
        if (estudiantes.size() > 0) {
            return suma / estudiantes.size();
        } else {
            return 0.0;
        }
    }

    public int cantidadAprobados(){
        int estudiantesAprobados = 0;
        for (int i = 0; i < estudiantes.size();i++){
            if (estudiantes.get(i).aprobo()){
                estudiantesAprobados = estudiantesAprobados+1;
            }
        }
        return estudiantesAprobados;
    }

    public int cantidadReprobados(){
        int estudiantesReprobados = 0;
        for (int  i = 0; i < estudiantes.size();i++){
            if (!estudiantes.get(i).aprobo()){
                estudiantesReprobados=estudiantesReprobados+1;
            }
        }
        return estudiantesReprobados;
    }

    public Estudiantes estMayorPromedio(){
        if (estudiantes.size() == 0) {
            return null;
        }
        Estudiantes mayorPromedio = estudiantes.get(0);
        for (int i=0 ; i< estudiantes.size() ; i++){
            if (estudiantes.get(i).getPromedio()>mayorPromedio.getPromedio()){
                mayorPromedio=estudiantes.get(i);
            }
        }
        return mayorPromedio;
    }

    public Estudiantes estMenorPromedio(){
        if (estudiantes.size() == 0) {
            return null;
        }
        Estudiantes menorPromedio = estudiantes.get(0);
        for (int i=0; i < estudiantes.size();i++){
            if (estudiantes.get(i).getPromedio()<menorPromedio.getPromedio()){
                menorPromedio=estudiantes.get(i);
            }
        }
        return menorPromedio;
    }

    public void guardarReporte(String nombreArchivo) {
        try {
            PrintWriter escritor = new PrintWriter(nombreArchivo);

            escritor.println("REPORTE DEL CURSO");
            escritor.println("-----------------");

            for (int i = 0; i < estudiantes.size(); i++) {
                escritor.println(estudiantes.get(i).getNombre() + " - Promedio: " + estudiantes.get(i).getPromedio());
            }

            escritor.println();
            escritor.println("ESTADISTICAS DEL GRUPO");
            escritor.println("----------------------");
            escritor.println("Promedio general: " + promedioGeneral());
            escritor.println("Aprobados: " + cantidadAprobados());
            escritor.println("Reprobados: " + cantidadReprobados());

            Estudiantes mejor = estMayorPromedio();
            Estudiantes peor = estMenorPromedio();

            if (mejor != null) {
                escritor.println("Mayor promedio: " + mejor.getNombre() + " (" + mejor.getPromedio() + ")");
                escritor.println("Menor promedio: " + peor.getNombre() + " (" + peor.getPromedio() + ")");
            }


            escritor.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo crear el archivo.");
        }
    }

    public Estudiantes buscarEstudiante(String nombre) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getNombre().equals(nombre)) {
                return estudiantes.get(i);
            }
        }
        return null;
    }

    public boolean modificarNota(String nombreEstudiante, String nombreAsignatura, double nuevaNota) {
        Estudiantes estudiante = buscarEstudiante(nombreEstudiante);
        if (estudiante == null) {
            return false;
        }

        ArrayList<Asignatura> lista = estudiante.getAsignaturas();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNombre().equals(nombreAsignatura)) {
                lista.get(i).setNota(nuevaNota);
                estudiante.calcularPromedio();
                return true;
            }
        }
        return false;
    }
}
