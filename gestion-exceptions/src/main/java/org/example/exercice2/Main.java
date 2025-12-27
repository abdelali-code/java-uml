package org.example.exercice2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<CompteBancaire> comptes = new ArrayList<>();

        System.out.println("=== Création des comptes ===");

        try {
            CompteCourant cc1 = new CompteCourant("CC001", 1500, "Alice Dupont", 1000);
            CompteEpargne ce1 = new CompteEpargne("CE001", 5000, "Alice Dupont", 2.5);
            CompteCourant cc2 = new CompteCourant("CC002", 2000, "Bob Martin", 500);
            CompteEpargne ce2 = new CompteEpargne("CE002", 10000, "Bob Martin", 3.0);

            // Ajout des comptes à la liste
            comptes.add(cc1);
            comptes.add(ce1);
            comptes.add(cc2);
            comptes.add(ce2);

            System.out.println("Comptes créés avec succès.");
        } catch (Exception e) {
            System.out.println("Erreur lors de la création des comptes: " + e.getMessage());
        }

        System.out.println("\n=== Affichage de tous les comptes ===");
        for (CompteBancaire compte : comptes) {
            compte.afficherSolde();
        }

        System.out.println("\n=== Opérations de dépôt ===");
        try {
            comptes.get(0).deposer(500);
            comptes.get(2).deposer(300);
        } catch (Exception e) {
            System.out.println("Erreur lors du dépôt: " + e.getMessage());
        }

        System.out.println("\n=== Opérations de retrait ===");
        try {
            comptes.get(0).retirer(200);
            comptes.get(0).retirer(2000);
            comptes.get(1).retirer(6000);
        } catch (FondsInsuffisantsException e) {
            System.out.println("Erreur de retrait: " + e.getMessage());
        }

        System.out.println("\n=== Transfert entre comptes ===");
        try {
            comptes.get(0).transferer(comptes.get(1), 300);
            comptes.get(1).transferer(comptes.get(0), 10000);

        } catch (FondsInsuffisantsException e) {
            System.out.println("Erreur de transfert (fonds insuffisants): " + e.getMessage());
        } catch (CompteInexistantException e) {
            System.out.println("Erreur de transfert (compte inexistant): " + e.getMessage());
        }

        System.out.println("\n=== Transfert vers compte inexistant ===");
        try {
            comptes.get(0).transferer(null, 100);
        } catch (FondsInsuffisantsException | CompteInexistantException e) {
            System.out.println("Erreur de transfert: " + e.getMessage());
        }

        System.out.println("\n=== Calcul des intérêts pour les comptes épargne ===");
        for (CompteBancaire compte : comptes) {
            if (compte instanceof CompteEpargne) {
                ((CompteEpargne) compte).calculerInterets();
            }
        }

        System.out.println("\n=== Suppression d'un compte ===");
        if (!comptes.isEmpty()) {
            CompteBancaire compteSupprime = comptes.remove(2);
            System.out.println("Compte " + compteSupprime.getNumeroCompte() + " supprimé avec succès.");
            System.out.println("Nombre de comptes restants: " + comptes.size());
        }

        System.out.println("\n=== Affichage final des soldes ===");
        for (CompteBancaire compte : comptes) {
            compte.afficherSolde();
        }

        System.out.println("\n=== Test de fonctionnalités spécifiques ===");
        for (CompteBancaire compte : comptes) {
            if (compte instanceof CompteCourant) {
                System.out.print("Compte courant " + compte.getNumeroCompte() + ": ");
                ((CompteCourant) compte).afficherDecouvert();
            }
        }

        try {
            CompteCourant testDecouvert = new CompteCourant("TEST001", 100, "Test Decouvert", 500);
            testDecouvert.afficherSolde();
            testDecouvert.retirer(300);
            testDecouvert.afficherSolde();
            testDecouvert.retirer(400);
        } catch (FondsInsuffisantsException e) {
            System.out.println("Test découvert - Erreur: " + e.getMessage());
        }
    }
}
