import java.util.Arrays;
import java.util.Scanner;

public class Task1444 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int[][] field = new int [rows][cols];
            for (int i = 0; i < rows; i++) {
                Arrays.fill(field[i], 0);
            }
            int strings = scanner.nextInt();
            for (int i = 0; i < strings; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                field[x-1][y-1] = -1;
            }
            int[][] new_field = new int [rows + 2][cols + 2];

            for (int i = 1; i < rows + 1; i++) {
                for (int j = 1; j < cols + 1; j++) {
                    new_field[i][j] = field[i - 1][j - 1];
                }
            }
            for (int i = 1; i < rows + 1; i++) {
                for (int j = 1; j < cols + 1; j++) {
                    if (new_field[i][j] != -1) {
                        if (new_field[i][j + 1] == -1) {
                            field[i - 1][j - 1]++;
                        }
                        if (new_field[i + 1][j] == -1) {
                            field[i - 1][j - 1]++;
                        }
                        if (new_field[i - 1][j] == -1) {
                            field[i - 1][j - 1]++;
                        }
                        if (new_field[i][j - 1] == -1) {
                            field[i - 1][j - 1]++;
                        }
                        if (new_field[i + 1][j + 1] == -1) {
                            field[i - 1][j - 1]++;
                        }
                        if (new_field[i - 1][j - 1] == -1) {
                            field[i - 1][j - 1]++;
                        }
                        if (new_field[i - 1][j + 1] == -1) {
                            field[i - 1][j - 1]++;
                        }
                        if (new_field[i + 1][j - 1] == -1) {
                            field[i - 1][j - 1]++;
                        }
                    }
                }
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (field[i][j] == -1) System.out.print("* ");
                    else System.out.print(field[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

