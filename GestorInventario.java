import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class GestorInventario {
    private BST<String, Producto> arbolSku;
    private BST<String, Producto> arbolNombre;

    /**
     * Constructor de la clase GestorInventario
     * Inicializa los árboles de búsqueda binaria para SKU y Nombre
     */
    public GestorInventario() {
        arbolSku = new BST<>();
        arbolNombre = new BST<>();
    }

    /**
     * Método para importar productos desde un archivo CSV
     * @param rutaArchivo Ruta del archivo CSV
     */
    public void importarDesdeCSV(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea = br.readLine();
            
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                
                if (campos.length >= 4) {
                    String sku = campos[0];
                    String nombre = campos[1];
                    String descripcion = campos[2];
                    Map<String, Integer> tallas = Producto.parsearTallas(campos[3]);
                    
                    Producto producto = new Producto(sku, nombre, descripcion, tallas);
                    
                    arbolSku.insertar(sku, producto);
                    arbolNombre.insertar(nombre, producto);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para buscar un producto por SKU
     * @param sku
     * @return
     */
    public Producto buscarPorSku(String sku) {
        return arbolSku.buscar(sku);
    }

    /**
     * Método para buscar un producto por Nombre
     * @param nombre
     * @return
     */
    public Producto buscarPorNombre(String nombre) {
        return arbolNombre.buscar(nombre);
    }

    /** 
     * Método para listar productos por SKU
    */
    public void listarProductosPorSku() {
        System.out.println("Productos ordenados por SKU:");
        arbolSku.recorridoEnOrden();
    }

    /**
     * Método para listar productos por Nombre
     */
    public void listarProductosPorNombre() {
        System.out.println("Productos ordenados por Nombre:");
        arbolNombre.recorridoEnOrden();
    }
}