package com.example.herewegoagain;

import javafx.beans.property.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Shop{


    private final StringProperty name;

    private StringProperty onlyName;
    private StringProperty year;
    private final StringProperty Data;
    private final IntegerProperty packages;
    private final DoubleProperty price;
    public Shop(){this(null,null,0,0);};

    public Shop(String name, String data, int packages1, double price){
        this.name =   new SimpleStringProperty(name);
        if(name != null) {
            int pos = name.indexOf("(");
            onlyName = new SimpleStringProperty(name.substring(1, pos-1));
        }
        Data =  new SimpleStringProperty(data);
        if (data != null) {
            year = new SimpleStringProperty(data.substring(3));
        }
        this.packages =  new SimpleIntegerProperty(packages1);
        this.price = new SimpleDoubleProperty(price);
    }
    public int getPackages() {
        return packages.get();
    }

    public void setName(String nam){
        name.set(nam);
        int pos = nam.indexOf("(");
        onlyName = new SimpleStringProperty(nam.substring(1, pos-2));
    }

    public void setData(String dat){
        Data.set(dat);
        year = new SimpleStringProperty(dat.substring(3));
    }
    public void setYear(String dat){
        year.set(dat);

    }
    public void setPackages(int packag){
        packages.set(packag);
    }
    public void setPrice(double pr){
        price.set(pr);
    }

    public StringProperty getYear(){
        return year;
    }
    public String getData() {
        return Data.get();
    }
    public String getName() {
        return name.get();
    }

    public double getPrice() {
        return price.get();
    }

    public IntegerProperty packagesProperty() {
        return packages;
    }

    public StringProperty dataProperty() {
        return Data;
    }

    public String getOnlyName() {
        String st = name.getName();
        int pos = st.indexOf("(");
        return st.substring(0, pos);
    }


    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty onlyNameProperty() {
        return onlyName;
    }
    public DoubleProperty priceProperty() {
        return price;
    }

    public void Print() {
        System.out.println(name + " " + " " + Data + " " + packages + " " + price);
    }

    public void setOnlyName(String onlyName) {
        this.onlyName.set(onlyName);
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
        this.setData(md.group(0));
        mpa.find();
        this.setPackages(Integer.parseInt(mpa.group().substring(1, mpa.group().length()-1)));
        mpr.find();
        this.setPrice(Double.parseDouble(mpr.group().substring(1, mpr.group().length()-1)));
        mn.find();
        mc.find();
        this.setName(mn.group(1) + " " + mc.group());
    }
}


