public class Main {
    public static void main(String[] args) {
        Adherent adherent = new Adherent("adherent", "adhrent pre", "test@gmail.com", "066666666", 30, 1);
        Auteur auteur = new Auteur("hugo", "victor", "test@gmail.com", "066666666", 30, 1);
        Livre livre = new Livre(123,  "the light we cannot see", auteur);
        System.out.println(adherent);
        System.out.println(livre);
    }
}