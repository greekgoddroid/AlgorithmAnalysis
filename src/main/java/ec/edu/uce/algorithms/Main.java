package ec.edu.uce.algorithms;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {8, 32, 128, 1024, 1048576};
        for (int s = 0; s < numbers.length; s++) {
            int number = numbers[s];
            long checkSum = 0;
            for (int i = 0; i < 10000; i++) {
                checkSum = checkSum
                        + ComplexityAnalysis.logarithmicDivisionForTime(number);
            }
            long totalTime = 0;
            for (int test = 1; test <= 3; test++) {
                long startTime = System.nanoTime();
                for (int i = 0; i < 100000; i++) {
                    checkSum = checkSum
                            + ComplexityAnalysis.logarithmicDivisionForTime(number);
                }
                long endTime = System.nanoTime();
                long executionTime = endTime - startTime;
                totalTime = totalTime + executionTime;
                System.out.println("Test " + test);
                System.out.println("Batch time (ns): " + executionTime);
            }
            double averageTime = totalTime / 3.0;
            double timePerExecution = averageTime / 100000.0;
            System.out.println("Input number: " + number);
            System.out.println("Divisions: "
                    + ComplexityAnalysis.logarithmicDivisionForTime(number));
            System.out.println("Average per execution (ns): " + timePerExecution);
            System.out.println("Check sum: " + checkSum);
            System.out.println("----------------------");
        }
    }
}
