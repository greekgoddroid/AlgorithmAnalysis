
package ec.edu.uce.algorithms;
public class Sorting {
    public static void bubbleSort(int[] numbers) {
        int comparisons = 0;
        int swaps = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                comparisons = comparisons + 1;
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    swaps = swaps + 1;
                }
            }
        }
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
    }
    public static void selectionSort(int[] numbers) {
        int comparisons = 0;
        int swaps = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            int minimum = i;
            for (int j = i + 1; j < numbers.length; j++) {
                comparisons = comparisons + 1;
                if (numbers[j] < numbers[minimum]) {
                    minimum = j;
                }
            }
            if (minimum != i) {
                int temp = numbers[i];
                numbers[i] = numbers[minimum];
                numbers[minimum] = temp;
                swaps = swaps + 1;
            }
        }
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
    }
}
