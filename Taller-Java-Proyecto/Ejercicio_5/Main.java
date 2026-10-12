package Ejercicio_5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

        int n = pedirEntero(scanner, "Cantidad de alumnos: ");

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Alumno " + (i + 1) + " ---");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            double p1 = pedirNota(scanner, "Nota parcial 1 (30%): ");
            double p2 = pedirNota(scanner, "Nota parcial 2 (30%): ");
            double ef = pedirNota(scanner, "Examen final (40%): ");
            alumnos.add(new Alumno(nombre, p1, p2, ef));
        }

        double promedio = calcularPromedioOriginal(alumnos);
        System.out.println("\nPromedio del curso (antes de la curva): " + promedio);

        if (promedio < 6) {
            // Curva basada en el mejor alumno: 10 - nota mas alta
            double mejor = buscarNotaMasAlta(alumnos);
            double curva = 10 - mejor;
            System.out.println("El promedio es menor a 6.");
            System.out.println("Nota mas alta: " + mejor + " -> curva de +" + curva + " puntos.");
            for (int i = 0; i < alumnos.size(); i++) {
                alumnos.get(i).aplicarCurva(curva);
            }

            // Si prefieres la curva porcentual, comenta el for de arriba
            // y usa este (ejemplo 10%):
            // for (int i = 0; i < alumnos.size(); i++) {
            //     alumnos.get(i).aplicarCurvaPorcentual(10);
            // }
        } else {
            System.out.println("No hace falta aplicar curva.");
        }

        mostrarListado(alumnos);
        mostrarEstadisticas(alumnos);
        scanner.close();
    }


    private static int pedirEntero(Scanner scanner, String mensaje) {
        int numero = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            try {
                numero = scanner.nextInt();
                scanner.nextLine();
                if (numero > 0) {
                    valido = true;
                } else {
                    System.out.println("Debe ser mayor a 0.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Eso no es un numero entero. Intenta de nuevo.");
                scanner.nextLine();
            }
        }
        return numero;
    }

    private static double pedirNota(Scanner scanner, String mensaje) {
        double nota = 0;
        boolean valida = false;
        while (!valida) {
            System.out.print(mensaje);
            try {
                nota = scanner.nextDouble();
                scanner.nextLine();
                if (nota >= 0 && nota <= 10) {
                    valida = true;
                } else {
                    System.out.println("La nota debe estar entre 0 y 10.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Eso no es un numero. Intenta de nuevo.");
                scanner.nextLine();
            }
        }
        return nota;
    }

    private static double calcularPromedioOriginal(ArrayList<Alumno> alumnos) {
        if (alumnos.size() == 0) {
            return 0.0;
        }
        double suma = 0;
        for (int i = 0; i < alumnos.size(); i++) {
            suma = suma + alumnos.get(i).getNotaOriginal();
        }
        return suma / alumnos.size();
    }

    private static double calcularPromedioFinal(ArrayList<Alumno> alumnos) {
        if (alumnos.size() == 0) {
            return 0.0;
        }
        double suma = 0;
        for (int i = 0; i < alumnos.size(); i++) {
            suma = suma + alumnos.get(i).getNotaFinal();
        }
        return suma / alumnos.size();
    }

    private static double buscarNotaMasAlta(ArrayList<Alumno> alumnos) {
        double mayor = alumnos.get(0).getNotaOriginal();
        for (int i = 1; i < alumnos.size(); i++) {
            if (alumnos.get(i).getNotaOriginal() > mayor) {
                mayor = alumnos.get(i).getNotaOriginal();
            }
        }
        return mayor;
    }

    private static double calcularDesviacion(ArrayList<Alumno> alumnos) {
        if (alumnos.size() == 0) {
            return 0.0;
        }
        double media = calcularPromedioFinal(alumnos);
        double suma = 0;
        for (int i = 0; i < alumnos.size(); i++) {
            double diferencia = alumnos.get(i).getNotaFinal() - media;
            suma = suma + diferencia * diferencia;
        }
        return Math.sqrt(suma / alumnos.size());
    }

    // ---------- MOSTRAR ----------
    private static void mostrarListado(ArrayList<Alumno> alumnos) {
        System.out.println("\n===== LISTADO FINAL =====");
        for (int i = 0; i < alumnos.size(); i++) {
            Alumno a = alumnos.get(i);
            String estado;
            if (a.estaAprobado()) {
                estado = "APROBO";
            } else {
                estado = "REPROBO";
            }
            System.out.println(a.getNombre()
                    + " | Original: " + String.format("%.2f", a.getNotaOriginal())
                    + " | Final: " + String.format("%.2f", a.getNotaFinal())
                    + " | " + estado);
        }
    }

    private static void mostrarEstadisticas(ArrayList<Alumno> alumnos) {
        int salvados = 0;
        for (int i = 0; i < alumnos.size(); i++) {
            if (!alumnos.get(i).aprobabaAntes() && alumnos.get(i).estaAprobado()) {
                salvados = salvados + 1;
            }
        }
        System.out.println("\n===== ESTADISTICAS =====");
        System.out.println("Nueva media del curso: " + String.format("%.2f", calcularPromedioFinal(alumnos)));
        System.out.println("Desviacion estandar: " + String.format("%.2f", calcularDesviacion(alumnos)));
        System.out.println("Pasaron de reprobado a aprobado: " + salvados);
    }
}