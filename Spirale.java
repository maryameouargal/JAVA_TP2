
//EXERCICE  3 - MATRICE SPIRAL 
public class Spirale {
 public static int[][] construireSpirale(int n) {
        // cas particulier n doit être >= 1
        if (n < 1) return new int[0][0];

        int[][] matrice = new int[n][n];

        // bornes de la couche actuelle
        int haut   = 0;
        int bas    = n - 1;
        int gauche = 0;
        int droite = n - 1;

        int compteur= 1;   // valeur à insérer dans la matrice

        while (haut <= bas && gauche <= droite) {

            // 1) ligne du haut : de gauche à droite
            for (int j = gauche; j <= droite; j++) {
                matrice[haut][j] = compteur;
                compteur++;
            }
            haut++;

            // 2) colonne de droite : de haut en bas
            for (int i = haut; i <= bas; i++) {
                matrice[i][droite] = compteur;
                compteur++;
            }
            droite--;

            // vérification : reste-t-il des cases à remplir 
            if (haut > bas || gauche > droite) break;

            // 3) ligne du bas : de droite à gauche
            for (int j = droite; j >= gauche; j--) {
                matrice[bas][j] = compteur;
                compteur++;
            }
            bas--;

            // 4) colonne de gauche : de bas en haut
            for (int i = bas; i >= haut; i--) {
                matrice[i][gauche] = compteur;
                compteur++;
            }
            gauche++;
        }

        return matrice;
    }

    public static void afficherMatrice(int[][] m) {
        if (m == null || m.length == 0) {
            System.out.println("Matrice vide");
            return;
        }
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.printf("%4d", m[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] tests = {0, 1, 2, 3, 4, 5};

        for (int n : tests) {
            System.out.println("Spirale de taille " + n + " :");
            int[][] spirale = construireSpirale(n);
            afficherMatrice(spirale);
            System.out.println();
        }
    }
}
    

