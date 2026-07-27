/**
 * Representa el detalle de una transacción de tipo compra:
 * qué producto, cuántas unidades y a qué precio unitario.
 */
public class Compra {

    private int idCompra;
    private Transaccion transaccion;
    private int idProducto;
    private int cantidad;
    private double precioUnitario;

    public Compra(int idCompra, Transaccion transaccion, int idProducto,
                   int cantidad, double precioUnitario) {
        this.idCompra = idCompra;
        this.transaccion = transaccion;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public int getIdCompra() { return idCompra; }
    public Transaccion getTransaccion() { return transaccion; }
    public int getIdProducto() { return idProducto; }
    public int getCantidad() { return cantidad; }
    public double getPrecioUnitario() { return precioUnitario; }

    public double getTotal() {
        return cantidad * precioUnitario;
    }

    @Override
    public String toString() {
        return "Compra{idCompra=" + idCompra + ", producto=" + idProducto +
                ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario +
                ", total=" + getTotal() + "}";
    }
}
