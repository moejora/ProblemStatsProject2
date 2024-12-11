package com.demo;

public class StatsLibrary2Tester {

    public static void main(String[] args) {
        StatsLibrary2 statsLibrary2 = new StatsLibrary2();

        //Negative Binomial Probability Tester
        int yBinomial = 8; 
        int r = 4;
        double p = 0.5; 
        double negativeBinomialResult = statsLibrary2.computeNegativeBinomialProbability(yBinomial, r, p);
        System.out.println("3.9: Computed Negative Binomial Probability:");
        System.out.println(String.format("P(Y = %d | r = %d, p = %.2f) = %.5f", yBinomial, r, p, negativeBinomialResult));

        //Hypergeometric Probability Tester
        int yHypergeometric = 3;
        int rHypergeometric = 7;
        int N = 20;
        int n = 10;
        double hypergeometricResult = statsLibrary2.computeHypergeometricProbability(yHypergeometric, rHypergeometric, N, n);
        System.out.println("3.10: Computed Hypergeometric Probability:");
        System.out.println(String.format("P(Y = %d | r = %d, N = %d, n = %d) = %.5f", yHypergeometric, rHypergeometric, N, n, hypergeometricResult));

        //Poisson Probability Tester
        int yPoisson = 2; 
        double lambda = 3.5; 
        double poissonResult = statsLibrary2.computePoissonProbability(yPoisson, lambda);
        System.out.println("3.11: Computed Poisson Probability:");
        System.out.println(String.format("P(Y = %d | Lambda = %.1f) = %.5f", yPoisson, lambda, poissonResult));
    }
}
