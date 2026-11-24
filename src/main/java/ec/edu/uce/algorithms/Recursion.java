
package ec.edu.uce.algorithms;
public class Recursion {
    private static int operations;
    public static long factorial(int number) {
        if (number < 0 || number > 20) {
            throw new IllegalArgumentException("Invalid number for factorial.");
        }
        if (number == 0 || number == 1) {
            return 1;
        }
        return number * factorial(number - 1);
    }
    public static int arraySum(int[] numbers, int index) {
        if (index < 0 || index > numbers.length) {
            throw new IllegalArgumentException("Invalid index.");
        }
        if (index == numbers.length) {
            return 0;
        }
        return numbers[index] + arraySum(numbers, index + 1);
    }
    public static int arrayMaximum(int[] numbers, int index) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("The array is empty.");
        }
        if (index < 0 || index >= numbers.length) {
            throw new IllegalArgumentException("Invalid index.");
        }
        if (index == numbers.length - 1) {
            return numbers[index];
        }
        int maximum = arrayMaximum(numbers, index + 1);
        if (numbers[index] > maximum) {
            return numbers[index];
        }
        return maximum;
    }
    public static int factorialOperations(int number) {
        if (number < 0 || number > 20) {
            throw new IllegalArgumentException("Invalid number for factorial.");
        }
        operations = 0;
        countedFactorial(number);
        return operations;
    }
    private static long countedFactorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        }
        operations = operations + 1;
        return number * countedFactorial(number - 1);
    }
    public static int sumOperations(int[] numbers) {
        operations = 0;
        countedSum(numbers, 0);
        return operations;
    }
    private static int countedSum(int[] numbers, int index) {
        if (index == numbers.length) {
            return 0;
        }
        operations = operations + 1;
        return numbers[index] + countedSum(numbers, index + 1);
    }
    public static int maximumOperations(int[] numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("The array is empty.");
        }
        operations = 0;
        countedMaximum(numbers, 0);
        return operations;
    }
    private static int countedMaximum(int[] numbers, int index) {
        if (index == numbers.length - 1) {
            return numbers[index];
        }
        int maximum = countedMaximum(numbers, index + 1);
        operations = operations + 1;
        if (numbers[index] > maximum) {
            return numbers[index];
        }
        return maximum;
    }
}
