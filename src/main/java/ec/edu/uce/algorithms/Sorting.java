
package ec.edu.uce.algorithms;
public class Sorting {
    public static long[] bubbleSort(int[] numbers) {
        long comparisons = 0;
        long movements = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                comparisons = comparisons + 1;
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    movements = movements + 2;
                }
            }
        }
        return new long[]{comparisons, movements};
    }
    public static long[] selectionSort(int[] numbers) {
        long comparisons = 0;
        long movements = 0;
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
                movements = movements + 2;
            }
        }
        return new long[]{comparisons, movements};
    }
    public static long[] insertionSort(int[] numbers) {
        long comparisons = 0;
        long movements = 0;
        for (int i = 1; i < numbers.length; i++) {
            int key = numbers[i];
            int j = i - 1;
            while (j >= 0) {
                comparisons = comparisons + 1;
                if (numbers[j] > key) {
                    numbers[j + 1] = numbers[j];
                    movements = movements + 1;
                    j = j - 1;
                } else {
                    break;
                }
            }
            numbers[j + 1] = key;
            movements = movements + 1;
        }
        return new long[]{comparisons, movements};
    }
    public static long[] shellSort(int[] numbers) {
        long comparisons = 0;
        long movements = 0;
        for (int gap = numbers.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < numbers.length; i++) {
                int temp = numbers[i];
                int j = i;
                while (j >= gap) {
                    comparisons = comparisons + 1;
                    if (numbers[j - gap] > temp) {
                        numbers[j] = numbers[j - gap];
                        movements = movements + 1;
                        j = j - gap;
                    } else {
                        break;
                    }
                }
                numbers[j] = temp;
                movements = movements + 1;
            }
        }
        return new long[]{comparisons, movements};
    }
}
