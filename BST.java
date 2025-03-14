public class BST<T extends Comparable<T>> {
    private Node<T> root;

    private Node<T> addRecursive(Node<T> node, T key, T value){
        if(node == null){
            return new Node<T>(key, value);
        }

        if(value.compareTo(node.value) < 0){
            node.left = addRecursive(node.left, key, value);
        } else if(value.compareTo(node.value) > 0){
            node.right = addRecursive(node.right, key, value);
        } else {
            return node;
        }

        return node;
    }

    public void add(T key,T value){
        root = addRecursive(root, key, value);
    }

    public T search(Node<T> node, T key){
        if(node == null){
            return null;
        }

        if(key.compareTo(node.value) == 0){
            return search(node.left, key);
        } else if(key.compareTo(node.value) > 0){
            return search(node.right, key);
        } else {
            return node.key;
        }

    }

    private void traverseInOrder(Node<T> node){
        if(node != null){
            traverseInOrder(node.left);
            System.out.println("Clave: " + node.key + " Value: " + node.value);
            traverseInOrder(node.right);
        }
    }

    


}
