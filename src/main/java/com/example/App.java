package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
 * Classe de calcul simple pour démonstration
 */
/**
 * Application principale du mini projet
 */
public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Application démarrée");
        
        String message = greet("Monde");
        System.out.println(message);
        
        Calculator calc = new Calculator();
        int result = calc.add(10, 5);
        logger.info("Résultat de 10 + 5 = {}", result);
        
        logger.info("Application terminée");
    }

    public static String greet(String name) {
        return "Bonjour, " + name + "!";
    }
}
