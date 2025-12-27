package org.example.exercice2;

class CompteCourant extends CompteBancaire {
    private double decouvertAutorise;

    public CompteCourant(String numeroCompte, double soldeInitial, String nomTitulaire, double decouvertAutorise) {
        super(numeroCompte, soldeInitial, nomTitulaire);
        this.decouvertAutorise = decouvertAutorise;
    }

    @Override
    public void retirer(double montant) throws FondsInsuffisantsException {
        if (montant <= 0) {
            System.out.println("Le montant doit être positif");
            return;
        }

        if (solde - montant < -decouvertAutorise) {
            throw new FondsInsuffisantsException("Retrait impossible. Vous dépassez le découvert autorisé de " +
                    decouvertAutorise + " €. Solde minimal possible: " + (-decouvertAutorise) + " €");
        }

        solde -= montant;
        System.out.println("Retrait de " + montant + " € effectué sur le compte courant " + numeroCompte);
    }

    public void afficherDecouvert() {
        System.out.println("Découvert autorisé: " + decouvertAutorise + " €");
    }
}
