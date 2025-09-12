package com.nnikl.EulerSpringBoot;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Euler8 {

    private final String digitString = loadNumberFromFile("/euler8_number.txt");

    /**
     * Calculates the largest product of 13 consecutive digits in the given number string.
     * <p>
     * The method iterates through each possible 13-digit window in `digitString`,
     * multiplies all digits in that window to compute the product, and keeps track
     * of the largest product found.
     *
     * @return the largest product of 13 consecutive digits
     */
    public long productEuler8() {
        long biggestProduct = 0L;
        long product = 1L;
        char[] charArray = digitString.toCharArray();
        for (int i = 0; i < digitString.length() - 13; i++) {
            for (int j = 0; j < 13; j++) {
                char charDigit = charArray[i + j];   // holt das i-te Zeichen
                int digit = charDigit - '0';
                product *= digit;
            }
            if (product > biggestProduct) {
                biggestProduct = product;
            }
            product = 1L;
        }
        return biggestProduct;
    }

    /**
     * Loads the numeric content from the resource file <code>euler_number.txt</code>.
     *
     * @return a string containing the entire number from the resource file
     * @throws RuntimeException if the resource cannot be found or read
     */
    private String loadNumberFromFile(String filePath) {

        // Try-with-resources block: ensures that resources (InputStream, BufferedReader)
        // are automatically closed after usage, even if an exception occurs.
        try (
                // Get the resource file as an InputStream.
                // Objects.requireNonNull(...) ensures that if the resource is not found,
                // a NullPointerException is thrown immediately (instead of silently failing).
                InputStream is = Objects.requireNonNull(Euler8.class.getResourceAsStream(filePath));

                // Wrap the InputStream with an InputStreamReader to convert raw bytes
                // into characters, explicitly using UTF-8 as the character encoding.
                InputStreamReader inputStreamReader = new InputStreamReader(is, StandardCharsets.UTF_8);

                // Wrap the InputStreamReader with a BufferedReader for efficient reading
                // of text data (it can read whole lines at a time instead of character by character).
                BufferedReader reader = new BufferedReader(inputStreamReader)) {

            return reader.lines().collect(Collectors.joining("")); // Read all lines from the file as a stream of strings

        } catch (IOException e) {
            // If there is an I/O error (e.g., file can’t be read),
            // wrap it into a RuntimeException and stop program execution.
            throw new RuntimeException("Failed to read the resource file.", e);
        }
    }
}