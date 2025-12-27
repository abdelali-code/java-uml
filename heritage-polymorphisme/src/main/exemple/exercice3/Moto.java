class Moto extends Vehicule {
    private String marque;
    private double puissance;

    public Moto(String nom, double prix, String marque, double puissance) {
        super(nom, prix);
        this.marque = marque;
        this.puissance = puissance;
    }

    @Override
    public void emettreSon() {
        System.out.println("La moto rugit.");
    }

    @Override
    public void afficherInformations() {
        super.afficherInformations();
        System.out.println("Marque: " + marque);
        System.out.println("Puissance: " + puissance + " CV");
        System.out.println("-------------------------");
    }
}
