package lab_2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class lab2_3 {
    public static void main(String[] args) throws FileNotFoundException {

        FileReader fr = new FileReader("C:\\Users\\gleb\\IdeaProjects\\untitled\\src\\lab_2\\matrix.txt");

        Scanner scanner = new Scanner(fr);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] myArray = new int[n][m];

        for (int h = 0; h < n; ++h) {
            for (int w = 0; w < m; ++w) {
                myArray[h][w] = scanner.nextInt();
            }
        }
        int counter = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (isLocalMin(i, j, myArray)){
                    counter++;
                }
            }
        }
        if (counter != 0) {
            System.out.print(counter);
        } else {
            System.out.print("There is no local minimums in matrix");
        }
    }

    public static boolean isLocalMin(int i, int j, int[][] my_matrix) {
        int tmp_value = my_matrix[i][j];
        if (i > 0 && tmp_value >= my_matrix[i - 1][j]) {
            return false;
        }
        if (j > 0 && tmp_value >= my_matrix[i][j - 1]) {
            return false;
        }
        if (i < my_matrix.length - 1 && tmp_value >= my_matrix[i + 1][j]) {
            return false;
        }
        if (j < my_matrix[0].length - 1 && tmp_value >= my_matrix[i][j + 1]) {
            return false;
        }

        return true;

    }
}
