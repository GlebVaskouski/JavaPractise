import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Arrays;

public class Programm25 {

    public static boolean isSymmetricMatrix(int[][] array) {
        if(array.length != array[0].length) return false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != array[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileReader fileReader = new FileReader("D:\\Java\\Laba2\\src\\input.txt");
        Scanner sc = new Scanner(fileReader);

        int rows = 0, columns = 0;
        rows = sc.nextInt();
        columns = sc.nextInt();

        int[][] matrix = new int[rows + 2][columns + 2];
        for(int i = 0; i < matrix.length; i++){
            Arrays.fill(matrix[i], 2147483647);
        }

        for (int i = 1; i < rows + 1; i++){
            for (int j = 1; j < columns + 1; j++){
                    matrix[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < matrix.length; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println("\n\n\n" + isSymmetricMatrix(matrix));
        for (int i = 1; i < rows + 1; i++){
            for (int j = 1; j < columns + 1; j++){
                if(matrix[i][j] < matrix[i+1][j] && matrix[i][j] < matrix[i-1][j] &&
                        matrix[i][j] < matrix[i][j+1] && matrix[i][j] < matrix[i][j-1]){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int i = 0; i < matrix.length; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println("Result -> " + isSymmetricMatrix(matrix));
    }
}

/*
Определить, становится ли симметричной (относительно главной диагонали) заданная матрица после замены на число 0
каждого локального минимума. Элемент матрицы называется локальным минимумом, если он строго меньше всех
имеющихся у него соседей. Соседями элемента ajj в матрице назовем элементы aki  с i-1£k£i+1, j-1£l£j+1,(k,l)¹(i,j).

        true
        5 5
        1 -1 1 1 1
        -2 2 3 -4 5
        1 3 -1 10 15
        1 -3 10 20 6
        1 5 15 8 70

        false
        5 5
        1 -1 1 1 1
        -2 2 3 -4 5
        1 3 -1 10 15
        1 4 10 20 6
        1 5 15 8 70

        for(int i = 0; i < matrix.length; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
*/