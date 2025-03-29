package CS113.SearchTrees;

public class BinarySearchTreeDAD<E extends Comparable<E>> implements BinarySearchTree<E> {

    @SuppressWarnings("hiding")
    private class Node<E> {
        E data;
        Node<E> left;
        Node<E> right;

        private Node(E data){
            this.data = data;
        }
    }

    private Node<E> root;

    // Recursively added generic data to binary tree
    @Override
    public void insert(E data) {
        root = insertRecursive(root, data);
    }
    
    private Node<E> insertRecursive(Node<E> node, E data) {
        if (node == null) {
            return new Node<>(data);
        }
    
        int cmp = data.compareTo(node.data);
    
        if (cmp < 0) {
            node.left = insertRecursive(node.left, data);
        } else if (cmp > 0) {
            node.right = insertRecursive(node.right, data);
        }
    
        return node;
    }

    @Override
    public boolean delete(E value) {
        if (!contains(value)) return false;
        root = deleteRecursive(root, value);
        return true;
    }
    
    private Node<E> deleteRecursive(Node<E> node, E value) {
        if (node == null) return null;
    
        int cmp = value.compareTo(node.data);
    
        if (cmp < 0) {
            node.left = deleteRecursive(node.left, value);
        } else if (cmp > 0) {
            node.right = deleteRecursive(node.right, value);
        } else {
            // Found the node to delete
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
    
            // Two children: replace with in-order successor
            Node<E> successor = findMinNode(node.right);
            node.data = successor.data;
            node.right = deleteRecursive(node.right, successor.data);
        }
    
        return node;
    }

    @Override
    public boolean contains(E data) {
        return containsRecursive(root, data);
    }
    
    private boolean containsRecursive(Node<E> node, E data) {
        if (node == null) {
            return false;
        }
    
        int cmp = data.compareTo(node.data);
    
        if (cmp == 0) {
            return true;
        } else if (cmp < 0) {
            return containsRecursive(node.left, data);
        } else {
            return containsRecursive(node.right, data);
        }
    }

    @Override
    public E findMin() {
        return findMinNode(root).data;
    }

    private Node<E> findMinNode(Node<E> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    @Override
    public E findMax() {
        return findMaxRecursive(root).data;
    }

    private Node<E> findMaxRecursive(Node<E> node) {
        if(node.right == null) return node;
        return findMaxRecursive(node.right);
    }

    @Override
    public int height() {
        return heightRecursive(root);
    }

    private int heightRecursive(Node<E> node) {
        if (node == null) return 0;

        return 1 + Integer.max(heightRecursive(node.left), heightRecursive(node.right));
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void clear() {
        // Sit back and let garbage collector do it thing
        root = null;
    }

    @Override
    public void inorderTraversal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inorderTraversal' - Skipping since why, what is it doing for us?!");
    }

    @Override
    public void preorderTraversal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'preorderTraversal' - Skipping since why, what is it doing for us?!");
    }

    @Override
    public void postorderTraversal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postorderTraversal' - Skipping since why, what is it doing for us?!");
    }

    @Override
    public String toString() {
        return toStringRecursive(root).trim();
    }
    
    private String toStringRecursive(Node<E> node) {
        if (node == null) {
            return "";
        }
    
        String left = toStringRecursive(node.left);
        String current = node.data.toString() + " ";
        String right = toStringRecursive(node.right);
    
        return left + current + right;
    }
}
