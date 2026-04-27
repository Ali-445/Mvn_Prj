# Mini Projet Java avec Maven

Un mini projet Maven simple pour démontrer la structure de base d'une application Java.

## Structure du Projet

```
Maven_Project/
├── pom.xml                              # Configuration Maven
├── src/
│   ├── main/
│   │   └── java/com/example/
│   │       ├── App.java                 # Classe principale
│   │       └── Calculator.java          # Classe utilitaire
│   └── test/
│       └── java/com/example/
│           └── CalculatorTest.java      # Tests unitaires
└── README.md                            # Ce fichier
```

## Dépendances

- **JUnit 4.13.2** - Framework de test unitaire
- **SLF4J 1.7.36** - Interface de logging
- **Logback 1.2.11** - Implémentation du logging

## Installation et Compilation

### Prérequis
- Java 11 ou supérieur
- Maven 3.6 ou supérieur

### Compiler le projet
```bash
mvn clean compile
```

### Exécuter les tests
```bash
mvn test
```

### Empaqueter le projet
```bash
mvn package
```

### Exécuter l'application
Après avoir créé le JAR:
```bash
java -jar target/mini-app-1.0-SNAPSHOT.jar
```

Ou directement:
```bash
mvn exec:java -Dexec.mainClass="com.example.App"
```

## Contenu du Projet

### App.java
Classe principale qui:
- Utilise le logging SLF4J
- Affiche un message de bienvenue
- Utilise la classe Calculator

### Calculator.java
Classe utilitaire proposant:
- `add(int, int)` - Addition
- `subtract(int, int)` - Soustraction
- `multiply(int, int)` - Multiplication
- `divide(int, int)` - Division

### CalculatorTest.java
Tests unitaires pour la classe Calculator avec:
- Tests des opérations basiques
- Test de gestion des exceptions (division par zéro)

## Configuration Maven

Le `pom.xml` inclut:
- Configuration du compilateur Java (version 11)
- Dépendances du projet
- Plugin JAR pour créer un fichier exécutable

## Notes

Ce projet peut être utilisé comme point de départ pour créer une application Java plus complexe. N'hésitez pas à ajouter de nouvelles dépendances ou modules selon vos besoins.
