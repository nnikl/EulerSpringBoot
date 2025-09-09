package com.nnikl.EulerSpringBoot;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor

public class SumSquare {

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
