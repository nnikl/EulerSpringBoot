package com.nnikl.EulerSpringBoot;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class Euler10 {

    @Autowired
    private MathHelper primeNumbersLimitInitializer;

    /**
     * Calculates the sum of all prime numbers below the given limit.
     *
     * @param limit the upper bound (exclusive) for prime numbers
     * @return the total sum of all prime numbers below the specified limit
     */
    public long calculateSum(long limit) {
        long sumEuler10 = 0L;
        List<Long> primes = primeNumbersLimitInitializer.getPrimesUpTo(limit);
        for (long prime : primes) {
            sumEuler10 += prime;
        }
        return sumEuler10;
    }
}

