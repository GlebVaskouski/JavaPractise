package lab_2;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class lab2_1 {

    public static boolean Symmetrical(int[][] matrix){
        if (matrix.length != matrix[0].length) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                if (matrix[i][j] != matrix[j][i]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main (String []arg) throws FileNotFoundException {
        FileReader fr = new FileReader("C:\\Users\\gleb\\IdeaProjects\\untitled\\src\\lab_2\\matrix.txt");

        Scanner sc = new Scanner(fr);
        int n;
        int m;
        int max = 0;
        int max_i = 0;
        int max_j = 0;
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                matrix[i][j] = sc.nextInt();
                if (i == j || i + j == n - 1) {
                    if (max < matrix[i][j]) {
                        max = matrix[i][j];
                        max_i = i;
                        max_j = j;
                    }
                }
            }
        }
        boolean isSymmetrical = Symmetrical(matrix);
        if (isSymmetrical) {
            System.out.println("Is symmetrical");
        } else {
            System.out.println("Is not symmetrical");
        }
        int width = Math.max(n, m);
        int height = Math.min(n, m);
        if (n/2 != 0 && m/2 != 0 && width/2 < height) {
            int tmp = matrix[max_i][max_j];
            matrix[max_i][max_j] = matrix[width/2][height/2];
            matrix[width/2][height/2] = tmp;
            System.out.println("Diagonal Max = " + tmp);
        } else {
            System.out.println("Diagonals do not extend");
        }
    }
}
