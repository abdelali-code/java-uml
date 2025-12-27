package org.example;

public class Livre {
    private  int ISBN;
    private String titre;
    private Auteur auteur;

    public Livre(int ISBN, String titre, Auteur auteur) {
        this.ISBN = ISBN;
        this.titre = titre;
        this.auteur = auteur;
    }

    public int getISBN() {
        return ISBN;
    }

    public String getTitre() {
        return titre;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "ISBN=" + ISBN +
                ", titre='" + titre + '\'' +
                ", auteur=" + auteur.toString() +
                '}';
    }
}
