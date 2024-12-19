import java.util.Scanner;

public class JvJ {
   /* public static void main(String[] args) {
        int COLONNES = 7;
        int LIGNES = 6;
        char[][] plateau = new char[LIGNES][COLONNES];
        initialiserPlateau(plateau);  // Initialiser le plateau
        jouer(plateau);  // Lancer la partie
    }*/

    public static final String RED = "\u001B[38;5;88m";

    public static void initialiserPlateau(char[][] plateau) {
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau[i].length; j++) {
                plateau[i][j] = '.'; // Remplit tout le plateau avec des points
            }
        }
    }

    public static void afficherPlateau(char[][] plateau) {
        System.out.println("\n=== Plateau ===");
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau[i].length; j++) {
                System.out.print(" " + plateau[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean insererPion(char[][] plateau, int C, char  pion) {
        if (C < 0 || C >= plateau[0].length) {
            System.out.println("Colonne invalide !");
            return false;
        }
        for (int i = plateau.length - 1; i >= 0; i--) {
            if (plateau[i][C] == '.') {
                plateau[i][C] = pion;
                return true;
            }
        }
        System.out.println("La colonne est pleine !");
        return false;
    }

    public static boolean verifierAlignementVertical(char[][] plateau, char pion) {
        for (int j = 0; j < plateau[0].length; j++) { // Parcourir les colonnes
            int compteur = 0;
            for (int i = 0; i < plateau.length; i++) { // Parcourir les lignes
                if (plateau[i][j] == pion) {
                    compteur++;
                    if (compteur == 4) return true;
                } else {
                    compteur = 0;
                }
            }
        }
        return false;
    }

    public static boolean verifierAlignementHorizontal(char[][] plateau, char pion) {
        for (int i = 0; i < plateau.length; i++) { // Parcourir les lignes
            int compteur = 0;
            for (int j = 0; j < plateau[i].length; j++) { // Parcourir les colonnes
                if (plateau[i][j] == pion) {
                    compteur++;
                    if (compteur == 4) return true;
                } else {
                    compteur = 0;
                }
            }
        }
        return false;
    }

    public static boolean verifierAlignementDiagonalBasGaucheHautDroit(char[][] plateau, char pion) {
        for (int i = 3; i < plateau.length; i++) { // Lignes à partir de 3
            for (int j = 0; j <= plateau[0].length - 4; j++) { // Colonnes
                if (plateau[i][j] == pion &&
                        plateau[i - 1][j + 1] == pion &&
                        plateau[i - 2][j + 2] == pion &&
                        plateau[i - 3][j + 3] == pion) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean verifierAlignementDiagonalBasDroitHautGauche(char[][] plateau, char pion) {
        for (int i = 3; i < plateau.length; i++) { // Lignes à partir de 3
            for (int j = 3; j < plateau[0].length; j++) { // Colonnes à partir de 3
                if (plateau[i][j] == pion &&
                        plateau[i - 1][j - 1] == pion &&
                        plateau[i - 2][j - 2] == pion &&
                        plateau[i - 3][j - 3] == pion) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean verifierVictoire(char[][] plateau, char pion) {
        return verifierAlignementVertical(plateau, pion) ||
                verifierAlignementHorizontal(plateau, pion) ||
                verifierAlignementDiagonalBasGaucheHautDroit(plateau, pion) ||
                verifierAlignementDiagonalBasDroitHautGauche(plateau, pion);
    }

    public static void jouer(char[][] plateau) {
        Scanner scanner = new Scanner(System.in);
        int joueur = 1;  // Le joueur 1 commence
        boolean partieFinie = false;

        while (!partieFinie) {
            afficherPlateau(plateau);
            System.out.println("Joueur " + joueur + ", choisissez une colonne (1 à 7) : ");
            int colonne = scanner.nextInt() - 1; // Décalage pour l'index du tableau
            String pion;
            if(joueur == 1) {
                pion = 'R' + RED;
            } else {
                pion = 'J' + RED;
            }

            if (insererPion(plateau, colonne, pion)) {
                // Vérifier si le joueur a gagné
                if (verifierVictoire(plateau, pion)) {
                    afficherPlateau(plateau);
                    System.out.println("Félicitations Joueur " + joueur + " ! Vous avez gagné !");
                    partieFinie = true;
                } else {
                    // Changer de joueur
                if (joueur == 1) {
                    joueur = 2;
                } else {
                    joueur = 1;
                }
                }
            }
        }
    }

   /*public static void JvC1(char[][] plateau) {
        Scanner scanner = new Scanner(System.in);
        int joueur = 1;  // Le joueur 1 commence
        boolean partieFinie = false;

        while (!partieFinie) {
            afficherPlateau(plateau);

        }
    }*/
}