package com.skillbox.fibonacci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class FibonacciCalculatorTest {

    private FibonacciCalculator fibonacciCalculator;

   @BeforeEach
    public void setUp() {
        fibonacciCalculator = new FibonacciCalculator();
    }

    @ParameterizedTest
    @ValueSource(ints = {20, 13, 8})
    @DisplayName("Test get Fibonacci number")
    public void shouldReturnFibonacciNumberWhenValidInput(int index) {
        System.out.println(fibonacciCalculator.getFibonacciNumber(index));
        Assertions.assertEquals(21, fibonacciCalculator.getFibonacciNumber(8));
    }

    @Test
    @DisplayName("Test Fibonacci less one")
    public void shouldHandleInputLessThanOne() {
        int index = 0;
        assertThrows(IllegalArgumentException.class, () -> {
            fibonacciCalculator.getFibonacciNumber(index);
        },"Порядковый номер меньше 1");
       }

    @ParameterizedTest
    @ValueSource(ints = {1 ,2})
    @DisplayName("If Fibonacci number = 1, 2")
    public  void shouldReturnCorrectFibonacciResult(int index) {
           System.out.println(fibonacciCalculator.getFibonacciNumber(index));
           int expected = (index == 1 || index == 2) ? 1 : -1;
           Assertions.assertEquals(expected, fibonacciCalculator.getFibonacciNumber(index));
    }

}
