package CS113;

import java.util.LinkedList;
import java.util.Random;

import CS113.ArrayList.ArrayListDAD;
import CS113.Graphs.GraphInterfaceDAD;
import CS113.HashMap.HashMapDAD;
import CS113.LinkedList.LinkedListDAD;
import CS113.PriorityQueue.PriorityQueueDAD;
import CS113.SearchTrees.AVLTreeDAD;
import CS113.SearchTrees.BinarySearchTreeDAD;
import CS113.Sorting.SortingDAD;
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
        // changed initialization closer to tests for easier tracking


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

        BinarySearchTreeDAD<Integer> testBST = new BinarySearchTreeDAD<>();

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



        // ===========================
        // Testing AVLTreeDAD
        // ===========================
        System.out.println("");
        System.out.println("Testing AVLTreeDAD");

        AVLTreeDAD<Integer> avlDAD = new AVLTreeDAD<>();

        // Inserting in a way that will cause right-heavy imbalance
        int[] values = {10, 20, 30, 40, 50}; 

        System.out.println("Inserting values: ");
        for (int val : values) {
            avlDAD.insert(val);
            System.out.print(val + " ");
        }
        System.out.println();
        System.out.println("Height of AVL Tree: " + avlDAD.height());

        System.out.println("\nIn-order traversal after balancing:");
        System.out.println(avlDAD.toString());                                              // Should print 10 20 30 40 50 in order

        System.out.println("Height of AVL Tree: " + avlDAD.height());

        System.out.println();
        System.out.println("Tree structure:");
        avlDAD.printTree();



        // ===========================
        // Testing PriorityQueueDAD
        // ===========================
        System.out.println("");
        System.out.println("Testing PriorityQueueDAD");

        PriorityQueueDAD<Integer> pqDAD = new PriorityQueueDAD<>();

        System.out.println("Inserting values: ");
        for (int i = 10; i > 0; i--) {
            pqDAD.add(i);
            System.out.print(i + " ");
        }
        System.out.println("\n");

        System.out.println("result:");
        System.out.println(pqDAD.toString());
        System.out.println("");

        System.out.println("Poll:");
        pqDAD.poll();
        System.out.println(pqDAD.toString());
        System.out.println("Poll again:");
        pqDAD.poll();
        System.out.println(pqDAD.toString());
        System.out.println("");

        System.out.println("Peek:");
        System.out.println(pqDAD.peek().toString());



        // ===========================
        // Testing HashMapDAD
        // ===========================
        System.out.println("");
        System.out.println("Testing HashMapDAD");

        HashMapDAD<String, Integer> map = new HashMapDAD<>();
        System.out.println("");

        // Insert values
        map.put("apple", 5);
        map.put("banana", 10);
        map.put("cherry", 15);
        map.put("date", 20);
        map.put("elderberry", 25);

        // Test get()
        System.out.println("Value for 'banana': " + map.get("banana")); // 10

        // Test containsKey()
        System.out.println("Contains 'cherry'? " + map.containsKey("cherry")); // true
        System.out.println("Contains 'fig'? " + map.containsKey("fig")); // false

        // Test containsValue()
        System.out.println("Contains value 25? " + map.containsValue(25)); // true
        System.out.println("Contains value 99? " + map.containsValue(99)); // false

        // Test keySet()
        System.out.println("All keys: " + map.keySet());

        // Test values()
        System.out.println("All values: " + map.values());

        // Trigger rehash
        map.put("fig", 30);
        map.put("grape", 35);
        map.put("honeydew", 40);
        map.put("kiwi", 45);
        map.put("lemon", 50); // Should force a resize and rehash

        System.out.println("Keys after rehash: " + map.keySet());
        System.out.println("Values after rehash: " + map.values());
        System.out.println("Size: " + map.size());

        // Clear test
        map.clear();
        System.out.println("Size after clear: " + map.size());
        System.out.println("Is empty? " + map.isEmpty());



        // ===========================
        // Testing SortingDAD
        // ===========================
        SortingDAD<Integer> sortDAD = new SortingDAD<>();
        ArrayListDAD<Integer> sortTestArray = new ArrayListDAD<>();

        System.out.println("");
        System.out.println("Testing SortingDAD: bubbly sort");

        int sortDADTests = 10;
        Random rand = new Random();

        for (int i = 0; i < sortDADTests; i++) {
            sortTestArray.add(i + rand.nextInt(100));
        }

        // Bubble sort test
        System.out.println("Current array: " + sortTestArray.toString());
        sortDAD.bubbleSort(sortTestArray);
        System.out.println("After bubble sort: " + sortTestArray.toString());

        // resetting test
        sortTestArray.clear();
        for (int i = 0; i < sortDADTests; i++) {
            sortTestArray.add(i + rand.nextInt(100));
        }


        // Insertion sort test
        System.out.println("\nNew Test");
        System.out.println("Testing SortingDAD: insertion sort");

        System.out.println("Current array: " + sortTestArray.toString());
        sortDAD.insertionSort(sortTestArray);
        System.out.println("After insertion sort: " + sortTestArray.toString());

        // resetting test
        sortTestArray.clear();
        for (int i = 0; i < sortDADTests; i++) {
            sortTestArray.add(i + rand.nextInt(100));
        }


        // Merge sort test
        System.out.println("\nNew Test");
        System.out.println("Testing SortingDAD: merge sort");

        System.out.println("Current array:    " + sortTestArray.toString());
        sortTestArray = sortDAD.MergeSort(sortTestArray);
        System.out.println("After merge sort: " + sortTestArray.toString());

        // resetting test
        sortTestArray.clear();
        for (int i = 0; i < sortDADTests; i++) {
            sortTestArray.add(i + rand.nextInt(100));
        }


        // Selection sort test
        System.out.println("\nNew Test");
        System.out.println("Testing SortingDAD: selection sort");

        System.out.println("Current array:        " + sortTestArray.toString());
        sortDAD.SelectionSort(sortTestArray);
        System.out.println("After selection sort: " + sortTestArray.toString());

        // resetting test
        sortTestArray.clear();
        for (int i = 0; i < sortDADTests; i++) {
            sortTestArray.add(i + rand.nextInt(100));
        }


        // Quick sort test
        System.out.println("\nNew Test");
        System.out.println("Testing SortingDAD: quick sort");

        System.out.println("Current array:    " + sortTestArray.toString());
        sortTestArray = sortDAD.QuickSort(sortTestArray);
        System.out.println("After quick sort: " + sortTestArray.toString());



        // ===========================
        // Testing GraphInterfaceDAD
        // ===========================
        System.out.println("\nNew Test");
        System.out.println("Testing GraphInterfaceDAD");
        GraphInterfaceDAD giDAD = new GraphInterfaceDAD();

        // Add nodes
        giDAD.addNode("A");
        giDAD.addNode("B");
        giDAD.addNode("C");

        // Add directed edges
        giDAD.addEdge("A", "B", true);
        giDAD.addEdge("A", "C", true);
        giDAD.addEdge("B", "C", true);

        // Print adjacency matrix
        System.out.println("Adjacency Matrix:");
        giDAD.printGraph();
    }
}