package Ejercicio_3;

import java.util.ArrayList;

public class Carrito {
    private static final double UMBRAL_DESCUENTO = 500000;
    private static final double PORCENTAJE_DESCUENTO = 0.10;

    private Cliente cliente;
    private Inventario inventario;
    private ArrayList<Producto> productos = new ArrayList<Producto>();
    private ArrayList<Integer> cantidades = new ArrayList<Integer>();

    public Carrito(Cliente pCliente, Inventario pInventario) {
        cliente = pCliente;
        inventario = pInventario;
    }

    // El stock se valida y se descuenta a traves del Inventario
    public boolean agregarProducto(Producto producto, int cantidad) {
        if (!inventario.disminuirStock(producto, cantidad)) {
            return false;
        }

        int posicion = productos.indexOf(producto);
        if (posicion >= 0) {
            cantidades.set(posicion, cantidades.get(posicion) + cantidad);
        } else {
            productos.add(producto);
            cantidades.add(cantidad);
        }
        return true;
    }

    public double calcularSubtotal() {
        double subtotal = 0;
        for (int i = 0; i < productos.size(); i++) {
            subtotal = subtotal + productos.get(i).getPrecio() * cantidades.get(i);
        }
        return subtotal;
    }

    public double calcularDescuento() {
        double subtotal = calcularSubtotal();
        if (subtotal > UMBRAL_DESCUENTO) {
            return subtotal * PORCENTAJE_DESCUENTO;
        }
        return 0;
    }

    public double calcularTotal() {
        return calcularSubtotal() - calcularDescuento();
    }

    public boolean estaVacio() {
        return productos.size() == 0;
    }

    public void mostrarFactura() {
        System.out.println("\n===============================");
        System.out.println("            FACTURA            ");
        System.out.println("===============================");
        System.out.println("Cliente: " + cliente.getNombre() + " (" + cliente.getEmail() + ")");
        System.out.println("-------------------------------");
        if (estaVacio()) {
            System.out.println("No compraste ningun producto.");
        } else {
            for (int i = 0; i < productos.size(); i++) {
                Producto p = productos.get(i);
                int cantidad = cantidades.get(i);
                System.out.printf("%s x%d  ($%.2f c/u)  = $%.2f%n",
                        p.getNombre(), cantidad, p.getPrecio(), p.getPrecio() * cantidad);
            }
        }
        System.out.println("-------------------------------");
        System.out.printf("Subtotal:  $%.2f%n", calcularSubtotal());
        System.out.printf("Descuento: -$%.2f%n", calcularDescuento());
        System.out.printf("TOTAL A PAGAR: $%.2f%n", calcularTotal());
    }
}