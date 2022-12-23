package books;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Book implements Comparable <Book> {
    private String name;
    private String author;
    public String getName() {
        return this.name;
    }
    public String getAuthor(){
        return this.author;
    }
    public void setName(String name_) {
        this.name = name_;
    }
    public void setAuthor(String author_){
        this.author = author_;
    }
    public Book(String name_, String author_){
        this.name = name_;
        this.author = author_;
    }
    public Book(){
        this.name = "";
        this.author = "";
    }
    @Override public String toString(){
        return this.author + ", \"" + this.name + "\"";
    }
    @Override public boolean equals(Object b2){
        if (!(b2 instanceof Book)) return false;
        if (this.name == ((Book)b2).getName() && this.author == ((Book)b2).author)
            return true;
        return false;
    }
    @Override public int compareTo(Book b2){
        return this.name.compareTo(b2.name);
    }
}

class BookComparator implements Comparator<Book> {
    @Override public int compare(Book b1, Book b2) {
        return b1.getAuthor().compareTo(b2.getAuthor());
    }
}

