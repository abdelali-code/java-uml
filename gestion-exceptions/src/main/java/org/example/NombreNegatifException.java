package org.example;

class NombreNegatifException extends Exception {
    private int valeurErronee;

    public NombreNegatifException(String message, int valeur) {
        super(message);
        this.valeurErronee = valeur;
    }

    public int getValeurErronee() {
        return valeurErronee;
    }
}