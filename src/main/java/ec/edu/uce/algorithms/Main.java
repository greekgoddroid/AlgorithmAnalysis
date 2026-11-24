
package ec.edu.uce.algorithms;
public class Main {
    public static void main(String[] args) {
        runComplexityAnalysis();
        runIterationRecursion();
        runSpecialCases();
        runOperationCount();
        Benchmark.compareIterationRecursion();
        runSortingAlgorithms();
        runSortingSpecialCases();
        Benchmark.compareSortingAlgorithms();
        Benchmark.runExperimentalAnalysis();
    }
    public static void runComplexityAnalysis() {
        int[] numbers = {8, 3, 10, 2, 7};
        System.out.println("ACTIVITY 1 - COMPLEXITY ANALYSIS");
        System.out.println();
        System.out.println("ALGORITHM A - LINEAR");
        ComplexityAnalysis.linearSum(numbers);
        System.out.println();
        System.out.println("ALGORITHM B - QUADRATIC");
        ComplexityAnalysis.quadraticComparison(numbers);
        System.out.println();
        System.out.println("ALGORITHM C - LOGARITHMIC");
        ComplexityAnalysis.logarithmicDivision(32);
        System.out.println();
        System.out.println("ACTIVITY 1 FINISHED");
        System.out.println();
    }
    public static void runIterationRecursion() {
        int[] numbers = {8, 3, 10, 2, 7};
        System.out.println("ACTIVITY 2 - ITERATION");
        System.out.println("Factorial of 5: " + Iteration.factorial(5));
        System.out.println("Array sum: " + Iteration.arraySum(numbers));
        System.out.println("Array maximum: " + Iteration.arrayMaximum(numbers));
        System.out.println();
        System.out.println("ACTIVITY 2 - RECURSION");
        System.out.println("Factorial of 5: " + Recursion.factorial(5));
        System.out.println("Array sum: " + Recursion.arraySum(numbers, 0));
        System.out.println("Array maximum: " + Recursion.arrayMaximum(numbers, 0));
        System.out.println();
    }
    public static void runSpecialCases() {
        int[] numbers = {8, 3, 10, 2, 7};
        int[] emptyArray = {};
        int[] negativeNumbers = {-8, -3, -10, -2, -7};
        int[] singleNumber = {7};
        System.out.println("ACTIVITY 2 - SPECIAL CASES");
        System.out.println();
        System.out.println("ITERATIVE TESTS");
        System.out.println("Factorial of 0: " + Iteration.factorial(0));
        System.out.println("Factorial of 1: " + Iteration.factorial(1));
        System.out.println("Empty array sum: " + Iteration.arraySum(emptyArray));
        System.out.println("Negative array maximum: " + Iteration.arrayMaximum(negativeNumbers));
        System.out.println("Single element maximum: " + Iteration.arrayMaximum(singleNumber));
        try {
            Iteration.factorial(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Factorial of -5: " + e.getMessage());
        }
        try {
            Iteration.factorial(21);
        } catch (IllegalArgumentException e) {
            System.out.println("Factorial of 21: " + e.getMessage());
        }
        try {
            Iteration.arrayMaximum(emptyArray);
        } catch (IllegalArgumentException e) {
            System.out.println("Empty array maximum: " + e.getMessage());
        }
        System.out.println();
        System.out.println("RECURSIVE TESTS");
        System.out.println("Factorial of 0: " + Recursion.factorial(0));
        System.out.println("Factorial of 1: " + Recursion.factorial(1));
        System.out.println("Empty array sum: " + Recursion.arraySum(emptyArray, 0));
        System.out.println("Negative array maximum: " + Recursion.arrayMaximum(negativeNumbers, 0));
        System.out.println("Single element maximum: " + Recursion.arrayMaximum(singleNumber, 0));
        try {
            Recursion.factorial(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Factorial of -5: " + e.getMessage());
        }
        try {
            Recursion.factorial(21);
        } catch (IllegalArgumentException e) {
            System.out.println("Factorial of 21: " + e.getMessage());
        }
        try {
            Recursion.arrayMaximum(emptyArray, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Empty array maximum: " + e.getMessage());
        }
        try {
            Recursion.arraySum(numbers, -1);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid sum index: " + e.getMessage());
        }
        try {
            Recursion.arrayMaximum(numbers, numbers.length);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid maximum index: " + e.getMessage());
        }
        System.out.println();
        System.out.println("SPECIAL CASE TESTS FINISHED");
        System.out.println();
    }
    public static void runOperationCount() {
        int[] numbers = {8, 3, 10, 2, 7};
        System.out.println("ACTIVITY 2 - OPERATION COUNT");
        System.out.println();
        System.out.println("ITERATIVE OPERATIONS");
        System.out.println("Factorial multiplications: " + Iteration.factorialOperations(5));
        System.out.println("Array sum additions: " + Iteration.sumOperations(numbers));
        System.out.println("Array maximum comparisons: " + Iteration.maximumOperations(numbers));
        System.out.println();
        System.out.println("RECURSIVE OPERATIONS");
        System.out.println("Factorial multiplications: " + Recursion.factorialOperations(5));
        System.out.println("Array sum additions: " + Recursion.sumOperations(numbers));
        System.out.println("Array maximum comparisons: " + Recursion.maximumOperations(numbers));
        System.out.println();
        System.out.println("OPERATION COUNT FINISHED");
        System.out.println();
    }
    public static void runSortingAlgorithms() {
        int[] numbers = {45, 12, 90, 12, 3, 70, 45, 18};
        int[] expected = {3, 12, 12, 18, 45, 45, 70, 90};
        System.out.println();
        System.out.println("ACTIVITY 3 - SORTING ALGORITHMS");
        System.out.println();
        testSortingAlgorithms(numbers, expected);
        System.out.println("SORTING ALGORITHMS TEST FINISHED");
    }
    public static void runSortingSpecialCases() {
        System.out.println();
        System.out.println("ACTIVITY 3 - SORTING SPECIAL CASES");
        System.out.println();
        System.out.println("CASE 1 - EMPTY ARRAY");
        testSortingAlgorithms(new int[]{}, new int[]{});
        System.out.println("CASE 2 - SINGLE ELEMENT");
        testSortingAlgorithms(new int[]{7}, new int[]{7});
        System.out.println("CASE 3 - DUPLICATE ELEMENTS");
        testSortingAlgorithms(new int[]{5, 2, 5, 2, 5}, new int[]{2, 2, 5, 5, 5});
        System.out.println("CASE 4 - SORTED ARRAY");
        testSortingAlgorithms(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5});
        System.out.println("CASE 5 - REVERSE SORTED ARRAY");
        testSortingAlgorithms(new int[]{5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5});
        System.out.println("SORTING SPECIAL CASES FINISHED");
    }
    public static void testSortingAlgorithms(int[] numbers, int[] expected) {
        int[] bubbleNumbers = numbers.clone();
        int[] selectionNumbers = numbers.clone();
        int[] insertionNumbers = numbers.clone();
        int[] shellNumbers = numbers.clone();
        System.out.print("Original array: ");
        printArray(numbers);
        System.out.println();
        long[] bubbleResults = Sorting.bubbleSort(bubbleNumbers);
        printSortingResult("BUBBLE SORT", bubbleNumbers, expected, bubbleResults);
        long[] selectionResults = Sorting.selectionSort(selectionNumbers);
        printSortingResult("SELECTION SORT", selectionNumbers, expected, selectionResults);
        long[] insertionResults = Sorting.insertionSort(insertionNumbers);
        printSortingResult("INSERTION SORT", insertionNumbers, expected, insertionResults);
        long[] shellResults = Sorting.shellSort(shellNumbers);
        printSortingResult("SHELL SORT", shellNumbers, expected, shellResults);
    }
    public static void printSortingResult(String algorithm, int[] numbers, int[] expected, long[] results) {
        System.out.println(algorithm);
        System.out.println("Comparisons: " + results[0]);
        System.out.println("Movements: " + results[1]);
        System.out.print("Sorted array: ");
        printArray(numbers);
        if (checkResult(numbers, expected)) {
            System.out.println("Test result: PASSED");
        } else {
            System.out.println("Test result: FAILED");
        }
        System.out.println();
    }
    public static boolean checkResult(int[] numbers, int[] expected) {
        if (numbers.length != expected.length) {
            return false;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != expected[i]) {
                return false;
            }
        }
        return true;
    }
    public static void printArray(int[] numbers) {
        System.out.print("[");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
