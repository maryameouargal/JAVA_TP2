// Exercice 1 - LIS
public class LIS {

    /** 
     * Retourne la longueur de la plus longue sous-séquence
     * strictement croissante du tableau t.
     */

    public static int longueurLIS(int[] t) {
        // c'est just une condtion pour les cas où on a une tableau vide ou nul 
        if (t == null || t.length == 0) return 0;

        int taille = t.length;
        int[] dp = new int[taille]; // dp[i] est la longueur de la plus longue sous-séquence comme il se termine à l'indice i 
        int maxLongueur = 0;

        for (int i = 0; i < taille; i++) {
            dp[i] = 1;     // t[i] tout seul forme une sous-séquence de longueur 1
                   
            for (int j = 0; j < i; j++) {
                // pour que une prolangation de la sous-séquence soit possible, t[j] doit être inférieur à t[i]
                if (t[j] < t[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            // pour garder  la plus grande longueur vécu  jusqu'ici
            if (dp[i] > maxLongueur) maxLongueur = dp[i];
        }
        return maxLongueur;
    }

    public static void main(String[] args) {
        int[][] tests = {
            {},      // C'EST VIDE 0
            {42},     // C'EST UN SEUL ELEMENT       1            
            {9, 7, 5, 3, 1},  // C'EST UNE SEQUENCE DECROISSANTE     1
            {1, 3, 5, 7, 9, 11},    // C'EST UNE SEQUENCE CROISSANTE     6    
            {3, 1, 5, 2, 4, 6, 0, 8},    // C'EST UNE SEQUENCE MIXTE     5
            {7, 7, 7, 7, 7},              // C'EST UNE SEQUENCE CONSTANTE     1
            {50, 40, 10, 20, 15, 30, 90, 25}  // C'EST UNE SEQUENCE MIXTE     4
    };
                           


        for (int[] t : tests) {
            System.out.println("LIS = " + longueurLIS(t));
        }
    }
}