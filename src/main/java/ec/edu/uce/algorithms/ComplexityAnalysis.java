package ec.edu.uce.algorithms;

public class ComplexityAnalysis {
    public static void linearSum(int[] numbers) {
        int sum = 0;
        int operations = 0;
        for (int i = 0; i < numbers.length; i++ ){
            sum = sum + numbers[i];
            operations = operations + 1;
        }
        System.out.println("Sum: " + sum);
        System.out.println("Operations: " + operations);
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
    }
