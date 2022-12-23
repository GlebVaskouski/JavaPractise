
import java.io.IOException;
import java.util.Scanner;

public class task {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int lastNumber = scanner.nextInt();
        int length = 1;
        int max_length = 0;
        boolean higher = true;
        int n = -1;
        while (true) {
            n = scanner.nextInt();
            if(n == 0 || lastNumber == 0){
                if (n == 0 && max_length == 0){
                    max_length = 1;
                }
                break;
            }
            if (higher) {
                if (n > lastNumber) {
                    length++;
                    lastNumber = n;
                } else {
                    if (n == lastNumber) {
                        length = 1;
                    } else {
                        length = 2;
                        lastNumber = n;
                        higher = false;
                    }
                }
            } else {
                if (n < lastNumber) {
                    length++;
                    lastNumber = n;
                } else {
                    if (n == lastNumber) {
                        length = 1;
                    } else {
                        length = 2;
                        lastNumber = n;
                        higher = true;
                    }
                }
            }
            if (max_length < length){
                max_length = length;
            }
        }
        System.out.println(max_length);
    }
}
