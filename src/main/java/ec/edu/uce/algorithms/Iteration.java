package ec.edu.uce.algorithms;

public class Iteration {
    public static long factorial(int number) {
        if (number < 0 || number > 20) {
            System.out.println("Invalid number for factorial.");
            return -1;
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
            System.out.println("The array is empty.");
            return -1;
        }
        int maximum = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > maximum) {
                maximum = numbers[i];
            }
        }
        return maximum;
    }
}
