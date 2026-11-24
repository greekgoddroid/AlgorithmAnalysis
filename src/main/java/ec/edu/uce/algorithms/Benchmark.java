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
    public static void compareSortingAlgorithms() {
        int[] numbers = {45, 12, 90, 12, 3, 70, 45, 18};
        int repetitions = 10000;
        long bubbleTime = 0;
        long selectionTime = 0;
        long insertionTime = 0;
        long shellTime = 0;
        long start;
        long end;
        for (int i = 0; i < 10000; i++) {
            Sorting.bubbleSort(numbers.clone());
            Sorting.selectionSort(numbers.clone());
            Sorting.insertionSort(numbers.clone());
            Sorting.shellSort(numbers.clone());
        }
        for (int i = 0; i < repetitions; i++) {
            int[] bubbleNumbers = numbers.clone();
            int[] selectionNumbers = numbers.clone();
            int[] insertionNumbers = numbers.clone();
            int[] shellNumbers = numbers.clone();
            start = System.nanoTime();
            long[] bubbleResults = Sorting.bubbleSort(bubbleNumbers);
            end = System.nanoTime();
            bubbleTime = bubbleTime + (end - start);
            result = bubbleResults[0] + bubbleResults[1] + bubbleNumbers[0];
            start = System.nanoTime();
            long[] selectionResults = Sorting.selectionSort(selectionNumbers);
            end = System.nanoTime();
            selectionTime = selectionTime + (end - start);
            result = selectionResults[0] + selectionResults[1] + selectionNumbers[0];
            start = System.nanoTime();
            long[] insertionResults = Sorting.insertionSort(insertionNumbers);
            end = System.nanoTime();
            insertionTime = insertionTime + (end - start);
            result = insertionResults[0] + insertionResults[1] + insertionNumbers[0];
            start = System.nanoTime();
            long[] shellResults = Sorting.shellSort(shellNumbers);
            end = System.nanoTime();
            shellTime = shellTime + (end - start);
            result = shellResults[0] + shellResults[1] + shellNumbers[0];
        }
        System.out.println();
        System.out.println("ACTIVITY 3 - SORTING EXECUTION TIME");
        System.out.println("Array size: " + numbers.length);
        System.out.println("Repetitions: " + repetitions);
        System.out.println();
        System.out.println("Bubble Sort: " + bubbleTime / (double) repetitions + " ns");
        System.out.println("Selection Sort: " + selectionTime / (double) repetitions + " ns");
        System.out.println("Insertion Sort: " + insertionTime / (double) repetitions + " ns");
        System.out.println("Shell Sort: " + shellTime / (double) repetitions + " ns");
        System.out.println();
        System.out.println("AVERAGE EXECUTION TIME IN MILLISECONDS");
        System.out.println("Bubble Sort: " + bubbleTime / (repetitions * 1000000.0) + " ms");
        System.out.println("Selection Sort: " + selectionTime / (repetitions * 1000000.0) + " ms");
        System.out.println("Insertion Sort: " + insertionTime / (repetitions * 1000000.0) + " ms");
        System.out.println("Shell Sort: " + shellTime / (repetitions * 1000000.0) + " ms");
        System.out.println();
        System.out.println("SORTING EXECUTION TIME TEST FINISHED");
    }
}
