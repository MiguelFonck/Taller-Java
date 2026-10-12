package Ejercicio_3;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> productos = new ArrayList<Producto>();

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public Producto getProducto(int i) {
        return productos.get(i);
    }

    public int getCantidadProductos() {
        return productos.size();
    }

    public boolean hayStock(Producto p, int cantidad) {
        return p.hayStock(cantidad);
    }

    // Devuelve true si pudo descontar, false si no alcanzaba
    public boolean disminuirStock(Producto p, int cantidad) {
        if (!hayStock(p, cantidad)) {
            return false;
        }
        p.disminuirStock(cantidad);
        return true;
    }

    // Lista de categorias sin repetir
    public ArrayList<String> getCategorias() {
        ArrayList<String> categorias = new ArrayList<String>();
        for (int i = 0; i < productos.size(); i++) {
            String cat = productos.get(i).getCategoria();
            boolean yaEsta = false;
            for (int j = 0; j < categorias.size(); j++) {
                if (categorias.get(j).equalsIgnoreCase(cat)) {
                    yaEsta = true;
                }
            }
            if (!yaEsta) {
                categorias.add(cat);
            }
        }
        return categorias;
    }
}