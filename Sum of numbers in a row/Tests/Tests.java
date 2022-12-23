import java.io.FileReader;
import java.util.Scanner;
import org.junit.Assert;
import org.junit.Test;

public class Tests {

    @Test
    public void Test1() throws Exception{
        double res = Summ.lineSumm("15 31 o5 1_______00 u56");
        Assert.assertEquals(146.0, res, 0.1);
    }

    @Test
    public void Test2() throws Exception{
        double res = Summ.lineSumm("15 31 o5 1_______00 u56 88.79");
        Assert.assertEquals(234.79000000000002, res, 0.1);
    }

    @Test
    public void Test3() throws Exception{
        double res = Summ.lineSumm("PI");
        Assert.assertEquals(3.142, res, 0.1);
    }

    @Test
    public void Test4() throws Exception{
        double res = Summ.lineSumm("E");
        Assert.assertEquals(2.718, res, 0.1);
    }

    @Test
    public void Test5() throws Exception{
        double res = Summ.lineSumm("2.7E+1");
        Assert.assertEquals(27, res, 0.1);
    }

}
