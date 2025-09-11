package com.nnikl.EulerSpringBoot;

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

    public static final long LIMIT = 2_000_000L;
    private final MathHelper setLimitPrimeNumbers;

    /**
     * sets a Limit for the primes
     */
    public long solveEuler7(int nthPrimeNumberIndex) {
        List<Long> primes = setLimitPrimeNumbers.getPrimesUpTo(LIMIT);
        return primes.get(nthPrimeNumberIndex);
    }
}