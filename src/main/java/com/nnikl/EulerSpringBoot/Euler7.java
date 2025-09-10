package com.nnikl.EulerSpringBoot;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Solves Project Euler Problem 7:
 * Find the 10001st prime number.
 */
@Component
@RequiredArgsConstructor
public class Euler7 {

    public static final long LIMIT = 200_000L;
    private final PrimeNumbers primeNumbers;

    /**
     * Executes the logic after the application starts.
     */
    public long solveEuler7(int nthPrimeNumberIndex) {
        List<Long> primes = primeNumbers.getPrimesUpTo(LIMIT);
        return primes.get(nthPrimeNumberIndex);
    }
}