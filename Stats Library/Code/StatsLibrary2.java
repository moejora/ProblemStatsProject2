
package com.demo;

import java.math.BigInteger;

public class StatsLibrary2 {

    //Calculate factorial of a number
    private static BigInteger factorial(int num) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= num; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    //Calculate combinations (n choose r)
    private static BigInteger binomialCoefficient(int n, int r) {
        return factorial(n).divide(factorial(r).multiply(factorial(n - r)));
    }

    //Compute Negative Binomial Probability
    public static double computeNegativeBinomialProbability(int y, int r, double p) {
        if (y < r || p < 0 || p > 1) {
            throw new IllegalArgumentException("Be sure that y >= r and 0 <= p <= 1.");
        }
        double q = 1 - p;
        BigInteger combinations = binomialCoefficient(y - 1, r - 1);
        return combinations.doubleValue() * Math.pow(p, r) * Math.pow(q, y - r);
    }

    //Compute Hypergeometric Probability
    public static double computeHypergeometricProbability(int y, int r, int N, int n) {
        if (y < 0 || y > r || n - y > N - r) {
            throw new IllegalArgumentException("Invalid inputs: Be sure that y <= r and n-y <= N-r.");
        }
        BigInteger top1 = binomialCoefficient(r, y);
        BigInteger top2 = binomialCoefficient(N - r, n - y);
        BigInteger bottom = binomialCoefficient(N, n);
        return top1.multiply(top2).doubleValue() / bottom.doubleValue();
    }

    //Compute Poisson Probability
    public static double computePoissonProbability(int y, double lambda) {
        if (lambda <= 0) {
            throw new IllegalArgumentException("Lambda has to be > 0.");
        }
        if (y < 0) {
            throw new IllegalArgumentException("Y can not be a non-negative integer.");
        }
        double numerator = Math.pow(lambda, y) * Math.exp(-lambda);
        double denominator = factorial(y).doubleValue();
        return numerator / denominator;
    }
}
