import java.util.concurrent.ConcurrentHashMap;

/**
 * Caché en memoria para la información de productos.
 * Evita consultar MySQL en cada solicitud repetitiva.
 */
public class CacheProduct {

    // idProducto -> descripcion|precio (simplificado para el ejemplo)
    private final ConcurrentHashMap<Integer, String> cache = new ConcurrentHashMap<>();

    public void guardar(int idProducto, String nombre, double precio) {
        cache.put(idProducto, nombre + "|" + precio);
    }

    public String obtener(int idProducto) {
        return cache.get(idProducto);
    }

    /**
     * Se invoca cuando el Consumidor procesa una transacción
     * que modifica el producto, para no dejar datos desactualizados.
     */
    public void invalidar(int idProducto) {
        cache.remove(idProducto);
        System.out.println("Caché de producto " + idProducto + " invalidado.");
    }

    public boolean contiene(int idProducto) {
        return cache.containsKey(idProducto);
    }
}
