import java.io.IOException;
import java.util.Scanner;

public class task {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int length = n;
        int width = m;
        int kolvo = scanner.nextInt();
        int[][] matrix = new int[n+2][m+2];
        for(int i = 0; i < kolvo; ++i){
            n = scanner.nextInt();
            m = scanner.nextInt();
            matrix[n][m] = -9;
            matrix[n-1][m]++;
            matrix[n+1][m]++;
            matrix[n][m-1]++;
            matrix[n][m+1]++;
            matrix[n-1][m+1]++;
            matrix[n+1][m+1]++;
            matrix[n-1][m-1]++;
            matrix[n+1][m-1]++;
        }
        for (int i = 1; i <= length;++i){
            String out = new String();
            for(int j = 1; j <= width;++j){
                if (matrix[i][j] >= 0){
                    out += Integer.toString(matrix[i][j]) + ' ';
                } else {
                    out += "* ";
                }
            }
            System.out.println(out);
        }
    }
}
