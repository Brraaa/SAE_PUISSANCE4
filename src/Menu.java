import java.util.Scanner;

public class Menu {

    public static void afficherMenu(){

        Scanner scanner = new Scanner(System.in);

        int COLONNES = 7;
        int LIGNES = 6;

        char[][] plateau = new char[LIGNES][COLONNES];

        int choix;

        do{
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Afficher les règles du jeu");
            System.out.println("2. Jouer à Puissance 4");
            System.out.println("3. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    afficherRegles();
                    break;
                case 2:
                    JvJ.initialiserPlateau(plateau);
                    JvJ.jouer(plateau);
                    break;
                case 3:
                    System.out.println("Merci d'avoir joué ! À bientôt !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }while (choix != 3);


    }

    public static void afficherRegles() {
        System.out.println("\n=== Règles du jeu ===");
        System.out.println("1. Alignez 4 jetons de votre couleur (horizontalement, verticalement ou en diagonale).");
        System.out.println("2. Chaque joueur dépose un jeton à tour de rôle dans une colonne.");
        System.out.println("3. Le jeu se termine lorsqu'un joueur aligne 4 jetons ou si la grille est pleine.");
        System.out.println("Bonne chance et amusez-vous bien !");
    }





}
