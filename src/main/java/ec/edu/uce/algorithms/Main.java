
package ec.edu.uce.algorithms;
public class Main {
    public static void main(String[] args) {
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
        System.out.println("ACTIVITY 2 - ITERATION");
        System.out.println("Factorial of 5: " + Iteration.factorial(5));
        System.out.println("Array sum: " + Iteration.arraySum(numbers));
        System.out.println("Array maximum: " + Iteration.arrayMaximum(numbers));
        System.out.println();
        System.out.println("ACTIVITY 2 - RECURSION");
        System.out.println("Factorial of 5: " + Recursion.factorial(5));
        System.out.println("Array sum: " + Recursion.arraySum(numbers, 0));
        System.out.println("Array maximum: " + Recursion.arrayMaximum(numbers, 0));
        int[] emptyArray = {};
        int[] negativeNumbers = {-8, -3, -10, -2, -7};
        int[] singleNumber = {7};
        System.out.println();
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
        Benchmark.compareIterationRecursion();
        System.out.println();
        System.out.println("ACTIVITY 3 - SORTING ALGORITHMS");
        System.out.println();
        System.out.println("BUBBLE SORT");
        int[] bubbleNumbers = {45, 12, 90, 12, 3, 70, 45, 18};
        System.out.print("Original array: ");
        printArray(bubbleNumbers);
        Sorting.bubbleSort(bubbleNumbers);
        System.out.print("Sorted array: ");
        printArray(bubbleNumbers);
        System.out.println();
        System.out.println("BUBBLE SORT TEST FINISHED");
        System.out.println();
        System.out.println("SELECTION SORT");
        int[] selectionNumbers = {45, 12, 90, 12, 3, 70, 45, 18};
        System.out.print("Original array: ");
        printArray(selectionNumbers);
        Sorting.selectionSort(selectionNumbers);
        System.out.print("Sorted array: ");
        printArray(selectionNumbers);
        System.out.println();
        System.out.println("SELECTION SORT TEST FINISHED");
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
