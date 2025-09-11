package com.nnikl.EulerSpringBoot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

    @ExtendWith(MockitoExtension.class)
    public class Euler8Test {

        @InjectMocks
        private Euler8 euler8;

        @Test
        void checkHighestSumOf13DigitsInARow() {
            long result = euler8.productEuler8();
            assertEquals(23514624000L , result);
        }
    }
