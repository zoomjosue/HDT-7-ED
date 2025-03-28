import java.util.HashMap;
import java.util.Map;

public class Producto {
    private String sku;
    private String nombre;
    private String descripcion;
    private Map<String, Integer> tallas;

    /**
     * Constructor de la clase Producto
     * @param sku
     * @param nombre
     * @param descripcion
     * @param tallas
     */
    public Producto(String sku, String nombre, String descripcion, Map<String, Integer> tallas) {
        this.sku = sku;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tallas = tallas;
    }

    /**
     * Método para convertir una cadena de tallas en un mapa
     * @param cadenaTallas
     * @return mapa de tallas
     */
    public static Map<String, Integer> parsearTallas(String cadenaTallas) {
        Map<String, Integer> mapaTallas = new HashMap<>();
        String[] entradasTallas = cadenaTallas.split("\\|");
        for (String entrada : entradasTallas) {
            String[] partes = entrada.split(":");
            mapaTallas.put(partes[0], Integer.parseInt(partes[1]));
        }
        return mapaTallas;
    }

    /**
     * Método para obtener el SKU del producto
     * @return sku
     */
    public String getSku() { 
        return sku; 
    }

    /**
     * Método para establecer el SKU del producto
     * @param sku
     */
    public void setSku(String sku) { 
        this.sku = sku; 
    }

    /**
     * Método para obtener el nombre del producto
     * @return nombre
     */
    public String getNombre() { 
        return nombre; 
    }

    /**
     * Método para establecer el nombre del producto
     * @param nombre
     */
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    /**
     * Método para obtener la descripción del producto
     * @return descripcion
     */
    public String getDescripcion() { 
        return descripcion; 
    }

    /**
     * Método para establecer la descripción del producto
     * @param descripcion
     */
    public void setDescripcion(String descripcion) { 
        this.descripcion = descripcion; 
    }

    /**
     * Método para obtener las tallas del producto
     * @return tallas
     */
    public Map<String, Integer> getTallas() { 
        return tallas; 
    }

    /**
     * Método para establecer las tallas del producto
     * @param tallas
     */
    public void setTallas(Map<String, Integer> tallas) { 
        this.tallas = tallas; 
    }

    /**
     * Método para obtener una representación en cadena del producto
     * @return cadena de texto con la información del producto
     */
    @Override
    public String toString() {
        return "Producto{" +
                "sku='" + sku + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", tallas=" + tallas +
                '}';
    }
}