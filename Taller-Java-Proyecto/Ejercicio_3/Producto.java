package Ejercicio_3;

public class Producto {
    private String nombre;
    private double precio;
    private int stock;
    private String categoria;

    public Producto(String pNombre, double pPrecio, int pStock, String pCategoria) {
        nombre = pNombre;
        precio = pPrecio;
        stock = pStock;
        categoria = pCategoria;
    }

    // getters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public String getCategoria() {
        return categoria;
    }

    // setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean hayStock(int cantidad) {
        return cantidad > 0 && stock >= cantidad;
    }

    public void disminuirStock(int cantidad) {
        if (hayStock(cantidad)) {
            stock = stock - cantidad;
        }
    }

    // Las clases hijas lo sobrescriben para mostrar su dato propio
    public String getDetalleExtra() {
        return "";
    }
}