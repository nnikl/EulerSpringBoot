package com.nnikl.EulerSpringBoot;

import org.springframework.stereotype.Component;
import java.util.LinkedList;
import java.util.List;

/**
 * Utility class for generating and checking prime numbers.
 */
@Component
public class PrimeNumbers {

    /**
     * Generates a list of prime numbers up to a given limit.
     *
     * @param limit the upper bound for prime number generation
     * @return a list of prime numbers up to the limit
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
     * i*i checks only up to necessary limit for prime testing
     * @param number the number to check
     * @return true if the number is prime, false otherwise
     */
    public boolean isPrime(long number) {
        if (number < 2) return false;
        for (long i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}