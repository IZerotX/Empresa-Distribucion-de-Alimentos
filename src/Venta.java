/**
 * Representa el detalle de una transacción de tipo venta:
 * qué producto, cuántas unidades y a qué precio unitario.
 */
public class Venta {

    private int idVenta;
    private Transaccion transaccion;
    private int idProducto;
    private int cantidad;
    private double precioUnitario;

    public Venta(int idVenta, Transaccion transaccion, int idProducto,
                 int cantidad, double precioUnitario) {
        this.idVenta = idVenta;
        this.transaccion = transaccion;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public int getIdVenta() { return idVenta; }
    public Transaccion getTransaccion() { return transaccion; }
    public int getIdProducto() { return idProducto; }
    public int getCantidad() { return cantidad; }
    public double getPrecioUnitario() { return precioUnitario; }

    public double getTotal() {
        return cantidad * precioUnitario;
    }

    @Override
    public String toString() {
        return "Venta{idVenta=" + idVenta + ", producto=" + idProducto +
                ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario +
                ", total=" + getTotal() + "}";
    }
}
