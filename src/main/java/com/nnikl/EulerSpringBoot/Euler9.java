package com.nnikl.EulerSpringBoot;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class Euler9 {


    private static final int tripletSum = 1000;

    /**
     * Finds a Pythagorean triplet (a, b, c) such that:
     * a + b + c = 1000 and a² + b² = c²
     *
     * @return an array containing the triplet [a, b, c], or null if not found
     */
    public int[] findPythagoreanTripletSum() {
        for (int a = 1; a < tripletSum; a++) {
            for (int b = a + 1; b < tripletSum; b++) {
                int c = tripletSum - a - b;
                if (a * a + b * b == c * c) {
                    int[] tripel = new int[] {a, b, c};
                    return tripel;
                }
            }
        }
        return null;
    }

    /**
     * Calculates the product of the Pythagorean triplet.
     * If the triplet hasn't been found yet, it will attempt to find it first.
     *
     * @return the product a * b * c, or -1 if no triplet is found
     */
    public int tripletProduct() {
        int[] tripel = findPythagoreanTripletSum();
        if (tripel == null) {
            return -1;
        }
        return tripel[0] * tripel[1] * tripel[2];
    }
}
