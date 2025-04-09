package CS113.PriorityQueue;

import CS113.ArrayList.ArrayListDAD;

public class PriorityQueueDAD<E extends Comparable<E>> implements HeapInterface<E> {
    ArrayListDAD<E> array = new ArrayListDAD<>();

    public PriorityQueueDAD() {}



    @Override
    public boolean add(E element) {
        array.add(element);
        heapifyUp(element, array.size() - 1);

        return true;
    }

    @Override
    public E peek() {
        if (array.size() == 0) return null;
        return array.get(0);
    }

    @Override
    public E poll() {
        E first = array.get (0);
        E last = array.get(array.size() - 1);
        array.set(0, last);
        array.remove(array.size() - 1);
        heapifyDown(last, 0);
        return first;
    }

    @Override
    public String toString() {
        return array.toString();
    }

    private void heapifyUp(E element, int index) {
        if (index <= 0) return;

        // Identify the parent index
        int parentIndex = (index - 1)/2;    
        E parent = array.get(parentIndex);

        // if the element < parent swap
        if (element.compareTo(parent) < 0) {
            array.set(parentIndex, element);
            array.set(index, parent);
            heapifyUp(element, parentIndex);
        }
    }

    private void heapifyDown(E element, int index) {
        if (element.compareTo(array.get(index)) < 0) return;

        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        int smallestIndex = index;

        if (leftChild < array.size()) {
            smallestIndex = leftChild;
        } else if (rightChild < array.size()) {
            smallestIndex = rightChild;
        }

        E smallestValue = array.get(smallestIndex);

        if (smallestIndex == index) return;

        if (element.compareTo(smallestValue) > 0) {
            array.set(index, smallestValue);
            array.set(smallestIndex, element);
            heapifyDown(element, smallestIndex);
        }
    }
}
