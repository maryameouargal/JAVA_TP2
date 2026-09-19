
// Exercice 5 - Permutation circulaire
public class PermutationCirculaire {
     public static boolean estPermutationCirculaire(int[] t) {
        // cas de base
        if (t == null || t.length == 0) return false;

        int taille = t.length;

        // 1) vérifier que c'est une permutation de 1..n
        boolean[] dejaVu = new boolean[taille + 1];   
        for (int i = 0; i < taille; i++) {
            int val = t[i];
            if (val < 1 || val > taille) return false;   
            if (dejaVu[val]) return false;            
            dejaVu[val] = true;
        }

        // 2) trouver la position de 1
        int positionde1 = -1;
        for (int i = 0; i < taille; i++) {
            if (t[i] == 1) {
                positionde1 = i;
                break;
            }
        }

        // 3) vérifier l'ordre circulaire
        for (int k = 0; k < taille; k++) {
            int idx = (positionde1 + k) % taille;
            if (t[idx] != k + 1) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] tests = {
              // cas de base
        {1},                                         
        {1, 2, 3, 4, 5}, 

        // rotations valides (taille=5)
        {2, 3, 4, 5, 1},                
        {3, 4, 5, 1, 2},                
        {4, 5, 1, 2, 3},                
        {5, 1, 2, 3, 4},                 

        // permutations non circulaires
        {3, 1, 2, 4, 5},                 
        {2, 1, 3, 4, 5},                 
        {4, 1, 2, 3, 5},                 

        // hors intervalle / doublons
        {0, 1, 2, 3, 4},                 
        {1, 2, 2, 3, 4},                 
        {1, 2, 3, 4, 6},                 

        // rotation d'une autre taille
        {3, 1, 2},                       
        {3, 2, 1}                        
       };

        for (int[] t : tests) {
        System.out.println(java.util.Arrays.toString(t)
            + " -> " + estPermutationCirculaire(t));
        }
    }
}

