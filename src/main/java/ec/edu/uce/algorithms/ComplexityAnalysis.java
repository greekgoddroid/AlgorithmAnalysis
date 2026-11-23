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
}
