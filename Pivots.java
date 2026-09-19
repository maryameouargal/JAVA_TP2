import java.util.ArrayList;
import java.util.List;

//EXERCICE 2 - PIVOTS
public class Pivots {
   public static void afficherPivots(int[] t) {
        // cas où le tableauest  vide ou trop petit
        if (t == null || t.length < 3) {
            System.out.println("Aucun pivot");
            return;
        }

        int n = t.length;

        // 1) construction de prefixMax
        int[] prefixMax = new int[n];
        prefixMax[0] = t[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], t[i]);
        }

        // 2) construction de suffixMin
        int[] suffixMin = new int[n];
        suffixMin[n - 1] = t[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], t[i]);
        }

        // 3)  pour chercher les pivots
         List<Integer> pivots = new ArrayList<>();
       for (int i = 1; i < n - 1; i++) {
        // tout à gauche <= t[i]   ET   tout à droite >= t[i]
         if (prefixMax[i - 1] <= t[i] && suffixMin[i + 1] >= t[i]) {
            pivots.add(t[i]);
    }
}


        // 4) afficher
        if (pivots.isEmpty()) {
            System.out.println("Aucun pivot");
        } else {
            System.out.print("Pivots : ");
             for (int p : pivots) System.out.print(" " + p);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] tests = {
            {},      // C'EST VIDE
            {42},     // C'EST UN SEUL ELEMENT
            {9, 7, 5, 3, 1},  // C'EST UNE SEQUENCE DECROISSANTE
            {1, 3, 5, 7, 9, 11},    // C'EST UNE SEQUENCE CROISSANTE
            {3, 1, 5, 2, 4, 6, 0, 8},    // C'EST UNE SEQUENCE MIXTE
            {7, 7, 7, 7, 7},              // C'EST UNE SEQUENCE CONSTANTE
            {50, 40, 10, 20, 15, 30, 90, 25}   // C'EST UNE SEQUENCE MIXTE
        };

        for (int[] t : tests) {
            afficherPivots(t);
        }
    }
} 

