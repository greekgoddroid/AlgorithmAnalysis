package ec.edu.uce.algorithms;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {8, 3, 10, 2, 7};
        System.out.println("ACTIVITY 1 - COMPLEXITY ANALYSIS");
        System.out.println();
        System.out.println("ALGORITHM A - LINEAR");
        ComplexityAnalysis.linearSum(numbers);
        System.out.println();
        System.out.println("ALGORITHM B - QUADRATIC");
        ComplexityAnalysis.quadraticComparison(numbers);
        System.out.println();
        System.out.println("ALGORITHM C - LOGARITHMIC");
        ComplexityAnalysis.logarithmicDivision(32);
        System.out.println();
        System.out.println("ACTIVITY 1 FINISHED");
        System.out.println();
        System.out.println("ACTIVITY 2 - ITERATION");
        System.out.println("Factorial of 5: " + Iteration.factorial(5));
        System.out.println("Array sum: " + Iteration.arraySum(numbers));
        System.out.println("Array maximum: " + Iteration.arrayMaximum(numbers));
        System.out.println();
        System.out.println("ACTIVITY 2 - RECURSION");
        System.out.println("Factorial of 5: " + Recursion.factorial(5));
        System.out.println("Array sum: " + Recursion.arraySum(numbers, 0));
        System.out.println("Array maximum: " + Recursion.arrayMaximum(numbers, 0));
    }
}
