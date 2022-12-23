import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Store {

    ArrayList<Shoes> shoesArrayList;
    boolean listCreationFlag = false;

    public Store(ArrayList<Shoes> shoesArrayList) {
        this.shoesArrayList = shoesArrayList;
        this.listCreationFlag = true;
    }
    public Store() {
        this.shoesArrayList = new ArrayList<Shoes>();
        this.listCreationFlag = true;
    }

    @Override
    public String toString() {
        return "Store{" +
                "shoesArrayList=" + shoesArrayList +
                '}';
    }

    /*
    @Override
    public String toString() {
        return "Магазин{" +
                "Список обуви = " + shoesArrayList +
                '}';
    }
     */

    public void enteringDataFromFile(String FName) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader(FName));
        if(!listCreationFlag) new Store();

        String name = null, company = null, date = null;
        int count = 0, month = 0, year = 0;
        double cost = 0;

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
                else if(matcherDate.matches()){
                    date = str;
                    int pointIndex = str.lastIndexOf(".");;
                    month =  parseInt(str.substring(0, pointIndex));
                    year =  parseInt(str.substring(pointIndex + 1));
                }
                else if(matcherCount.matches()) count = parseInt(str);
                else if(matcherCost.matches()) cost = parseDouble(str);
                else System.out.println("Input Error");
            }
            this.shoesArrayList.add(new Shoes(name, company, date, month, year, count, cost));
        }
    }

    public void addEmptyPair(){
        this.shoesArrayList.add(new Shoes());
    }

    public void addPairWithParameters(String name, String company, String date, int amount, double price){
        int pointIndex = date.lastIndexOf(".");;
        int month =  parseInt(date.substring(0, pointIndex));
        int year =  parseInt(date.substring(pointIndex + 1));
        this.shoesArrayList.add(new Shoes(name, company, date, month, year, amount, price));
    }

    public void cOutput(){
        for (Shoes sh : this.shoesArrayList) {
            System.out.println(sh.toString());
        }
    }

    public void fOutput(String FName) throws IOException {
        FileWriter writer = new FileWriter(FName, false);
        for (Shoes sh : this.shoesArrayList) {
            writer.write(sh.toString());
            writer.append('\n');
        }
        writer.flush();
    }

    public void SortByShoeName(){
        this.shoesArrayList.sort((a, b) -> a.getShoeName().compareTo(b.getShoeName()));
    }

    public void SortByPriceAscending(){
        this.shoesArrayList.sort((a, b) -> Double.compare(a.getPrice(), b.getPrice()));
    }

    public ArrayList<Shoes> FilterByYear(int year) {
        var stream = this.shoesArrayList.stream();
        ArrayList<Shoes> result = stream.filter(m -> {
            return (m.getYear() == year);
        }).collect(Collectors.toCollection(ArrayList::new));
        return result;
    }
    public String binarySearchByShoeName (String shoeName){
        Shoes sh = new Shoes();
        sh.setShoeName(shoeName);
        int consist = Collections.binarySearch(this.shoesArrayList, sh, (a, b) -> a.getShoeName().compareTo(b.getShoeName()));
        if(consist < 0) return "This product is not in the store!";
        //""Данного товара нет в магазине";
        else return this.shoesArrayList.get(consist).toString();
    }

    public Map<Integer, List<Shoes>> groupByYear(){
        var stream = this.shoesArrayList.stream();
        Map<Integer, List<Shoes>> result = stream.collect(Collectors.groupingBy(Shoes::getYear));
        return result;
    }
    public void cOutArrayListWithShoes(ArrayList<Shoes> arrayList){
        for (Shoes sh : arrayList) {
            System.out.println(sh.toString());
        }
    }

    public void cOutMapByYearWithShoes(Map<Integer, List<Shoes>> map){
        for (int key : map.keySet()) {
            System.out.println("Обувь " + key + " года:");
            for (Shoes sh : map.get(key)) {
                System.out.println(sh.toString());
            }
            System.out.println();
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

/*            System.out.println("Name -> " + name);
            System.out.println("company -> " + company);
            System.out.println("date -> " + date);
            System.out.println("month -> " + month);
            System.out.println("year -> " + year);
            System.out.println("count -> " + count);
            System.out.println("cost -> " + cost);*/