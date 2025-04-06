package CS113.SearchTrees;

public class AVLTreeDAD <E extends Comparable<E>> extends BinarySearchTreeDAD<E> {

    public Node<E> rotateLeft(Node<E> node) {
        Node<E> childRight = node.right;
        node.right = childRight.left;
        childRight.left = node;
        node = childRight;
        return node;
    }

    public Node<E> rotateRight(Node<E> node) {
        Node<E> childLeft = node.left;
        node.left = childLeft.right;
        childLeft.right = node;
        node = childLeft;
        return node;
    }
    
    public int balanceFactor(Node<E> node){
        return heightRecursive(node.right) - heightRecursive(node.left);
    }

    public Node<E> rebalance(Node<E> node, E element) {
        int balance =  balanceFactor(node);

        if (balance > 1) { //heavy right
            if(balanceFactor(node.right) < 0 ) {
                node.right = rotateRight(node.right);
            }
            node = rotateLeft(node);
        }

        if (balance < -1) { //heavy left
            if (balanceFactor(node.left) > 0 ) {
                node.left = rotateLeft(node.left);
            }
            node = rotateRight(node);
        }
        return node;
    }

    @Override
    public Node<E> insertRecursive(Node<E> node, E element) {
        node = super.insertRecursive(node, element);
        node = rebalance(node, element);
        return node;
    }

    @Override
    public String toString() {
        return toStringRecursive(root);
    }
    
    private String toStringRecursive(Node<E> node) {
        if (node == null) return "";
        return toStringRecursive(node.left) + node.data + " " + toStringRecursive(node.right);
    }

    public void printTree() {
        printTreeRecursive(root, "", true);
    }
    
    private void printTreeRecursive(Node<E> node, String prefix, boolean isLeft) {
        if (node == null) return;
    
        if (node.right != null) {
            printTreeRecursive(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    
        System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.data);
    
        if (node.left != null) {
            printTreeRecursive(node.left, prefix + (isLeft ? "    " : "│   "), true);
        }
    }
}
