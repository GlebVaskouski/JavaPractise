import java.util.Scanner;

public class Task3078 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxLength = 0;
        int tempLength = 0;
        int val = 0, valNext = 0;
        int status = 0;

        val = scanner.nextInt();

        while(true){
            valNext = scanner.nextInt();
            if(val == 0 || valNext == 0) break;

            if(maxLength < tempLength) maxLength = tempLength;

            if(val == valNext){
                status = 0;
                tempLength = 0;
                continue;
            } else if(val > valNext){ //уменьшающаяся
                if(status == -1){
                    tempLength += 1;
                }else{
                    status = -1;
                    tempLength = 2;
                }
                val = valNext;
            } else{//возрастание
                if(status == 1){
                    tempLength += 1;
                }else{
                    status = 1;
                    tempLength = 2;

                }
                val = valNext;
            }
        }
        System.out.println(maxLength);
    }
}
