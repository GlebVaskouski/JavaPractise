import java.io.FileReader;
import java.util.Scanner;
import org.junit.Assert;
import org.junit.Test;

public class Tests {

    @Test
    public void Test1() throws Exception{
        double res = Teilor.getResult(7, 0.5);
        Assert.assertEquals(0.8164965809277261, res, 0.1);
    }

    @Test
    public void Test2() throws Exception{
        double res = Teilor.getResult(7, -0.5);
        Assert.assertEquals(1.414213562373095, res, 0.1);
    }

    @Test
    public void Test3() throws Exception{
        double res = Teilor.getResult(7, 0.2);
        Assert.assertEquals(0.9128709291752769, res, 0.1);
    }

    @Test
    public void FileTest() throws Exception{
        FileReader fileReader = new FileReader("D:\\PP last projects\\Laba1Teilor\\src\\TestsFile");
        Scanner sc = new Scanner(fileReader);

        int k = 0;
        double x = 0, expected = 0, res = 0;

        while (sc.hasNextLine()) {
            k = sc.nextInt();
            x = sc.nextDouble();
            expected = 1/(Math.sqrt(1+x));
            res = Teilor.getResult(k, x);
            Assert.assertEquals(expected, res, 0.1);
        }
    }
}
