package Ejercicio_2;
import java.util.Scanner;
import java.util.ArrayList;

public class GestionEstudiantes {
    private Curso curso = new Curso();
    private Scanner scanner = new Scanner(System.in);

    private int pedirCantidadEst(){
        System.out.println("Ingrese la cantidad de estudiantes que desea agregar");
        int cantidadEstudiantes = scanner.nextInt();
        scanner.nextLine();
        return cantidadEstudiantes;
    }

    private void registrarEstudiantes(int cantidad){
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\n--- Estudiante " + (i + 1) + " ---");
            curso.agregarEstudiante(crearEstudiante());
        }
    }
    private Estudiantes crearEstudiante() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Faltas: ");
        int faltas = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Asignatura> asignaturas = pedirAsignaturas();
        return new Estudiantes(nombre, asignaturas, faltas);
    }

    private ArrayList<Asignatura> pedirAsignaturas(){
        ArrayList<Asignatura> lista = new ArrayList<Asignatura>();

        System.out.println("Ingrese la cantidad de asignaturas:");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < cantidad; i++){
            System.out.print("Nombre de la asignatura " + (i+1) + ": ");
            String nombre = scanner.nextLine();

            System.out.print("Nota final: ");
            double nota = scanner.nextDouble();
            scanner.nextLine();

            lista.add(new Asignatura(nombre, nota));
        }
        return lista;
    }

    private void probarModificacion() {
        System.out.print("Nombre del estudiante a modificar: ");
        String nombreEst = scanner.nextLine();

        System.out.print("Nombre de la asignatura: ");
        String nombreAsig = scanner.nextLine();

        System.out.print("Nueva nota: ");
        double nuevaNota = scanner.nextDouble();
        scanner.nextLine();

        if (curso.modificarNota(nombreEst, nombreAsig, nuevaNota)) {
            System.out.println("Nota modificada.");
        } else {
            System.out.println("No se encontró el estudiante o la asignatura.");
        }
    }

    private void mostrarEstadisticas() {
        System.out.println("\n===============================");
        System.out.println("     ESTADISTICAS DEL GRUPO    ");
        System.out.println("===============================");
        System.out.println("Promedio general: " + curso.promedioGeneral());
        System.out.println("Aprobados: " + curso.cantidadAprobados());
        System.out.println("Reprobados: " + curso.cantidadReprobados());

        Estudiantes mejor = curso.estMayorPromedio();
        Estudiantes peor = curso.estMenorPromedio();

        if (mejor != null) {
            System.out.println("Mayor promedio: " + mejor.getNombre() + " (" + mejor.getPromedio() + ")");
            System.out.println("Menor promedio: " + peor.getNombre() + " (" + peor.getPromedio() + ")");
        } else {
            System.out.println("No hay estudiantes registrados.");
        }
    }

    public void iniciar() {
        int cantidad = pedirCantidadEst();
        registrarEstudiantes(cantidad);
        probarModificacion();
        mostrarEstadisticas();
        curso.guardarReporte("reporte.txt");
        scanner.close();
    }
}
