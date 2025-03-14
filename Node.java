class Node<T>{
    T key;
    T value;
    Node<T> left;
    Node<T> right;

    Node(T key, T value){
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }
}