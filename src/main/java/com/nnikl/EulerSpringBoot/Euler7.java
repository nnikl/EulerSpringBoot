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

    private final PrimeNumbers primeNumbers;

    /**
     * Executes the logic after the application starts.
     */
    @PostConstruct
    public long solveEuler7() {
        List<Long> primes = primeNumbers.getPrimesUpTo(200_000L);
        return primes.get(10000);
    }
}