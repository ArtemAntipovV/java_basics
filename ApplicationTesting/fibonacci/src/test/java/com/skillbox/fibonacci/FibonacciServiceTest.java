package com.skillbox.fibonacci;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class FibonacciServiceTest {

     private FibonacciService service;

     @Mock
     private  FibonacciCalculator calculator;
     @Mock
     private FibonacciRepository repository;

    @BeforeEach
     public void setUp() {
        service = new FibonacciService(repository, calculator);
     }

     @ParameterizedTest
     @CsvSource(value = {"1,1", "1,2", "3,2", "4,3", "10,55"}, ignoreLeadingAndTrailingWhitespace = true)
     @DisplayName("Test get number from")
     public void testFibonacciServicetoBd(int index, int value) {
         when(repository.findByIndex(index)).thenReturn(Optional.of(new FibonacciNumber(index, value)));

         FibonacciNumber result = service.fibonacciNumber(index);
         assertEquals(value, result.getValue());

         verify(repository, times(1)).findByIndex(index);
         verify(repository, never()).save(any(FibonacciNumber.class));

     }


    @ParameterizedTest
    @CsvSource(value = {"1,1", "1,2", "3,2", "4,3", "10,55"}, ignoreLeadingAndTrailingWhitespace = true)
    @DisplayName("Test save number in database")
    public void givenIndex_whenSaveToDatabase_thenCorrectFibonacciNumberSaved(int index, int value) {
        when(repository.findByIndex(index)).thenReturn(Optional.empty());
        when(calculator.getFibonacciNumber(index)).thenReturn(value);

        FibonacciNumber result = service.fibonacciNumber(index);
        assertEquals(value, result.getValue());

        verify(repository, times(1)).findByIndex(index);
        verify(calculator, times(1)).getFibonacciNumber(index);
        verify(repository, times(1)).save(result);
    }

    @Test
    @DisplayName("Test Fibonacci less one")
    public void  givenNegativeIndex_whenFibonacciNumber_thenThrowException() {
        int index = -1;
        assertThrows(IllegalArgumentException.class, () -> {
            service.fibonacciNumber(index);
        },"Порядковый номер меньше 1");
    }
}
