
// Exercice 6 - Sous-tableau de somme maximale (Kadane)

public class Kadane {
    // Version imposée par l'énoncé : retourne juste la somme maximale
    public static int maxSubarraySum(int[] t) {
        int[] resultat = maxSubarrayAvecIndices(t);
        return resultat[0];
    }
    
       // Version enrichie (extension) : retourne {somme, début, fin}
   public static int[] maxSubarrayAvecIndices(int[] t) {
        // cas de base
        if (t == null || t.length == 0) return new int[]{0, -1, -1};

        // initialisation
        int sommeCourante = t[0];
        int sommeMax      = t[0];
        int debutCourant  = 0;
        int debutMax      = 0;
        int finMax        = 0;

        // parcours à partir de l'indice 1
        for (int i = 1; i < t.length; i++) {
            // si on redémarre (t[i] meilleur que prolonger)
           if (t[i] > sommeCourante + t[i]) {
            sommeCourante = t[i];
            debutCourant = i;
           } else {
            sommeCourante += t[i];
           }

        // mise à jour du record
           if (sommeCourante > sommeMax) {
            sommeMax = sommeCourante;
            debutMax = debutCourant;
            finMax = i;
           }
        }
    
            return new int[]{sommeMax, debutMax, finMax};
    }


    public static void main(String[] args) {
         int[][] tests = {
        // exemple de l'énoncé
        {-2, 1, -3, 4, -1, 2, 1, -5, 4},   

        // tous positifs
        {3, 5, 7, 2},                       

        // tous négatifs
        {-4, -2, -7},                       

        // un seul élément
        {9},                                
        {-8},                               

        // max au milieu
        {-3, -1, 4, 6, -7},                

        // plusieurs sous-suites possibles
        {2, -2, 2, -2, 2}                  
    };

       for (int[] t : tests) {
            int somme = maxSubarraySum(t);                  // version imposée
            int[] detail = maxSubarrayAvecIndices(t);       // version enrichie

            System.out.println(java.util.Arrays.toString(t));
            System.out.printf("  somme max = %d, debut = %d, fin = %d%n",
                somme, detail[1], detail[2]);
        }
    }
}
