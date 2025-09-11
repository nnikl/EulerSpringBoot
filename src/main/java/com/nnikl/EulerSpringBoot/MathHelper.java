package com.nnikl.EulerSpringBoot;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * Utility class for generating and checking prime numbers.
 */
@Component
@RequiredArgsConstructor
public class MathHelper {

    /**
     * Generates a list of prime numbers up to a given limit.
     *
     * @param limit the upper bound for prime number generation.
     * @return a list of prime numbers up to the limit.
     */
    public List<Long> getPrimesUpTo(long limit) {
        List<Long> primes = new LinkedList<>();
        for (long i = 2; i <= limit; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    /**
     * Checks whether a number is prime.
     * i*i checks only up to necessary limit for prime testing.
     *
     * @param number the number to check.
     * @return true if the number is prime, false otherwise.
     */
    public boolean isPrime(long number) {
        if (number < 2) return false;
        for (long i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public int sumSquareWithoutBrackets() {
        int sumSquareCalculate = 0;
        for (int x = 1; x <= 100; x++) {
            sumSquareCalculate += x * x;
        }
        return sumSquareCalculate;
    }

    public int sumSquaresInBrackets() {
        int sumSquareCalculateNumbers = 0;
        for (int x = 1; x <= 100; x++) {
            sumSquareCalculateNumbers += x;
        }
        return sumSquareCalculateNumbers * sumSquareCalculateNumbers;
    }

}