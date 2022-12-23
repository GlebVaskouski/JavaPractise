import java.text.NumberFormat;

public class Teilor {
    public static double getResult(int k, double x) {
        double epselom = 0;
        epselom = Math.pow(10, -k);

        if (x < 1 && x > -1) {
            double res = 1, temp = 1, i = 1;
            while (Math.abs(temp) > epselom) {
                temp = (-1) * ((2 * i - 1) / (2 * i)) * x * temp;
                res += temp;
                i++;
            }
            return res;
        } else return 0;
    }
}
