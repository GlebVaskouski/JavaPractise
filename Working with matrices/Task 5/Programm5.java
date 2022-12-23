import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Programm5 {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader fileReader = new FileReader("D:\\Java\\Laba2\\src\\input.txt");
        Scanner sc = new Scanner(fileReader);

        int rows = 0, columns = 0, n = 0;
        n = sc.nextInt();
        rows = sc.nextInt();
        columns = sc.nextInt();

        int[][] matrix = new int[rows][columns];
        boolean logical = true;

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        int mul = 1, result = 2147483647, ind = -1;
        for (int i = 0; i < columns; i++){
            for (int j = 0; j < rows; j++){
                if(Math.abs(matrix[j][i]) >= n){
                    logical = false;
                }
            }
            if(logical == true){
                mul = 1;
                for (int j = 0; j < rows; j++){
                    mul*=matrix[j][i];
                }
                if(result > mul){
                    result = mul;
                    ind = i;
                }
            } else logical = true;
        }

        if(ind != -1) System.out.println("Result -> " + result + " Columns -> " + (++ind));
        else System.out.println("Error!");
    }
}
/*
Среди столбцов заданной  матрицы, найти столбец с минимальным произведением элементов.
 */

//10 11 12 14 15 16 17 18 19 20 21 22 23 24 25
/*
24
3 5
99 11 12 14 1
16 17 18 19 1
21 22 23 24 25
 */

