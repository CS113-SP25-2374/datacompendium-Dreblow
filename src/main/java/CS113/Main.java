package CS113;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ArrayList<Integer> goArray = new ArrayList<Integer>();
        ArrayListDAD<Integer> testArray = new ArrayListDAD<Integer>();

        for (int i = 0; i < 10; i++) {
            testArray.add(i);
        }

        goArray.add(4, null);
        testArray.add(4, null);

        System.out.println(testArray);
        System.out.println(testArray.size());

        System.out.println(goArray);

    }
}