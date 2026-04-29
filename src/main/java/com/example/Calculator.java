package com.example;

/**
 * Classe utilitaire pour effectuer des calculs simples
 * 
 * 
 */
public class Calculator {
    
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division par zéro non autorisée");
        }
        return (double) a / b;
    }
}
