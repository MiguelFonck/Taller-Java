package Ejercicio_3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Inventario inventario = crearInventario();

        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(new Cliente("Ana", "ana@correo.com"));
        clientes.add(new Cliente("Luis", "luis@correo.com"));

        Cliente cliente = iniciarSesion(clientes, scanner);
        Carrito carrito = new Carrito(cliente, inventario);

        int opcion = 0;
        while (opcion != 4) {
            System.out.println("\n--- TIENDA ONLINE ---");
            System.out.println("1. Ver catalogo completo");
            System.out.println("2. Filtrar catalogo por categoria");
            System.out.println("3. Comprar producto");
            System.out.println("4. Finalizar compra");
            System.out.print("Opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                mostrarCatalogo(inventario, null);
            } else if (opcion == 2) {
                filtrarPorCategoria(inventario, scanner);
            } else if (opcion == 3) {
                comprar(inventario, carrito, scanner);
            } else if (opcion == 4) {
                System.out.println("Finalizando compra...");
            } else {
                System.out.println("Opcion invalida.");
            }
        }

        carrito.mostrarFactura();
        scanner.close();
    }

    private static Inventario crearInventario() {
        Inventario inv = new Inventario();
        inv.agregarProducto(new ProductoElectronico("Laptop", 2500000, 5, 24));
        inv.agregarProducto(new ProductoElectronico("Mouse", 45000, 20, 12));
        inv.agregarProducto(new ProductoElectronico("Teclado", 120000, 10, 12));
        inv.agregarProducto(new ProductoElectronico("Audifonos", 90000, 8, 6));
        inv.agregarProducto(new ProductoAlimenticio("Cafe", 18000, 30, "2027-03-15"));
        inv.agregarProducto(new ProductoAlimenticio("Galletas", 5000, 50, "2026-12-01"));
        inv.agregarProducto(new Producto("Camiseta", 35000, 15, "Ropa"));
        return inv;
    }

    private static Cliente iniciarSesion(ArrayList<Cliente> clientes, Scanner scanner) {
        System.out.println("--- INICIO DE SESION ---");
        System.out.print("Email: ");
        String email = scanner.nextLine();

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getEmail().equalsIgnoreCase(email)) {
                System.out.println("Bienvenido, " + clientes.get(i).getNombre() + ".");
                return clientes.get(i);
            }
        }

        System.out.println("Email no registrado. Vamos a registrarte.");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        Cliente nuevo = new Cliente(nombre, email);
        clientes.add(nuevo);
        System.out.println("Bienvenido, " + nombre + ".");
        return nuevo;
    }

    // filtro == null muestra todo. El numero es siempre el del catalogo completo.
    private static int mostrarCatalogo(Inventario inv, String filtro) {
        System.out.println("\n--- CATALOGO ---");
        int mostrados = 0;
        for (int i = 0; i < inv.getCantidadProductos(); i++) {
            Producto p = inv.getProducto(i);
            if (filtro == null || p.getCategoria().equalsIgnoreCase(filtro)) {
                System.out.printf("%d. %s [%s] - $%.2f (stock: %d) %s%n",
                        i + 1, p.getNombre(), p.getCategoria(), p.getPrecio(),
                        p.getStock(), p.getDetalleExtra());
                mostrados++;
            }
        }
        return mostrados;
    }

    private static void filtrarPorCategoria(Inventario inv, Scanner scanner) {
        System.out.println("Categorias: " + inv.getCategorias());
        System.out.print("Categoria a ver: ");
        String categoria = scanner.nextLine();
        if (mostrarCatalogo(inv, categoria) == 0) {
            System.out.println("No hay productos en esa categoria.");
        }
    }

    private static void comprar(Inventario inv, Carrito carrito, Scanner scanner) {
        System.out.print("Numero del producto (el que ves en el catalogo): ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        if (numero < 1 || numero > inv.getCantidadProductos()) {
            System.out.println("Ese producto no existe.");
            return;
        }

        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        if (carrito.agregarProducto(inv.getProducto(numero - 1), cantidad)) {
            System.out.println("Agregado al carrito.");
        } else {
            System.out.println("No hay stock suficiente o la cantidad no es valida.");
        }
    }
}