package Ejercicio_3;

public class ProductoElectronico extends Producto {
    private int mesesGarantia;

    public ProductoElectronico(String pNombre, double pPrecio, int pStock, int pMesesGarantia) {
        super(pNombre, pPrecio, pStock, "Electronica");
        mesesGarantia = pMesesGarantia;
    }

    public int getMesesGarantia() {
        return mesesGarantia;
    }

    public void setMesesGarantia(int mesesGarantia) {
        this.mesesGarantia = mesesGarantia;
    }

    @Override
    public String getDetalleExtra() {
        return "Garantia: " + mesesGarantia + " meses";
    }
}