package books;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BookShelf {
    private ArrayList<Book> Shelf;

    public BookShelf(Book param) {
        Shelf.add(param);
    }

    public BookShelf() {
        Shelf = new ArrayList<Book>();
    }

    public void getShelf(FileWriter fw) throws IOException {
        for (int i = 0; i < Shelf.size(); i++) {
            fw.write(Shelf.get(i).toString() + "\n");
        }
    }

    public void outShelf() {
        for (int i = 0; i < Shelf.size(); i++) {
            System.out.println(Shelf.get(i).toString());
        }
    }

    public ArrayList<Book> getShelf() {
        return Shelf;
    }

    public void InsertBook(Book to_insert) {
        Shelf.add(to_insert);
    }

    public void NameSort() {
        Collections.sort(Shelf);
    }

    public void AuthorSort() {
        Shelf.sort((Book lhs, Book rhs) -> {
            if (lhs.getAuthor().equals(rhs.getAuthor())) {
                return lhs.getName().compareTo(rhs.getName());
            } else return lhs.getAuthor().compareTo(rhs.getAuthor());
        });
    }

    public int AuthorBooks(String author_) {
        List<Book> books = Shelf.stream().filter(book -> book.getAuthor().equals(author_)).collect(Collectors.toList());
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
        return books.size();
    }

    public String binarySearch(Book to_search) {
        int index = Collections.binarySearch(Shelf, to_search);
        if (index > 0) return Shelf.get(index).toString();
        else return "No";
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < Shelf.size(); i++) {
            str.append(Shelf.get(i).toString() + "\n");
        }
        return str.toString();
    }
}
