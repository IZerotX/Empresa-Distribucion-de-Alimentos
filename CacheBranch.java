import java.util.concurrent.ConcurrentHashMap;

/**
 * Caché en memoria para la información de sucursales.
 * Evita consultar MySQL en cada solicitud repetitiva.
 */
public class CacheBranch {

    // idSucursal -> nombre|direccion|telefono (simplificado para el ejemplo)
    private final ConcurrentHashMap<Integer, String> cache = new ConcurrentHashMap<>();

    public void guardar(int idSucursal, String nombre, String direccion, String telefono) {
        cache.put(idSucursal, nombre + "|" + direccion + "|" + telefono);
    }

    public String obtener(int idSucursal) {
        return cache.get(idSucursal);
    }

    /**
     * Se invoca cuando una sucursal actualiza sus datos,
     * para mantener la consistencia del caché distribuido.
     */
    public void invalidar(int idSucursal) {
        cache.remove(idSucursal);
        System.out.println("Caché de sucursal " + idSucursal + " invalidado.");
    }

    public boolean contiene(int idSucursal) {
        return cache.containsKey(idSucursal);
    }
}
