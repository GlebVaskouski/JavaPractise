package boots;


import java.io.FileReader;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) throws Exception {
        Shop sh = new Shop();
        Shops shops = new Shops(sh.ShopFromFile("C:\\Users\\gleb\\Desktop\\Kr\\src\\main\\java\\boots\\txt"));
        shops.AuthorSort();
        shops.print();
    }
}
