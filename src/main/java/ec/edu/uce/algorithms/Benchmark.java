package ec.edu.uce.algorithms;

public class Benchmark {
    private static volatile long result;
    public static void compareIterationRecursion() {
        int[] numbers = {8, 3, 10, 2, 7};
        int number = 5;
        int repetitions = 100000;
        long start;
        long end;
        for (int i = 0; i < 10000; i++) {
            result = Iteration.factorial(number);
            result = Recursion.factorial(number);
            result = Iteration.arraySum(numbers);
            result = Recursion.arraySum(numbers, 0);
            result = Iteration.arrayMaximum(numbers);
            result = Recursion.arrayMaximum(numbers, 0);
        }
        System.out.println("ACTIVITY 2 - EXECUTION TIME");
        System.out.println("Repetitions: " + repetitions);
        System.out.println();
        start = System.nanoTime();
        for (int i = 0; i < repetitions; i++) {
            result = Iteration.factorial(number);
        }
        end = System.nanoTime();
        System.out.println("Iterative factorial: " + (end - start) / (double) repetitions + " ns");
        start = System.nanoTime();
        for (int i = 0; i < repetitions; i++) {
            result = Recursion.factorial(number);
        }
        end = System.nanoTime();
        System.out.println("Recursive factorial: " + (end - start) / (double) repetitions + " ns");
        start = System.nanoTime();
        for (int i = 0; i < repetitions; i++) {
            result = Iteration.arraySum(numbers);
        }
        end = System.nanoTime();
        System.out.println("Iterative array sum: " + (end - start) / (double) repetitions + " ns");
        start = System.nanoTime();
        for (int i = 0; i < repetitions; i++) {
            result = Recursion.arraySum(numbers, 0);
        }
        end = System.nanoTime();
        System.out.println("Recursive array sum: " + (end - start) / (double) repetitions + " ns");
        start = System.nanoTime();
        for (int i = 0; i < repetitions; i++) {
            result = Iteration.arrayMaximum(numbers);
        }
        end = System.nanoTime();
        System.out.println("Iterative array maximum: " + (end - start) / (double) repetitions + " ns");
        start = System.nanoTime();
        for (int i = 0; i < repetitions; i++) {
            result = Recursion.arrayMaximum(numbers, 0);
        }
        end = System.nanoTime();
        System.out.println("Recursive array maximum: " + (end - start) / (double) repetitions + " ns");
        System.out.println();
        System.out.println("EXECUTION TIME TEST FINISHED");
    }
}
