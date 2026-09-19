
//Exercice 8 — Nombres absents
public class NombresAbsents {
     public static void afficherElementsManquants(int[] t) {
        // cas de base
        if (t == null || t.length == 0) {
            System.out.println("Tableau vide");
            return;
        }

        int n = t.length;

        // 1) marquer les valeurs présentes
        boolean[] vu = new boolean[n + 1];   
        for (int i = 0; i < n; i++) {
            if (t[i] >= 1 && t[i] <= n) {
                vu[t[i]] = true;
            }
        }

        // 2) afficher les manquants
        boolean auMoinsUnManquant = false;
        for (int k = 1; k <= n; k++) {
            if (!vu[k]) {
                System.out.print(k + " ");
                auMoinsUnManquant = true;
            }
        }

        // message si aucun manquant
        if (!auMoinsUnManquant) {
            System.out.println("Aucun element manquant");
        }
    }

    public static void main(String[] args) {
        int[][] tests = {
            // exemple de l'énoncé
            {4, 3, 2, 7, 8, 2, 3, 1},          

            // aucun manquant
            {1, 2, 3, 4},                       

            // tous manquants
            {5, 6, 7},                          

            // un seul élément
            {1},                                

            // éléments hors plage
            {0, -1, 5, 6}                       

        };

        for (int[] test : tests) {
            System.out.println("Tableau : " + java.util.Arrays.toString(test));
            System.out.print("Elements manquants : ");
            afficherElementsManquants(test);
            System.out.println();
        }
    }

}
