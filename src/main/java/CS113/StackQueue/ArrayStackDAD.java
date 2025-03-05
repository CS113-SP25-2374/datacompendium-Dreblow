package CS113.StackQueue;

import java.util.EmptyStackException;

public class ArrayStackDAD<E> implements StackInterface<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] array;
    private int top;


    public ArrayStackDAD() {
        top = -1;
        resize(DEFAULT_CAPACITY);
    }

    @Override
    public boolean empty() {
        return top == -1;
    }

    @Override
    public boolean push(E element) {
        if (top == array.length - 1) {
            resize(array.length * 2);
        }

        array[++top] = element;
        return true;
    }

    @Override
    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        }

        E element = array[top];
        array[top--] = null;
        return element;
    }

    @Override
    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        }

        return array[top];
    }

    @Override
    public int search(Object o) {
        for (int i = top; i >= 0; i--) {
            if (array[i].equals(o)) {
                return top - i + 1; // Stack uses 1-based indexing for search
            }
        }
        return -1;
    }

    public int size() {
        return top + 1;
    }

    @Override
    public String toString() {
        if (empty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int i = top; i >= 0; i--) {
            sb.append(array[i]);
            if (i > 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] newArray = (E[]) new Object[newCapacity];
        if (size() > 0) {
            System.out.println("Size is: " + size());
            System.arraycopy(array, 0, newArray, 0, size());
        }
        array = newArray;
    }
}