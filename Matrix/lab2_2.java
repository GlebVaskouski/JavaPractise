package lab_2;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class lab2_2 {
    public static void main(String[] args) throws FileNotFoundException {

        FileReader fr = new FileReader("C:\\Users\\gleb\\IdeaProjects\\untitled\\src\\lab_2\\matrix.txt");

        Scanner scanner = new Scanner(fr);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] myArray = new int[m][n];

        for (int h = 0; h < m; ++h) {
            for (int w = 0; w < n; ++w) {
                myArray[h][w] = scanner.nextInt();
            }
        }
        System.out.print(findNorm(myArray));
    }

    public static int findNorm(int[][] array) {
        int resultNorm = Integer.MAX_VALUE;
        for (int h = 0; h < array.length; ++h) {
            int currentNorm = 0;
            for (int w = 0; w < array[0].length; ++w) {
                currentNorm += array[h][w];
            }
            if (currentNorm < resultNorm) {
                resultNorm = currentNorm;
            }
        }
        return resultNorm;
    }
}
