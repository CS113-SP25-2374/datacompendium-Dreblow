package CS113;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ArrayList<Integer> goArray = new ArrayList<>();
        ArrayListDAD<Integer> testArray = new ArrayListDAD<>();

        for (int i = 0; i < 10; i++) {
            testArray.add(i);
            goArray.add(i);
        }

        goArray.add(4, null);
        testArray.add(4, null);

        System.out.println(goArray);
        System.out.println(goArray.size());

        System.out.println(testArray);
        System.out.println(testArray.size());

        testArray.clear();

        System.out.println(goArray);

    }
}