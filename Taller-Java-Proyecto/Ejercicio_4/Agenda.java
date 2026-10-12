package Ejercicio_4;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {
    private static final int LONGITUD_TELEFONO = 9;
    private static final String ARCHIVO = "agenda.txt";

    private ArrayList<Contacto> contactos = new ArrayList<Contacto>();

    // ---------- VALIDACIONES (metodos auxiliares) ----------
    private boolean telefonoValido(String telefono) {
        if (telefono.length() != LONGITUD_TELEFONO) {
            return false;
        }
        for (int i = 0; i < telefono.length(); i++) {
            if (!Character.isDigit(telefono.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean emailValido(String email) {
        return email.contains("@") && email.contains(".");
    }

    public String agregarContacto(Contacto c) {
        if (!telefonoValido(c.getTelefono())) {
            return "Telefono invalido: debe tener " + LONGITUD_TELEFONO + " digitos y solo numeros.";
        }
        if (!emailValido(c.getEmail())) {
            return "Email invalido: debe contener '@' y '.'.";
        }
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getNombre().equalsIgnoreCase(c.getNombre())) {
                return "Ya existe un contacto con ese nombre.";
            }
            if (contactos.get(i).getTelefono().equals(c.getTelefono())) {
                return "Ya existe un contacto con ese telefono.";
            }
        }
        contactos.add(c);
        return "Contacto agregado.";
    }

    public ArrayList<Contacto> buscarContacto(String texto) {
        ArrayList<Contacto> resultados = new ArrayList<Contacto>();
        for (int i = 0; i < contactos.size(); i++) {
            String nombre = contactos.get(i).getNombre().toLowerCase();
            if (nombre.contains(texto.toLowerCase())) {
                resultados.add(contactos.get(i));
            }
        }
        return resultados;
    }

    public void mostrarTodos() {
        if (contactos.size() == 0) {
            System.out.println("La agenda esta vacia.");
            return;
        }
        for (int i = 0; i < contactos.size(); i++) {
            System.out.print((i + 1) + ". ");
            contactos.get(i).mostrarInfo();
        }
    }

    public void mostrarContactosPorGrupo(String grupo) {
        boolean hayAlguno = false;
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getGrupo().equalsIgnoreCase(grupo)) {
                contactos.get(i).mostrarInfo();
                hayAlguno = true;
            }
        }
        if (!hayAlguno) {
            System.out.println("No hay contactos en el grupo: " + grupo);
        }
    }

    public boolean eliminarContacto(String nombre) {
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getNombre().equalsIgnoreCase(nombre)) {
                contactos.remove(i);
                return true;
            }
        }
        return false;
    }

    // Cada contacto va en una linea: nombre;telefono;email;grupo
    public String guardarEnArchivo() {
        try {
            PrintWriter escritor = new PrintWriter(new FileWriter(ARCHIVO));
            for (int i = 0; i < contactos.size(); i++) {
                Contacto c = contactos.get(i);
                escritor.println(c.getNombre() + ";" + c.getTelefono() + ";"
                        + c.getEmail() + ";" + c.getGrupo());
            }
            escritor.close();
            return "Agenda guardada (" + contactos.size() + " contactos).";
        } catch (IOException e) {
            return "Error al guardar el archivo.";
        }
    }

    public String cargarDesdeArchivo() {
        try {
            Scanner lector = new Scanner(new File(ARCHIVO));
            contactos.clear();   // vaciamos para no duplicar
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String[] partes = linea.split(";");
                if (partes.length == 4) {
                    contactos.add(new Contacto(partes[0], partes[1], partes[2], partes[3]));
                }
            }
            lector.close();
            return "Agenda cargada (" + contactos.size() + " contactos).";
        } catch (IOException e) {
            return "No hay archivo guardado todavia.";
        }
    }
}