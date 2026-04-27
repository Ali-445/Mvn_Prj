package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    
    private Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        int result = calculator.add(5, 3);
        assertEquals(8, result);
    }

    @Test
    public void testSubtract() {
        int result = calculator.subtract(10, 4);
        assertEquals(6, result);
    }

    @Test
    public void testMultiply() {
        int result = calculator.multiply(6, 7);
        assertEquals(42, result);
    }

    @Test
    public void testDivide() {
        double result = calculator.divide(10, 2);
        assertEquals(5.0, result, 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        calculator.divide(10, 0);
    }
}
