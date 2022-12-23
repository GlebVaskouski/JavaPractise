import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class BookShelf {
    ArrayList<Book> shelf;

    public BookShelf(ArrayList<Book> shelf) {
        this.shelf = shelf;
    }

    public BookShelf() {
        this.shelf = new ArrayList<Book>();
    }

    public void addEmptyBook(){
        this.shelf.add(new Book());
    }

    public void addBook(String title, String author){
        this.shelf.add(new Book(title, author));
    }

    public void cOut(){
        if(this.shelf.isEmpty()) System.out.println("На полке нет книг!");
        else{
            for (Book b : this.shelf) {
                System.out.println(b.toString());
            }
        }
    }

    public void sortByAuthorName(){
        this.shelf.sort((a, b) -> a.getAuthor().compareTo(b.getAuthor()));
    }

    public void sortByBookName(){
        this.shelf.sort((a, b) -> a.getTitle().compareTo(b.getTitle()));
    }

    public ArrayList<Book> FilterByAuthorName(String authorNameToFilter) {
        var stream = shelf.stream();
        ArrayList<Book> result = (stream.filter(m -> m.getAuthor().equals(authorNameToFilter)).collect(Collectors.toCollection(ArrayList::new)));
        return result;
    }

    public int numberOfBooksByThisAuthor(String authorName) {
        var stream = shelf.stream();
        int counter = (int) stream.filter(m -> m.getAuthor().equals(authorName)).count();
        return counter;
    }

    public Map<String, List<Book>> groupByAuthor(){
        var stream = this.shelf.stream();
        Map<String, List<Book>> result = stream.collect(Collectors.groupingBy(Book::getAuthor));
        return result;
    }

    public void cOutMapByAuthor(Map<String, List<Book>> map){
        for (String key : map.keySet()) {
            System.out.println("Книги " + key + " Автора:");
            for (Book sh : map.get(key)) {
                System.out.println(sh.toString());
            }
            System.out.println();
        }
    }
    public void arrayListCOut(ArrayList<Book> books){
        if(books.isEmpty()) System.out.println("Нет книг");
        else {
            for (Book b : books) {
                System.out.println(b.toString());
            }
        }
    }
    public void writeJSON(String jsonFileName) throws IOException {
        FileWriter fr = new FileWriter(jsonFileName);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String jString = objectMapper.writeValueAsString(this.shelf);
        fr.write(jString);
        fr.close();
    }

    public void readJSON(String jsonFileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonBookArray = "";
        Scanner sc = new Scanner(new FileReader(jsonFileName));
        while (sc.hasNextLine()){
            jsonBookArray += sc.nextLine();
        }
        List<Book> list = objectMapper.readValue(jsonBookArray, new TypeReference<List<Book>>(){});
        this.shelf = new ArrayList<Book>(list);
    }
}
