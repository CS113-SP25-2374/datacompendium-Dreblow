package CS113.StackQueue;

import java.util.NoSuchElementException;

public class ArrayQueueDAD<E> implements QueueInterface<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private E[] array;
        private int front;
        private int rear;
        private int size;
    
    
        public ArrayQueueDAD() {
            resize(DEFAULT_CAPACITY);
            front = 0;
            rear = -1;
            size = 0;
        }
    
        @Override
        public boolean offer(E element) {
            if (size == array.length) {
                return false; 
            }
    
            // Circular increment
            rear = (rear + 1) % array.length;
            array[rear] = element;
            size++;
    
            return true;
        }
    
        @Override
        public boolean add(E element) {
            if (size == array.length) {
                resize(size * 2);
            }
            return offer(element);
        }
    
        @Override
        public E poll() {
            if (size == 0) {
                return null;
            }
    
            E element = array[front];
            array[front] = null; 
            // Circular increment
            front = (front + 1) % array.length; 
            size--;
    
            return element;
        }
    
        @Override
        public E remove() {
            if (size == 0) {
                throw new NoSuchElementException("Queue is empty");
            }
            return poll();
        }
    
        @Override
        public E peek() {
            return (size == 0) ? null : array[front];
        }
    
        @Override
        public E element() {
            if (size == 0) {
                throw new NoSuchElementException("Queue is empty");
            }
            return array[front];
        }
    
        public boolean isEmpty() {
            return size == 0;
        }
    
        public int size() {
            return size;
        }
    
        @Override
        public String toString() {
            if (size == 0) {
                return "[]"; // Empty queue case
            }
    
            StringBuilder sb = new StringBuilder();
            sb.append("[");
    
            int index = front;
            for (int i = 0; i < size; i++) {
                sb.append(array[index]);
                if (i < size - 1) {
                    sb.append(", "); // Add commas between elements
                }
                index = (index + 1) % array.length; // Move to the next index in circular fashion
            }
    
            sb.append("]");
            return sb.toString();
        }
    
        @SuppressWarnings("unchecked")
        private void resize(int newCapacity) {
            E[] newArray = (E[]) new Object[newCapacity];
        
            // Copy elements in correct order
            int index = front;
            for (int i = 0; i < size; i++) {
                newArray[i] = array[index];
                index = (index + 1) % array.length; // Move circularly
            }
        
            array = newArray;
            front = 0;
            rear = size - 1; // Adjust rear to last valid element
    }
    
}