
//Exercice 7 — Fréquence majoritaire (majorité absolue)

public class Majoritaire {
     public static int elementMajoritaire(int[] t) {
        // cas de base
        if (t == null || t.length == 0) return -1;

        int taille = t.length;

        // 1) trouver un candidat par vote
        int candidat = 0;
        int voix     = 0;

        for (int i = 0; i < taille; i++) {
            if (voix == 0) {
                candidat = t[i];
                voix = 1;
            } else if (t[i] == candidat) {
                voix++;
            } else {
                voix--;
            }
        }

        // 2) vérifier que le candidat est vraiment majoritaire
        int occurrences = 0;
        for (int i = 0; i < taille; i++) {
            if (t[i] == candidat) {
                occurrences++;
            }
        }

        if (occurrences > taille / 2) {
            return candidat;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[][] tests = {
            // exemple de l'énoncé
            {1, 2, 3, 2, 2},                    

            // aucun majoritaire
            {1, 2, 3, 4},                       

            // tous identiques
            {5, 5, 5, 5},                       

            // un seul élément
            {9},                                

            // majoritaire au début
            {7, 7, 2, 3, 7},                    

            // majoritaire à la fin
            {4, 4, 5, 4}                         
        };

        for (int[] test : tests) {
            int majoritaire = elementMajoritaire(test);
            System.out.println("Tableau : " + java.util.Arrays.toString(test));
            if (majoritaire != -1) {
                System.out.println("Élément majoritaire : " + majoritaire);
            } else {
                System.out.println("Aucun élément majoritaire.");
            }
            System.out.println();
        }
    }
}

