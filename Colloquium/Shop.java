package boots;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Shop implements Comparable <Shop>{
    private String name;
    private String Data;
    private int packages;
    private Double price;

    public String getName() {
        int pos = name.indexOf("(");
        return name.substring(0, pos);
    }

    public Double getPrice() {
        return price;
    }

    public String getYear(){
        return Data.substring(3);
    }

    public int getPackages() {
        return packages;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPackages(int packages) {
        this.packages = packages;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void input(String str) throws IOException {
        Pattern namePattern = Pattern.compile("(\"(.*)\")");
        Pattern companyPattern = Pattern.compile("([(].*[)])");
        Pattern pricePattern = Pattern.compile("([ ][0-9]*[.][0-9]?[0-9]?[ ])");
        Pattern DataPattern = Pattern.compile("(0[0-9][.]202[0-2])|(1[0-2][.]202[0-2])");
        Pattern packagesPattern = Pattern.compile("([ ](0?[0-9]?[0-9])[ ])|([ ]([1][0][0])[ ])");
        Matcher mn = namePattern.matcher(str);
        Matcher mc = companyPattern.matcher(str);
        Matcher mpr = pricePattern.matcher(str);
        Matcher md = DataPattern.matcher(str);
        Matcher mpa = packagesPattern.matcher(str);
        md.find();
        Data = md.group(0);
        mpa.find();
        packages = Integer.parseInt(mpa.group().substring(1, mpa.group().length()-1));
        mpr.find();
        price =  Double.parseDouble(mpr.group().substring(1, mpr.group().length()-1));
        mn.find();
        mc.find();
        name = mn.group(1) + " " + mc.group();
    }
    public static List<Shop> ShopFromFile(String inputFileName) throws IOException {
        var inputFile = new File(inputFileName);
        var scanner = new Scanner(inputFile);
        var size = Integer.parseInt(scanner.nextLine());
        var shops = new ArrayList<Shop>(size);

        for (int i = 0; i < size; i++) {
            var Line = scanner.nextLine();
            Shop sh = new Shop();
            sh.input(Line);
            shops.add(sh);

        }
        return shops;
    }
    public void Print() {
        System.out.println(name + " " + " " + Data + " " + packages + " " + price);
    }
    public void SortByName(List<Shop> shops) {
        shops.sort((a, b) -> a.getName().compareTo(b.getName()));
    }

    @Override
    public int compareTo(Shop o) {
        return this.price.compareTo(o.price);
    }
}

