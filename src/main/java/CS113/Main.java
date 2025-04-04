package CS113;

import java.util.LinkedList;

import CS113.LinkedList.LinkedListDAD;
import CS113.SearchTrees.BinarySearchTreeDAD;
import CS113.StackQueue.ArrayDequeDAD;
import CS113.StackQueue.ArrayQueueDAD;
import CS113.StackQueue.ArrayStackDAD;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        LinkedList<Integer> goArray = new LinkedList<>();
        LinkedListDAD<Integer> testArray = new LinkedListDAD<>();
        ArrayDequeDAD<Integer> testDeque = new ArrayDequeDAD<>();
        ArrayQueueDAD<Integer> testQueue = new ArrayQueueDAD<>();
        ArrayStackDAD<Integer> testStack = new ArrayStackDAD<>();
        BinarySearchTreeDAD<Integer> testBST = new BinarySearchTreeDAD<>();


        for (int i = 0; i < 10; i++) {
            testArray.add(i);
            goArray.add(i);
            testDeque.addLast(i);
            testQueue.add(i);
            testStack.push(i);
        }

        goArray.add(4, null);
        testArray.add(4, null);

        System.out.println("goArray");
        System.out.println(goArray);
        System.out.println(goArray.size());


        System.out.println("");
        System.out.println("testArray");
        System.out.println(testArray);
        System.out.println(testArray.size());


        // ChatGPT testing Iterator
        System.out.println("");
        System.out.println("Iterator Test");
        LinkedListDAD<Integer> list = new LinkedListDAD<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
    
        System.out.println("Before remove: " + list);
    
        IteratorInterface<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int num = iterator.next();
            if (num == 2) {
                // Should remove element 2
                iterator.remove(); 
            }
        }
    
        System.out.println("After remove: " + list);

        // Testing ArrayDequeDAD operations
        System.out.println("");
        System.out.println("Testing ArrayDequeDAD");
        System.out.println(testDeque);
        System.out.println("Deque pollFirst: " + testDeque.pollFirst());    // 0
        System.out.println("Deque pollLast: " + testDeque.pollLast());      // 9
        System.out.println("Deque peekFirst: " + testDeque.peekFirst());    // 1
        System.out.println("Deque peekLast: " + testDeque.peekLast());      // 8
        System.out.println(testDeque);
        System.out.println("Deque adding 33, 45, 57 ");
        testDeque.addLast(33);
        testDeque.addLast(45);
        testDeque.addLast(57);
        System.out.println(testDeque);
        System.out.println("Deque pollFirst: " + testDeque.pollFirst());    // 1
        System.out.println(testDeque);


        // Testing ArrayQueueDAD operations
        System.out.println("");
        System.out.println("Testing ArrayQueueDAD");
        System.out.println(testQueue);
        System.out.println("Queue poll: " + testQueue.poll());              // 0
        System.out.println("Queue peek: " + testQueue.peek());              // 1
        System.out.println("Queue remove: " + testQueue.remove());          // 1
        System.out.println("Queue isEmpty: " + testQueue.isEmpty());        // false
        System.out.println("Queue poll: " + testQueue.poll());              // 2
        System.out.println("Queue isEmpty: " + testQueue.isEmpty());        // false


        // Testing ArrayStackDAD operations
        System.out.println("");
        System.out.println("Testing ArrayStackDAD");
        System.out.println(testStack);
        System.out.println("Peek: " + testStack.peek());                    // Expected: 9
        System.out.println("Popping: " + testStack.pop());                  // Expected: 9
        System.out.println("Stack after pop: " + testStack);                // Expected: [8, 7, 6, 5, 4, 3, 2, 1, 0]
        System.out.println("Search for 4: " + testStack.search(4));       // Expected: 5
        System.out.println("Search for 50 (not present): " + testStack.search(50)); // Expected: -1
        System.out.println("Stack is empty? " + testStack.empty());         // Expected: false
        testStack.pop();                                                    // Removes 8
        testStack.pop();                                                    // Removes 7
        System.out.println(testStack);
        System.out.println("Stack is empty after all pops? " + testStack.empty()); // Expected: true


        // ===========================
        // Testing BinarySearchTreeDAD
        // ===========================
        System.out.println("");
        System.out.println("Testing BinarySearchTreeDAD");

        // Inserting elements
        testBST.insert(10);
        testBST.insert(5);
        testBST.insert(15);
        testBST.insert(3);
        testBST.insert(7);
        testBST.insert(12);
        testBST.insert(18);


        System.out.println("Is the BST empty after insertions? " + testBST.isEmpty());      // Expected: false
        System.out.println("Height of BST: " + testBST.height());                           // Expected: 3

        // Finding minimum and maximum
        System.out.println("Minimum value: " + testBST.findMin());                          // Expected: 3
        System.out.println("Maximum value: " + testBST.findMax());                          // Expected: 18

        // Contains method
        System.out.println("Does BST contain 7? " + testBST.contains(7));              // Expected: true
        System.out.println("Does BST contain 20? " + testBST.contains(20));            // Expected: false

        // Deleting elements
        System.out.println("Deleting 7: " + testBST.delete(7));                        // Expected: true
        System.out.println("Does BST contain 7 after deletion? " + testBST.contains(7)); // Expected: false

        // Deleting non-existing element
        System.out.println("Deleting 20: " + testBST.delete(20));                      // Expected: false

        // Height after deletion
        System.out.println("Height of BST after deletion: " + testBST.height());            // Should adjust accordingly

        // Clearing the BST
        testBST.clear();
        System.out.println("Is the BST empty after clear()? " + testBST.isEmpty());         // Expected: true

    }
}