
package ec.edu.uce.algorithms;
public class Iteration {
    public static long factorial(int number) {
        if (number < 0 || number > 20) {
            throw new IllegalArgumentException("Invalid number for factorial.");
        }
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result = result * i;
        }
        return result;
    }
    public static int arraySum(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
        }
        return sum;
    }
    public static int arrayMaximum(int[] numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("The array is empty.");
        }
        int maximum = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > maximum) {
                maximum = numbers[i];
            }
        }
        return maximum;
    }
    public static int factorialOperations(int number) {
        if (number < 0 || number > 20) {
            throw new IllegalArgumentException("Invalid number for factorial.");
        }
        long result = 1;
        int operations = 0;
        for (int i = 1; i <= number; i++) {
            result = result * i;
            operations = operations + 1;
        }
        return operations;
    }
    public static int sumOperations(int[] numbers) {
        int sum = 0;
        int operations = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
            operations = operations + 1;
        }
        return operations;
    }
    public static int maximumOperations(int[] numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("The array is empty.");
        }
        int maximum = numbers[0];
        int operations = 0;
        for (int i = 1; i < numbers.length; i++) {
            operations = operations + 1;
            if (numbers[i] > maximum) {
                maximum = numbers[i];
            }
        }
        return operations;
    }
}
