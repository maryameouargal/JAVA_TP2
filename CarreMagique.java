
// Exercice 10 - Matrice magique 3x3
public class CarreMagique {

    public static boolean estCarreMagique(int[][] m) {
        // vérifier que la matrice est bien 3x3
        if (m == null || m.length != 3) return false;
        for (int i = 0; i < 3; i++) {
            if (m[i].length != 3) return false;
        }

        // 1) somme de référence = première ligne
        int reference = 0;
        for (int j = 0; j < 3; j++) {
            reference += m[0][j];
        }

        // 2) vérifier les autres lignes
        for (int i = 1; i < 3; i++) {
            int somme = 0;
            for (int j = 0; j < 3; j++) {
                somme += m[i][j];
            }
            if (somme != reference) return false;
        }

        // 3) vérifier les colonnes
        for (int j = 0; j < 3; j++) {
            int somme = 0;
            for (int i = 0; i < 3; i++) {
                somme += m[i][j];
            }
            if (somme != reference) return false;
        }

        // 4) vérifier les diagonales
        int diagPrincipale = m[0][0] + m[1][1] + m[2][2];
        int diagSecondaire = m[0][2] + m[1][1] + m[2][0];

        if (diagPrincipale != reference || diagSecondaire != reference) return false;

        return true;
    }
        //somme magique
     public static int sommeMagique(int[][] m) {
        return m[0][0] + m[0][1] + m[0][2];
    }

    // affichage de la matrice 
    public static void afficherMatrice(int[][] m) {
        for (int[] ligne : m) {
            for (int val : ligne) {
                System.out.printf("%5d", val);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][][] tests = {
            {{8, 1, 6},
             {3, 5, 7},
             {4, 9, 2}},                   

            {{2, 7, 6},
             {9, 5, 1},
             {4, 3, 8}},                   

            {{1, 2, 3},
             {4, 5, 6},
             {7, 8, 9}},                   

            {{4, 9, 2},
             {3, 5, 7},
             {8, 1, 6}}                    
        };

        for (int[][] test : tests) {
            System.out.println("Matrice :");
            afficherMatrice(test);
            
            boolean magique = estCarreMagique(test);
            System.out.println("Est-ce un carre magique ? " + magique);
            System.out.println();
        }

    }
}

    

