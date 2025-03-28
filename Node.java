public class Node<K extends Comparable<K>, V> {
    private K key;
    private V val;
    private Node<K, V> left;
    private Node<K, V> right;

    /**
     * Constructor de la clase Node
     * @param key
     * @param val
     */
    public Node(K key, V val) {
        this.key = key;
        this.val = val;
        this.left = null;
        this.right = null;
    }

    /**
     * Método para obtener la key del nodo
     * @return key
     */
    public K getKey() {
        return key;
    }

    /**
     * Método para establecer la key del nodo
     * @param key
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * Método para obtener el valor del nodo
     * @return val
     */
    public V getVal() {
        return val;
    }

    /**
     * Método para establecer el valor del nodo
     * @param val
     */
    public void setValor(V val) {
        this.val = val;
    }

    /**
     * Método para obtener el nodo izquierdo
     * @return left
     */
    public Node<K, V> getLeft() {
        return left;
    }

    /**
     * Método para establecer el nodo izquierdo
     * @param left
     */
    public void setLeft(Node<K, V> left) {
        this.left = left;
    }

    /**
     * Método para obtener el nodo derecho
     * @return right
     */
    public Node<K, V> getRight() {
        return right;
    }

    /**
     * Método para establecer el nodo derecho
     * @param right
     */
    public void setRight(Node<K, V> right) {
        this.right = right;
    }
}