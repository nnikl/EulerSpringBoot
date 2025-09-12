package com.nnikl.EulerSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Controller for the main endpoints of the application.
 */
@Controller
public class EulerController {

    @Autowired
    private Euler7 euler7;

    @Autowired
    private Euler8 euler8;

    @Autowired
    private Euler9 euler9;

    @Autowired
    private Euler10 euler10;


    /**
     * Returns a simple 404 response when accessing the root URL.
     */
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> index() {
        return ResponseEntity.status(404).body("not found");
    }

    /**
     * Returns the nth prime number based on the URL input.
     * The first PrimeNumber has an index of 1.
     *
     * @param index Index of the desired prime number
     * @return ResponseEntity with the nth prime number
     */
    @GetMapping(value = "/primeNumbersCounter/{index}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> getNthPrime(@PathVariable("index") int index) {
        int correctedIndex = index - 1;
        long result = euler7.solveEuler7(correctedIndex);
        return ResponseEntity.status(200).body(result);
    }

    /**
     * REST endpoint to calculate the largest product of 13 consecutive digits
     * in the 1000-digit number (Project Euler Problem 8).
     *
     * @return HTTP 200 response containing the largest product as JSON.
     */
    @GetMapping(value = "/Euler8/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> Euler8() {
        long getResultEuler9 = euler8.productEuler8();
        return ResponseEntity.status(200).body(getResultEuler9);
    }


    /**
     * REST endpoint to calculate the product of the Pythagorean triplet
     * where a + b + c = 1000 and a² + b² = c².
     *
     * @return HTTP 200 response containing the product as JSON.
     */
    @GetMapping(value = "/Euler9/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> Euler9() {
        int getResultEuler9 = euler9.tripletProduct();
        return ResponseEntity.status(200).body(getResultEuler9);
    }

    /**
     * REST endpoint that returns the sum of all prime numbers below the given limit.
     * <p>
     * The limit is provided as a path variable "index". Internally, the index is
     * adjusted by subtracting 1 before calculating the sum.
     *
     * @param index the upper bound for prime numbers (path variable)
     * @return HTTP 200 with the sum of all primes below the adjusted limit as JSON
     */
    @GetMapping(value = "/sumPrimeNumAddition/{index}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> sumOfPrimeNumberAdditionBelow(@PathVariable("index") int index) {
        int correctedIndex = index - 1;
        long getResultEuler10 = euler10.calculateSum(correctedIndex);
        return ResponseEntity.status(200).body(getResultEuler10);
    }
}

