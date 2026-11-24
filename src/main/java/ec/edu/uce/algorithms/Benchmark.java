
package ec.edu.uce.algorithms;
import java.util.Random;
import java.util.Locale;
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
    public static int[] generateArray(int size, String type) {
        int[] numbers = new int[size];
        Random random = new Random(42 + size);
        for (int i = 0; i < size; i++) {
            if (type.equals("Ascending")) {
                numbers[i] = i + 1;
            } else if (type.equals("Descending")) {
                numbers[i] = size - i;
            } else if (type.equals("Random")) {
                numbers[i] = random.nextInt(size * 10);
            } else if (type.equals("Duplicates")) {
                numbers[i] = random.nextInt(5);
            } else if (type.equals("Nearly sorted")) {
                numbers[i] = i + 1;
            }
        }
        if (type.equals("Nearly sorted")) {
            int swaps = Math.max(1, size / 20);
            for (int i = 0; i < swaps; i++) {
                int first = random.nextInt(size - 1);
                int second = first + 1;
                int temp = numbers[first];
                numbers[first] = numbers[second];
                numbers[second] = temp;
            }
        }
        return numbers;
    }
    public static long[] executeSorting(String algorithm, int[] numbers) {
        if (algorithm.equals("Bubble Sort")) {
            return Sorting.bubbleSort(numbers);
        } else if (algorithm.equals("Selection Sort")) {
            return Sorting.selectionSort(numbers);
        } else if (algorithm.equals("Insertion Sort")) {
            return Sorting.insertionSort(numbers);
        } else if (algorithm.equals("Shell Sort")) {
            return Sorting.shellSort(numbers);
        }
        throw new IllegalArgumentException("Invalid sorting algorithm.");
    }
    public static boolean isSorted(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] > numbers[i]) {
                return false;
            }
        }
        return true;
    }
    public static void warmUpSorting() {
        String[] algorithms = {"Bubble Sort", "Selection Sort", "Insertion Sort", "Shell Sort"};
        String[] types = {"Ascending", "Descending", "Random", "Duplicates", "Nearly sorted"};
        for (int i = 0; i < types.length; i++) {
            int[] numbers = generateArray(100, types[i]);
            for (int j = 0; j < algorithms.length; j++) {
                for (int k = 0; k < 200; k++) {
                    int[] copy = numbers.clone();
                    long[] metrics = executeSorting(algorithms[j], copy);
                    result = metrics[0] + metrics[1] + copy[0];
                }
            }
        }
    }
    public static void runExperimentalAnalysis() {
        int[] sizes = {10, 100, 1000, 10000};
        String[] types = {"Ascending", "Descending", "Random", "Duplicates", "Nearly sorted"};
        String[] algorithms = {"Bubble Sort", "Selection Sort", "Insertion Sort", "Shell Sort"};
        int repetitions = 3;
        int totalExecutions = 0;
        int totalRecords = 0;
        warmUpSorting();
        System.out.println();
        System.out.println("ACTIVITY 4 - EXPERIMENTAL ANALYSIS");
        System.out.println("Java version: " + System.getProperty("java.version"));
        System.out.println("Operating system: " + System.getProperty("os.name"));
        System.out.println("Architecture: " + System.getProperty("os.arch"));
        System.out.println("Available processors: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Repetitions per test: " + repetitions);
        System.out.println();
        System.out.printf("%-17s %8s %-15s %15s %15s %15s%n", "Algorithm", "Size", "Data type", "Comparisons", "Movements", "Avg. time (ms)");
        for (int i = 0; i < sizes.length; i++) {
            for (int j = 0; j < types.length; j++) {
                int[] original = generateArray(sizes[i], types[j]);
                for (int k = 0; k < algorithms.length; k++) {
                    long totalTime = 0;
                    long totalComparisons = 0;
                    long totalMovements = 0;
                    for (int r = 0; r < repetitions; r++) {
                        int[] numbers = original.clone();
                        long start = System.nanoTime();
                        long[] metrics = executeSorting(algorithms[k], numbers);
                        long end = System.nanoTime();
                        if (!isSorted(numbers)) {
                            throw new IllegalStateException("Sorting test failed.");
                        }
                        totalTime = totalTime + (end - start);
                        totalComparisons = totalComparisons + metrics[0];
                        totalMovements = totalMovements + metrics[1];
                        totalExecutions = totalExecutions + 1;
                    }
                    double averageTime = totalTime / (repetitions * 1000000.0);
                    double averageComparisons = totalComparisons / (double) repetitions;
                    double averageMovements = totalMovements / (double) repetitions;
                    System.out.printf(Locale.US, "%-17s %8d %-15s %15.0f %15.0f %15.6f%n", algorithms[k], sizes[i], types[j], averageComparisons, averageMovements, averageTime);
                    totalRecords = totalRecords + 1;
                }
            }
        }
        System.out.println();
        System.out.println("Total executions: " + totalExecutions);
        System.out.println("Total records: " + totalRecords);
        System.out.println("All experimental sorting tests passed.");
        System.out.println("EXPERIMENTAL ANALYSIS FINISHED");
    }
}
