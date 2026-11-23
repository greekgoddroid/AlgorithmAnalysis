package ec.edu.uce.algorithms;

public class Recursion {
    public static long factorial(int number) {
        if (number < 0 || number > 20) {
            System.out.println("Invalid number for factorial.");
            return -1;
        }
        if (number == 0 || number == 1) {
            return 1;
        }
        return number * factorial(number - 1);
    }
    public static int arraySum(int[] numbers, int index) {
        if (index == numbers.length) {
            return 0;
        }
        return numbers[index] + arraySum(numbers, index + 1);
    }
    public static int arrayMaximum(int[] numbers, int index) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("The array is empty.");
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
}
