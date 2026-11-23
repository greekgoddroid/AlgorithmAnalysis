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
    }
}
