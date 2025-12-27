package org.example;

public class Main {
    public static void main(String[] args) {
            System.out.println("=== Test 1: Construction avec valeur positive ===");
            try {
                EntierNaturel entier1 = new EntierNaturel(10);
                System.out.println("Valeur initiale: " + entier1.getVal());
            } catch (NombreNegatifException e) {
                System.out.println("Exception: " + e.getMessage());
                System.out.println("Valeur erronée: " + e.getValeurErronee());
            }

            System.out.println("\n=== Test 2: Construction avec valeur négative ===");
            try {
                EntierNaturel entier2 = new EntierNaturel(-5);
                System.out.println("Valeur: " + entier2.getVal());
            } catch (NombreNegatifException e) {
                System.out.println("Exception: " + e.getMessage());
                System.out.println("Valeur erronée: " + e.getValeurErronee());
            }

            System.out.println("\n=== Test 3: Méthode setVal avec valeur négative ===");
            try {
                EntierNaturel entier3 = new EntierNaturel(8);
                System.out.println("Valeur avant setVal: " + entier3.getVal());
                entier3.setVal(-3);
            } catch (NombreNegatifException e) {
                System.out.println("Exception: " + e.getMessage());
                System.out.println("Valeur erronée: " + e.getValeurErronee());
            }

            System.out.println("\n=== Test 4: Décrémentation normale ===");
            try {
                EntierNaturel entier4 = new EntierNaturel(5);
                System.out.println("Valeur avant décrémentation: " + entier4.getVal());
                entier4.decrementer();
                System.out.println("Valeur après décrémentation: " + entier4.getVal());
            } catch (NombreNegatifException e) {
                System.out.println("Exception: " + e.getMessage());
                System.out.println("Valeur erronée: " + e.getValeurErronee());
            }

            System.out.println("\n=== Test 5: Décrémentation impossible (valeur 0) ===");
            try {
                EntierNaturel entier5 = new EntierNaturel(0);
                System.out.println("Valeur avant décrémentation: " + entier5.getVal());
                entier5.decrementer();
                System.out.println("Valeur après décrémentation: " + entier5.getVal());
            } catch (NombreNegatifException e) {
                System.out.println("Exception: " + e.getMessage());
                System.out.println("Valeur erronée: " + e.getValeurErronee());
            }

            System.out.println("\n=== Test 6: Scénario complet ===");
            try {
                EntierNaturel entier = new EntierNaturel(3);
                System.out.println("1. Entier créé avec valeur: " + entier.getVal());

                entier.decrementer();
                System.out.println("2. Après décrémentation: " + entier.getVal());

                entier.setVal(7);
                System.out.println("3. Après setVal(7): " + entier.getVal());

                for (int i = 0; i < 10; i++) {
                    entier.decrementer();
                    System.out.println("   Décrémentation " + (i+1) + ": " + entier.getVal());
                }
            } catch (NombreNegatifException e) {
                System.out.println("Exception capturée: " + e.getMessage());
                System.out.println("Valeur erronée: " + e.getValeurErronee());
            }

    }
}