package CS113;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        LinkedList<Integer> goArray = new LinkedList<>();
        LinkedListDAD<Integer> testArray = new LinkedListDAD<>();

        for (int i = 0; i < 10; i++) {
            testArray.add(i);
            goArray.add(i);
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

    }
}