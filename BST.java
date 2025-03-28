public class BST<K extends Comparable<K>, V> {
    private Node<K, V> root;

    /**
     * Constructor de la clase BST
     */
    public BST() {
        this.root = null;
    }

    /**
     * Método para insertar un nuevo nodo en el árbol
     * @param key
     * @param valor
     */
    public void insertar(K key, V valor) {
        root = insertarRecursivo(root, key, valor);
    }

    /**
     * Método recursivo para insertar un nuevo nodo en el árbol
     * @param actual
     * @param key
     * @param valor
     * @return el nodo insertado
     */
    private Node<K, V> insertarRecursivo(Node<K, V> actual, K key, V valor) {
        // Si el árbol está vacío
        if (actual == null) {
            return new Node<>(key, valor);
        }

        // Recorrer recursivamente el árbol
        if (key.compareTo(actual.getKey()) < 0) {
            actual.setLeft(insertarRecursivo(actual.getLeft(), key, valor));
        } else if (key.compareTo(actual.getKey()) > 0) {
            actual.setRight(insertarRecursivo(actual.getRight(), key, valor));
        }

        // Devolver el Node sin cambios
        return actual;
    }

    /**
     * Método para buscar un nodo en el árbol
     * @param key
     * @return el valor asociado a la key, o null si no se encuentra
     */
    public V buscar(K key) {
        return buscarRecursivo(root, key);
    }

    /**
     * Método recursivo para buscar un nodo en el árbol
     * @param actual
     * @param key
     * @return el valor asociado a la key, o null si no se encuentra
     */
    private V buscarRecursivo(Node<K, V> actual, K key) {
        if (actual == null || actual.getKey().compareTo(key) == 0) {
            return (actual != null) ? actual.getVal() : null;
        }

        if (key.compareTo(actual.getKey()) < 0) {
            return buscarRecursivo(actual.getLeft(), key);
        }

        return buscarRecursivo(actual.getRight(), key);
    }

    /**
     * Método para recorrer el árbol en orden
     * @param root
     */
    public void recorridoEnOrden() {
        recorridoEnOrdenRecursivo(root);
    }

    /**
     * Método recursivo para recorrer el árbol en orden
     * @param root
     */
    private void recorridoEnOrdenRecursivo(Node<K, V> root) {
        if (root != null) {
            recorridoEnOrdenRecursivo(root.getLeft());
            System.out.println(root.getVal());
            recorridoEnOrdenRecursivo(root.getRight());
        }
    }
}
