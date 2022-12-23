import java.io.*;
import java.text.*;

public class Main {
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        int k = 0;
        double x = 0, epselom = 0;

        try {
            System.out.println("Enter k:");
            String lineN = br.readLine();
            k = Integer.parseInt(lineN);
            System.out.println("Enter x:");
            String lineX = br.readLine();
            x = Double.parseDouble(lineX);
        }
        catch (NumberFormatException e) {
            System.out.println("Not an integer");
        }
        catch (IOException e) {
            System.out.println("Keyboard Read Error");
        }
        epselom = Math.pow(10, -k);

        if(x < 1 && x > -1){
            double res = 1, temp = 1, i = 1;
            while(Math.abs(temp) > epselom){
                temp = (-1)*((2*i - 1)/(2*i))*x*temp;
                res += temp;
                i++;
            }

            NumberFormat formatter = NumberFormat.getNumberInstance();
            formatter.setMaximumFractionDigits(8);
            System.out.println("My result -> " + formatter.format(res));
            System.out.println("Result with function -> " + (1/(Math.sqrt(1+x))));
        }
        else System.out.println("Incorrect value bounds!");

    }
}
