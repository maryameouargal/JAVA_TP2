import java.util.Stack;

// EXERCICE  4 - Plus grand rectangle de 1s dans une matrice binaire
public class MaxRectangle {
    
    // Classe interne pour stocker le résultat
   static class Rectangle {
        int top, left, bottom, right, area;

        Rectangle(int t, int l, int b, int r, int a) {
            this.top = t;
            this.left = l;
            this.bottom = b;
            this.right = r;
            this.area = a;
        }

        
        public String toString() {
            return "Rectangle [top=" + top + ", left=" + left
                 + ", bottom=" + bottom + ", right=" + right
                 + ", aire=" + area + "]";
        }
    }

    public static Rectangle trouverMaxRectangle(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) return null;

        int lignes = m.length;
        int colonnes = m[0].length;

        // 1) construire la matrice de hauteurs
        int[][] h = new int[lignes][colonnes];
        for (int j = 0; j < colonnes; j++) {
            h[0][j] = m[0][j];
            for (int i = 1; i < lignes; i++) {
                h[i][j] = (m[i][j] == 1) ? h[i - 1][j] + 1 : 0;
            }
        }

        // 2) traiter chaque ligne comme un histogramme
        Rectangle record = new Rectangle(0, 0, 0, 0, 0);
        for (int i = 0; i < lignes; i++) {
            Rectangle rect = traiterHistogramme(h[i], i);
            if (rect.area > record.area) {
                record = rect;
            }
        }

        return record;
    }

    // Traite un histogramme et renvoie le meilleur rectangle
    private static Rectangle traiterHistogramme(int[] hauteurs, int ligneCourante) {
        Stack<Integer> stackIndices = new Stack<>();
        Rectangle record = new Rectangle(0, 0, 0, 0, 0);
        int c = hauteurs.length;

        for (int j = 0; j <= c; j++) {
            int hauteurCourante = (j == c) ? 0 : hauteurs[j];

            while (!stackIndices.isEmpty() && hauteurs[stackIndices.peek()] > hauteurCourante) {
                int hauteur = hauteurs[stackIndices.pop()];
                int left = stackIndices.isEmpty() ? 0 : stackIndices.peek() + 1;
                int right = j - 1;
                int largeur = right - left + 1;
                int aire = hauteur * largeur;

                if (aire > record.area) {
                    int top = ligneCourante - hauteur + 1;
                    record = new Rectangle(top, left, ligneCourante, right, aire);
                }
            }
            stackIndices.push(j);
        }
        return record;
    }

    public static void main(String[] args) {
        int[][][] tests = {
            {{0}},
            {{1}},
            {{0,0,0,0},
             {0,1,1,0},
             {0,1,1,0},
             {0,0,0,0}},
            {{1,1,0,1},
             {1,1,0,1},
             {0,0,1,1}},
            {{1,1,1},
             {1,1,1},
             {1,1,1}},
            {{0,0,0},
             {0,0,0},
             {0,0,0}},
            {{0,1,1,0,1},
             {1,1,1,1,0},
             {1,1,1,1,0},
             {1,1,0,0,1}}
        };

        for (int[][] m : tests) {
            Rectangle r = trouverMaxRectangle(m);
            System.out.println(r);
        }
    }
}