package task2;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzTest {
    public static void main(String[] args) {

        FizzBuzz threadA = new FizzBuzz((number) -> {
            if (number % 3 == 0 && number % 5 != 0) {
                System.out.println("fizz");
            }
        });

        FizzBuzz threadB = new FizzBuzz((number) -> {
            if (number % 5 == 0 && number % 3 != 0) {

                System.out.println("buzz");
            }
        });

        FizzBuzz threadC = new FizzBuzz((number) -> {
            if (number % 3 == 0 && number % 5 == 0) {
                System.out.println("fizzbuzz");
            }
        });

        FizzBuzz threadD = new FizzBuzz((number) -> {
            if (number % 3 != 0 && number % 5 != 0) {
                System.out.println(number);
            }
        });


        List<FizzBuzz> threads = new ArrayList<>();
        threads.add(threadA);
        threads.add(threadB);
        threads.add(threadC);
        threads.add(threadD);

        for (FizzBuzz thread : threads) {
            thread.start();
        }


        for (int i = 1; i <= 50; i++) {
            for (FizzBuzz thread : threads) {
                thread.process(i);
            }

            while (true) {
                int counter = 0;
                for (FizzBuzz thread : threads) {
                    if (thread.isProcessed()) {
                        counter++;
                    }
                }
                if (counter == threads.size()) {
                    break;
                }
            }
        }
    }
}