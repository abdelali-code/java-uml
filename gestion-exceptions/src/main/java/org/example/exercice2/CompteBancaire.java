package org.example.exercice2;

class CompteBancaire {
    protected String numeroCompte;
    protected double solde;
    protected String nomTitulaire;

    public CompteBancaire(String numeroCompte, double soldeInitial, String nomTitulaire) {
        this.numeroCompte = numeroCompte;
        this.solde = soldeInitial;
        this.nomTitulaire = nomTitulaire;
    }

    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println("Dépôt de " + montant + " € effectué sur le compte " + numeroCompte);
        }
    }

    public void retirer(double montant) throws FondsInsuffisantsException {
        if (montant <= 0) {
            System.out.println("Le montant doit être positif");
            return;
        }

        if (montant > solde) {
            throw new FondsInsuffisantsException("Fonds insuffisants pour retirer " + montant +
                    " €. Solde actuel: " + solde + " €");
        }

        solde -= montant;
        System.out.println("Retrait de " + montant + " € effectué sur le compte " + numeroCompte);
    }

    public void afficherSolde() {
        System.out.println("Compte: " + numeroCompte + " | Titulaire: " + nomTitulaire +
                " | Solde: " + solde + " €");
    }

    public void transferer(CompteBancaire destinataire, double montant)
            throws FondsInsuffisantsException, CompteInexistantException {

        if (destinataire == null) {
            throw new CompteInexistantException("Le compte destinataire n'existe pas");
        }

        if (montant <= 0) {
            System.out.println("Le montant du transfert doit être positif");
            return;
        }

        if (montant > solde) {
            throw new FondsInsuffisantsException("Fonds insuffisants pour transférer " + montant +
                    " €. Solde actuel: " + solde + " €");
        }

        this.retirer(montant);
        destinataire.deposer(montant);
        System.out.println("Transfert de " + montant + " € effectué du compte " +
                this.numeroCompte + " vers le compte " + destinataire.numeroCompte);
    }

    public String getNumeroCompte() { return numeroCompte; }
    public double getSolde() { return solde; }
    public String getNomTitulaire() { return nomTitulaire; }
}
