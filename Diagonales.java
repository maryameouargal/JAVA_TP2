
// Exercice 9 - Somme diagonale dans une matrice carrée
public class Diagonales {
    public static int differenceDiagonales(int[][] m) {
        // cas de base où la matrice vide ou null
        if (m == null || m.length == 0) return 0;

        int n = m.length;

        // vérifier que la matrice est carrée 
        for (int i = 0; i < n; i++) {
            if (m[i].length != n) {
                System.out.println("Matrice non carrée !");
                return -1;
            }
        }

        int sommePrincipale = 0;
        int sommeSecondaire = 0;

        for (int i = 0; i < n; i++) {
            sommePrincipale += m[i][i];               // diagonale principale
            sommeSecondaire += m[i][n - 1 - i];       // diagonale secondaire
        }

        
        // afficher les sommes 
        System.out.println("Somme diagonale principale : " + sommePrincipale);
        System.out.println("Somme diagonale secondaire : " + sommeSecondaire);
        System.out.println("Somme totale des deux diagonales : "
            + (sommePrincipale + sommeSecondaire));

        // comparaison des deux diagonales (opération bonus)
        if (sommePrincipale > sommeSecondaire) {
            System.out.println("-> La diagonale principale domine.");
        } else if (sommeSecondaire > sommePrincipale) {
            System.out.println("-> La diagonale secondaire domine.");
        } else {
            System.out.println("-> Les deux diagonales sont egales.");
        }
        // afficher la différence absolue entre les deux diagonales
        int diff = Math.abs(sommePrincipale - sommeSecondaire);
        System.out.println("Difference absolue : " + diff);

        return diff;
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
            {{1, 2, 3},
             {4, 5, 6},
             {7, 8, 9}},                   

            {{2, 4, 6},
             {1, 5, 9},
             {8, 7, 3}},                   

            {{5}},                         

            {{-1, 2},
             {3, -4}},                     

            {{1, 2, 3, 4},
             {5, 6, 7, 8},
             {9, 10, 11, 12},
             {13, 14, 15, 16}}            
        };

        for (int[][] m : tests) {
            System.out.println("Matrice :");
            afficherMatrice(m);
            differenceDiagonales(m);
            System.out.println();
        }
    }
}
