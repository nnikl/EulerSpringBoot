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
public class HomeController {

    @Autowired
    private PrimeNumbers primeNumbers;

    /**
     * Returns a simple 404 response when accessing the root URL.
     */
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> index() {
        return ResponseEntity.status(404).body("not found");
    }

    /**
     * Returns the nth prime number based on the URL input.
     *
     * Example: /primeNumbers/10001 → returns the 10001st prime number
     *
     * @param n Index of the desired prime number
     * @return ResponseEntity with the nth prime number
     */
    @GetMapping(value = "/primeNumbers/{n}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getNthPrime(@PathVariable("n") int n) {
        // Safety check for valid input range
        if (n <= 0 || n > 100_000) {
            return ResponseEntity.badRequest().body("Invalid index: " + n);
        }

        // Estimate upper bound for prime search
        long upperBound = n * 20L;
        var primes = primeNumbers.getPrimesUpTo(upperBound);

        if (primes.size() < n) {
            return ResponseEntity.status(500).body("Not enough primes found.");
        }

        long result = primes.get(n - 1); // List index starts at 0
        return ResponseEntity.ok("The " + n + "th prime number is: " + result);
    }
}