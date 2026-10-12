package Ejercicio_4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int opcion = 0;

        // Al iniciar, intentamos cargar los contactos guardados
        System.out.println(agenda.cargarDesdeArchivo());

        while (opcion != 8) {
            System.out.println("\n--- AGENDA DE CONTACTOS ---");
            System.out.println("1. Registrar contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Listar contactos");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Mostrar por grupo");
            System.out.println("6. Guardar agenda");
            System.out.println("7. Cargar agenda");
            System.out.println("8. Salir");
            System.out.print("Opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Telefono: ");
                String telefono = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Grupo (Familia, Trabajo, Amigos...): ");
                String grupo = scanner.nextLine();

                System.out.println(agenda.agregarContacto(new Contacto(nombre, telefono, email, grupo)));
            } else if (opcion == 2) {
                System.out.print("Nombre a buscar: ");
                ArrayList<Contacto> resultados = agenda.buscarContacto(scanner.nextLine());
                if (resultados.size() == 0) {
                    System.out.println("No se encontro ningun contacto.");
                } else {
                    for (int i = 0; i < resultados.size(); i++) {
                        resultados.get(i).mostrarInfo();
                    }
                }
            } else if (opcion == 3) {
                agenda.mostrarTodos();
            } else if (opcion == 4) {
                System.out.print("Nombre exacto a eliminar: ");
                if (agenda.eliminarContacto(scanner.nextLine())) {
                    System.out.println("Contacto eliminado.");
                } else {
                    System.out.println("No se encontro el contacto.");
                }
            } else if (opcion == 5) {
                System.out.print("Grupo: ");
                agenda.mostrarContactosPorGrupo(scanner.nextLine());
            } else if (opcion == 6) {
                System.out.println(agenda.guardarEnArchivo());
            } else if (opcion == 7) {
                System.out.println(agenda.cargarDesdeArchivo());
            } else if (opcion == 8) {
                System.out.println(agenda.guardarEnArchivo());
                System.out.println("Hasta luego.");
            } else {
                System.out.println("Opcion invalida.");
            }
        }
        scanner.close();
    }
}