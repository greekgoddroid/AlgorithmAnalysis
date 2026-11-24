package ec.edu.uce.algorithms;
import java.util.Locale;
public class ComplexityAnalysis {
    private static volatile int result;
    public static void linearSum(int[] numbers) {
        int sum = 0;
        int operations = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
            operations = operations + 1;
        }
        System.out.println("Sum: " + sum);
        System.out.println("Operations: " + operations);
    }
    public static int linearSumForTime(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
        }
        return sum;
    }
    public static void quadraticComparison(int[] numbers) {
        int comparisons = 0;
        int equalNumbers = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    equalNumbers = equalNumbers + 1;
                }
                comparisons = comparisons + 1;
            }
        }
        System.out.println("Algorithm B - O(n^2)");
        System.out.println("Input size: " + numbers.length);
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Equal matches: " + equalNumbers);
    }
    public static int quadraticComparisonForTime(int[] numbers) {
        int equalNumbers = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    equalNumbers = equalNumbers + 1;
                }
            }
        }
        return equalNumbers;
    }
    public static void logarithmicDivision(int number) {
        int operations = 0;
        if (number < 1) {
            System.out.println("The number must be positive.");
            return;
        }
        while (number > 1) {
            number = number / 2;
            operations = operations + 1;
        }
        System.out.println("Algorithm C - O(log n)");
        System.out.println("Divisions: " + operations);
    }
    public static int logarithmicDivisionForTime(int number) {
        int operations = 0;
        if (number < 1) {
            return 0;
        }
        while (number > 1) {
            number = number / 2;
            operations = operations + 1;
        }
        return operations;
    }
    public static int[] generateNumbers(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = i + 1;
        }
        return numbers;
    }
    public static long countLinearOperations(int[] numbers) {
        long operations = 0;
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
            operations = operations + 1;
        }
        result = sum;
        return operations;
    }
    public static long countQuadraticOperations(int[] numbers) {
        long operations = 0;
        int equalNumbers = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    equalNumbers = equalNumbers + 1;
                }
                operations = operations + 1;
            }
        }
        result = equalNumbers;
        return operations;
    }
    public static void warmUpComplexity() {
        int[] numbers = generateNumbers(100);
        for (int i = 0; i < 10000; i++) {
            result = linearSumForTime(numbers);
            result = logarithmicDivisionForTime(1024);
        }
        for (int i = 0; i < 1000; i++) {
            result = quadraticComparisonForTime(numbers);
        }
    }
    public static void runComplexityTests() {
        int[] sizes = {10, 100, 1000, 10000};
        int[] logarithmicSizes = {2, 8, 32, 128, 1024, 1048576};
        int repetitions = 3;
        warmUpComplexity();
        System.out.println();
        System.out.println("ACTIVITY 1 - EXPERIMENTAL COMPLEXITY ANALYSIS");
        System.out.println("Repetitions: " + repetitions);
        System.out.println();
        System.out.printf("%-15s %12s %15s %15s %15s%n", "Algorithm", "Size", "Theoretical", "Experimental", "Avg. time (ns)");
        for (int i = 0; i < sizes.length; i++) {
            int[] numbers = generateNumbers(sizes[i]);
            long theoretical = sizes[i];
            long experimental = countLinearOperations(numbers);
            long totalTime = 0;
            int executions = 1000;
            for (int r = 0; r < repetitions; r++) {
                long start = System.nanoTime();
                for (int j = 0; j < executions; j++) {
                    result = linearSumForTime(numbers);
                }
                long end = System.nanoTime();
                totalTime = totalTime + (end - start);
            }
            double averageTime = totalTime / (double) (repetitions * executions);
            printComplexityResult("Linear", sizes[i], theoretical, experimental, averageTime);
        }
        for (int i = 0; i < sizes.length; i++) {
            int[] numbers = generateNumbers(sizes[i]);
            long theoretical = (long) sizes[i] * sizes[i];
            long experimental = countQuadraticOperations(numbers);
            long totalTime = 0;
            for (int r = 0; r < repetitions; r++) {
                long start = System.nanoTime();
                result = quadraticComparisonForTime(numbers);
                long end = System.nanoTime();
                totalTime = totalTime + (end - start);
            }
            double averageTime = totalTime / (double) repetitions;
            printComplexityResult("Quadratic", sizes[i], theoretical, experimental, averageTime);
        }
        for (int i = 0; i < logarithmicSizes.length; i++) {
            int number = logarithmicSizes[i];
            long theoretical = 31 - Integer.numberOfLeadingZeros(number);
            long experimental = logarithmicDivisionForTime(number);
            long totalTime = 0;
            int executions = 100000;
            for (int r = 0; r < repetitions; r++) {
                long start = System.nanoTime();
                for (int j = 0; j < executions; j++) {
                    result = logarithmicDivisionForTime(number);
                }
                long end = System.nanoTime();
                totalTime = totalTime + (end - start);
            }
            double averageTime = totalTime / (double) (repetitions * executions);
            printComplexityResult("Logarithmic", number, theoretical, experimental, averageTime);
        }
        System.out.println();
        System.out.println("All complexity operation counts matched.");
        System.out.println("EXPERIMENTAL COMPLEXITY ANALYSIS FINISHED");
        System.out.println();
    }
    public static void printComplexityResult(String algorithm, int size, long theoretical, long experimental, double averageTime) {
        if (theoretical != experimental) {
            throw new IllegalStateException("Complexity operation count failed.");
        }
        System.out.printf(Locale.US, "%-15s %12d %15d %15d %15.3f%n", algorithm, size, theoretical, experimental, averageTime);
    }
}
