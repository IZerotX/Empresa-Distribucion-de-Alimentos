import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Representa la información general de una transacción
 * (compra o venta) realizada por una sucursal.
 */
public class Transaccion {

    private int idTransaccion;
    private LocalDate fecha;
    private LocalTime hora;
    private int idSucursal;
    private String tipo; // "COMPRA" o "VENTA"

    public Transaccion(int idTransaccion, LocalDate fecha, LocalTime hora,
                        int idSucursal, String tipo) {
        this.idTransaccion = idTransaccion;
        this.fecha = fecha;
        this.hora = hora;
        this.idSucursal = idSucursal;
        this.tipo = tipo;
    }

    public int getIdTransaccion() { return idTransaccion; }
    public LocalDate getFecha() { return fecha; }
    public LocalTime getHora() { return hora; }
    public int getIdSucursal() { return idSucursal; }
    public String getTipo() { return tipo; }

    @Override
    public String toString() {
        return "Transaccion{id=" + idTransaccion + ", fecha=" + fecha +
                ", hora=" + hora + ", sucursal=" + idSucursal +
                ", tipo=" + tipo + "}";
    }
}
