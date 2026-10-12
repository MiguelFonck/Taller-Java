package Ejercicio_3;

public class ProductoAlimenticio extends Producto {
    private String fechaCaducidad;

    public ProductoAlimenticio(String pNombre, double pPrecio, int pStock, String pFechaCaducidad) {
        super(pNombre, pPrecio, pStock, "Alimentos");
        fechaCaducidad = pFechaCaducidad;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public String getDetalleExtra() {
        return "Caduca: " + fechaCaducidad;
    }
}