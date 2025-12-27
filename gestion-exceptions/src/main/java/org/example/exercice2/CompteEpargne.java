package org.example.exercice2;

class CompteEpargne extends CompteBancaire {
    private double tauxInteret;

    public CompteEpargne(String numeroCompte, double soldeInitial, String nomTitulaire, double tauxInteret) {
        super(numeroCompte, soldeInitial, nomTitulaire);
        this.tauxInteret = tauxInteret;
    }

    public void calculerInterets() {
        double interets = solde * tauxInteret / 100;
        solde += interets;
        System.out.println("Intérêts de " + interets + " € ajoutés au compte épargne " + numeroCompte);
    }

    @Override
    public void afficherSolde() {
        super.afficherSolde();
        System.out.println("   Taux d'intérêt: " + tauxInteret + "%");
    }
}
