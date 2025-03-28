import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BST<String, Producto> arbolSku = new BST<>();
        BST<String, Producto> arbolNombre = new BST<>();
        
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\n--- Sistema de Inventario de Ropa Deportiva ---");
            System.out.println("1. Cargar inventario desde archivo CSV");
            System.out.println("2. Agregar nuevo producto");
            System.out.println("3. Editar producto existente");
            System.out.println("4. Buscar producto");
            System.out.println("5. Listar productos por SKU");
            System.out.println("6. Listar productos por Nombre");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la ruta del archivo CSV: ");
                    String rutaArchivo = scanner.nextLine();
                    try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
                        br.readLine();
                        
                        String linea;
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
                        System.out.println("Archivo importado exitosamente");
                    } catch (IOException e) {
                        System.out.println("Error al leer el archivo: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Ingrese SKU: ");
                    String sku = scanner.nextLine();

                    System.out.print("Ingrese nombre del producto: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese descripción: ");
                    String descripcion = scanner.nextLine();

                    Map<String, Integer> tallas = new HashMap<>();
                    while (true) {
                        System.out.print("Ingrese talla o fin para terminar: ");
                        String talla = scanner.nextLine();
                        if (talla.equalsIgnoreCase("fin")) break;

                        System.out.print("Ingrese cantidad para " + talla + ": ");
                        int cantidad = scanner.nextInt();
                        scanner.nextLine();

                        tallas.put(talla, cantidad);
                    }

                    Producto nuevoProducto = new Producto(sku, nombre, descripcion, tallas);
                    
                    arbolSku.insertar(sku, nuevoProducto);
                    arbolNombre.insertar(nombre, nuevoProducto);
                    System.out.println("Producto agregado exitosamente");
                    break;

                case 3:
                    System.out.print("Ingrese SKU del producto a editar: ");
                    String skuEditar = scanner.nextLine();
                    
                    Producto productoEditar = arbolSku.buscar(skuEditar);
                    if (productoEditar == null) {
                        System.out.println("Producto no encontrado");
                        break;
                    }

                    System.out.println("Producto actual: " + productoEditar);
                    
                    System.out.print("Nueva descripción (enter si se quiere mantener el actual): ");
                    String nuevaDescripcion = scanner.nextLine();
                    if (!nuevaDescripcion.isEmpty()) {
                        productoEditar.setDescripcion(nuevaDescripcion);
                    }

                    while (true) {
                        System.out.println("Tallas actuales: " + productoEditar.getTallas());
                        System.out.print("Talla a modificar o fin para terminar: ");
                        String talla = scanner.nextLine();
                        if (talla.equalsIgnoreCase("fin")) break;

                        System.out.print("Nueva cantidad para " + talla + ": ");
                        int cantidad = scanner.nextInt();
                        scanner.nextLine(); 

                        productoEditar.getTallas().put(talla, cantidad);
                    }
                    System.out.println("Producto actualizado");
                    break;

                case 4:
                    System.out.println("Buscar por:");
                    System.out.println("1. SKU");
                    System.out.println("2. Nombre");
                    
                    int opcionBusqueda = scanner.nextInt();
                    scanner.nextLine(); 

                    Producto productoBuscado = null;
                    switch (opcionBusqueda) {
                        case 1:
                            System.out.print("Ingrese SKU: ");
                            String skuBuscar = scanner.nextLine();
                            productoBuscado = arbolSku.buscar(skuBuscar);
                            break;
                        case 2:
                            System.out.print("Ingrese nombre: ");
                            String nombreBuscar = scanner.nextLine();
                            productoBuscado = arbolNombre.buscar(nombreBuscar);
                            break;
                    }

                    if (productoBuscado != null) {
                        System.out.println("Producto encontrado:");
                        System.out.println(productoBuscado);
                    } else {
                        System.out.println("Producto no encontrado");
                    }
                    break;

                case 5:
                    System.out.println("Productos ordenados por SKU:");
                    arbolSku.recorridoEnOrden();
                    break;

                case 6:
                    System.out.println("Productos ordenados por Nombre:");
                    arbolNombre.recorridoEnOrden();
                    break;

                case 7:
                    System.out.println("Adios :(.)");
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 7);

        scanner.close();
    }
}