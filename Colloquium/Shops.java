package boots;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Shops
{
    List<Shop> list;
    Shops(List<Shop> tmp){
        list = tmp;
    }
    public String binarySearch(Shop to_search) {
        int index;
        index = Collections.binarySearch(list, to_search);
        if (index > 0) return list.get(index).toString();
        else return "No";
    }
    public int YearShops(){
        Map<String, List<Shop>> shops = list.stream().collect(Collectors.groupingBy(Shop::getYear));
        for(Map.Entry<String, List<Shop>> item : shops.entrySet()){

            System.out.println(item.getKey() + ":");

            for(Shop sh : item.getValue()){

                sh.Print();
            }
            System.out.println();
        }
        return shops.size();
    }

    public void AuthorSort() {
        list.sort((Shop lhs, Shop rhs) -> {
             return lhs.getPrice().compareTo(rhs.getPrice());
        });
    }

    public void SortByName() {
        list.sort((a, b) -> a.getName().compareTo(b.getName()));
    }


    public void print(){
        for(var el : list){
            el.Print();
        }
    }
}
