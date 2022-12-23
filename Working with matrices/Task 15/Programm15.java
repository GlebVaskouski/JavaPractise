import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class Programm15 {
    public static void main(String[] args) throws FileNotFoundException{
        FileReader fileReader = new FileReader("D:\\Java\\Laba2\\src\\input.txt");
        Scanner sc = new Scanner(fileReader);

        int rows = 0, columns = 0, temp = 0, result = -2147483648;
        boolean flag = false;
        rows = sc.nextInt();
        columns = sc.nextInt();

        HashMap<Integer, Integer> myHashMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < rows*columns; i++){
            temp = sc.nextInt();
            if(myHashMap.containsKey(temp)){
                myHashMap.put(temp, myHashMap.get(temp) + 1);
            } else myHashMap.put(temp, 1);
        }

        for (int key : myHashMap.keySet()) {
            if(myHashMap.get(key) == 2) {
                flag = true;
                if(result < key) result = key;
            }
        }

        if(flag) {
            System.out.println("Maximum number of occurring 2 times -> " + result);
        } else System.out.println("The given matrix does not have a maximum number that occurs exactly 2 times!");

    }
}
/*
3 5
1 4 4 2 4
3 5 1 6 3
2 6 7 9 6
 */
/*
Найти максимальное из чисел, встречающихся в заданной матрице ровно два раза.

HashMap<String, String> myHashMap = new HashMap<String, String>();

        myHashMap.put("Basil", "07.12.1987");
        myHashMap.put("Kate", "12.10.1971");
        myHashMap.put("Lena", "11.01.1991");
        for(Map.Entry<String, String> entry: myHashMap.entrySet())
            System.out.println(entry.getKey() + " - " + entry.getValue());


                    for (int key : myHashMap.keySet()) {
            System.out.println("Key -> " + key + ", Value -> " +  myHashMap.get(key));
        }
*/