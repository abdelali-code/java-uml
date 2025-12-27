public class TestVehicules {

    public static void main(String[] args) {
        Voiture voiture = new Voiture("Toyota Corolla", 25000.50, "Corolla", 2023);
        Moto moto = new Moto("Yamaha MT-07", 8500.75, "Yamaha", 73.4);
        Avion avion = new Avion("Boeing 747", 150000000.00, "Air France", 988);

        Vehicule[] vehicules = {voiture, moto, avion};

        for (Vehicule vehicule : vehicules) {
            System.out.println("\n=== " + vehicule.getClass().getSimpleName() + " ===");
            vehicule.emettreSon();
            vehicule.afficherInformations();
        }

        System.out.println("\n=== Test polymorphique ===");
        Vehicule vehiculeGenerique = new Voiture("Renault Clio", 22000.00, "Clio", 2024);
        vehiculeGenerique.emettreSon();
        vehiculeGenerique.afficherInformations();
    }
}
