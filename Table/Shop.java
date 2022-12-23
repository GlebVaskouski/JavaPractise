package com.example.ltwui;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Shop {
    public ObservableList<Shoes> list;
    public Shop() {
        this.list = FXCollections.observableArrayList();
    }

    public Shop(ObservableList<Shoes> list) {
        this.list = list;
    }

    public ObservableList<Shoes> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "Store{" +
                "shoesArrayList=" + list +
                '}';
    }

    public void addEmptyPair(){
        this.list.add(new Shoes());
    }

    public void cOutput(){
        for (Shoes sh : this.list) {
            System.out.println(sh.toString());
        }
    }

    public void fOutput(String FName) throws IOException {
        FileWriter writer = new FileWriter(FName, false);
        for (Shoes sh : this.list) {
            writer.write(sh.toString());
            writer.append('\n');
        }
        writer.flush();
    }

    public void SortByName(){
        this.list.sort((a, b) -> a.getPName().compareTo(b.getPName()));
    }

    public void SortByPrice(){
        this.list.sort((a, b) -> Double.compare(parseDouble(a.getPPrice()), parseDouble(b.getPPrice())));
    }

    public ArrayList<Shoes> FilterByYear(int year) {
        var stream = this.list.stream();
        ArrayList<Shoes> result = stream.filter(m -> {
            return (m.getPYear() == year);
        }).collect(Collectors.toCollection(ArrayList::new));
        return result;
    }

    public int binSearchByName (String shoeName){
        Shoes sh = new Shoes();
        sh.setPName(shoeName);
        int consist = Collections.binarySearch(this.list, sh, (a, b) -> a.getPName().compareTo(b.getPName()));
        return consist;

    }

    public void cOutArrayListWithShoes(ArrayList<Shoes> arrayList){
        for (Shoes sh : arrayList) {
            System.out.println(sh.toString());
        }
    }
    public void enteringDataFromFile(String FName) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader(FName));
        String name = null, company = null, date = null, count = null, cost = null;
        int  month = 0, year = 0;

        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            line = line.replaceAll("\"", "QUOTATION");
            line = line.replaceAll("\\(", "BRACKET1");
            line = line.replaceAll("\\)", "BRACKET2");
            ArrayList<String> currentPair = getWords(line);

            for (String str : currentPair) {
                str = str.replaceAll("QUOTATION","\"" );
                str = str.replaceAll("BRACKET1", "\\(");
                str = str.replaceAll("BRACKET2", "\\)");

                Matcher matcherName = Pattern.compile("\"(\\w+)\"").matcher(str);
                Matcher matcherFirm = Pattern.compile("\\(\\w+\\)").matcher(str);
                Matcher matcherDate = Pattern.compile("\\d{2}\\.\\d{4}").matcher(str);
                Matcher matcherCount = Pattern.compile("(([0-9]?[0-9])|(100))").matcher(str);
                Matcher matcherCost = Pattern.compile("\\d+\\.\\d{2}").matcher(str);

                if(matcherName.matches()) name = str;
                else if(matcherFirm.matches()) company = str;
                else if(matcherDate.matches()) date = str;
                else if(matcherCount.matches()) count = str;
                else if(matcherCost.matches()) cost = str;
                else System.out.println("Input Error");
            }

            this.list.add(new Shoes(
                    new SimpleStringProperty(name),
                    new SimpleStringProperty(company),
                    new SimpleStringProperty(date),
                    new SimpleStringProperty(count),
                    new SimpleStringProperty(cost)));
        }
    }
    public static ArrayList<String> getWords(String text) {
        ArrayList<String> words = new ArrayList<String>();
        BreakIterator breakIterator = BreakIterator.getWordInstance();
        breakIterator.setText(text);
        int lastIndex = breakIterator.first();
        while (BreakIterator.DONE != lastIndex) {
            int firstIndex = lastIndex;
            lastIndex = breakIterator.next();
            if (lastIndex != BreakIterator.DONE && Character.isLetterOrDigit(text.charAt(firstIndex))) {
                words.add(text.substring(firstIndex, lastIndex));
            }
        }
        return words;
    }
}

