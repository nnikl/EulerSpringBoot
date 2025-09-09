package com.nnikl.EulerSpringBoot;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Euler6 {

    private final SumSquare sumSquare;


    /**
     * sumSquareWithoutBrackets() at first the SumSquare of each number and then the Addition to each
     * sumSquaresInBrackets() the result gets multiplicated by itself
     *
     * @return returns difference between sumSquareInBrackets and sumSquareWithoutBrackets
     */
    public int sumSquaresResult() {
        return sumSquare.sumSquaresInBrackets() - sumSquare.sumSquareWithoutBrackets();
    }

}


//ApplicationContext context = StringApplication.run(EulerSpringBootApplication.class, args);