package CS113.StackQueue;

import java.util.NoSuchElementException;

public class ArrayDequeDAD<E> implements DequeInterface<E> {

    static final private int DEFAULT_SIZE = 10;

    E[] array;
    int first = -1;
    int last = -1;
    int size = 0;

    public ArrayDequeDAD() {
        resize(DEFAULT_SIZE);
        first = last = -1;
        size = 0;
    }

    @Override
    public boolean offerFirst(E element) {
        if (size == array.length) {
            return false;
        }

        addFirst(element);
        return true;
    }

    @Override
    public boolean offerLast(E element) {
        if (size == array.length) {
            return false;
        }

        addLast(element);
        return true;
    }

    @Override
    public boolean addFirst(E element) {
        if (size == 0) {
            first = last = 0;
            array[first] = element;
            size++;
            return true;
        } 

        // Need more space
        if (size == array.length) {
            resize(size * 2);
        }

        first--;
        if (first < 0) {
            first = array.length - 1;
        }

        array[first] = element;
        size++;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        if (size == 0) {
            first = last = 0;
            array[first] = element;
            size++;
            return true;
        } 

        // Need more space
        if (size == array.length) {
            resize(size * 2);
        }

        last++;
        if (last >= array.length) {
            last = 0;
        }

        array[last] = element;
        size++;
        return true;
    }

    @Override
    public E removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
    
        E temp = array[first];
        array[first] = null;
    
        first++;
        if (first >= array.length) {
            first = 0;
        }
    
        size--;
        if (size == 0) {
            first = last = -1;
        }
    
        return temp;
    }

    @Override
    public E removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        E temp = array[last];
        array[last] = null;

        last--;
        if (last < 0) {
            last = array.length - 1;
        }

        size--; 
        if (size == 0) {
            first = last = -1;
        }

        return temp;
    }

    @Override
    public E peekFirst() {
        if (size == 0) {
            return null;
        }

        return array[first];
    }

    @Override
    public E peekLast() {
        if (size == 0) {
            return null;
        }

        return array[last];
    }

    @Override
    public E pollFirst() {
        try {
            return removeFirst();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public E pollLast() {
        try {
            return removeLast();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]"; // Empty deque case
        }
    
        StringBuilder sb = new StringBuilder();
        sb.append("[");
    
        int index = first;
        for (int i = 0; i < size; i++) {
            sb.append(array[index]);
            if (i < size - 1) {
                sb.append(", "); // Add comma only between elements
            }
            index = (index + 1) % array.length; // Move to next element in circular fashion
        }
    
        sb.append("]");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    private void resize(int newSize) {
        E[] newArray = (E[]) new Object[newSize];
    
        if (size > 0) {
            int index = first;
            for (int i = 0; i < size; i++) {
                newArray[i] = array[index];
                index = (index + 1) % array.length;
            }
        }
    
        array = newArray;
        first = 0;
        last = size - 1;
    }
    
}
