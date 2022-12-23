import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader fileReader = new FileReader("D:\\PP last projects\\LineAmount\\src\\input.txt");
        Scanner sc = new Scanner(fileReader);
        StringBuilder text = new StringBuilder();

        while (sc.hasNextLine()) {
            text.append(sc.nextLine());
            text.append("\n");
        }
        String str = text.toString();

        System.out.println("Result -> " + Summ.lineSumm(str));
    }
}
