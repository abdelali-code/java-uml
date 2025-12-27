package org.example.exercice1;

class EntierNaturel {
    private int val;

    public EntierNaturel(int val) throws NombreNegatifException {
        if (val < 0) {
            throw new NombreNegatifException("Erreur: Valeur négative dans le constructeur: " + val, val);
        }
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) throws NombreNegatifException {
        if (val < 0) {
            throw new NombreNegatifException("Erreur: Valeur négative dans setVal: " + val, val);
        }
        this.val = val;
    }

    public void decrementer() throws NombreNegatifException {
        if (val - 1 < 0) {
            throw new NombreNegatifException("Erreur: Décrémentation impossible (devient négatif), valeur actuelle: " + val, val);
        }
        val--;
    }
}
