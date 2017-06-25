package pl.codementors;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sit0 on 01.06.17.
 */
public class Shelf implements Serializable {

    private List<Book> books;

    public Shelf() {
        this.books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getBook(int index) {
        return books.get(index);
    }

    public void addBook(Book book, int index) {
        this.books.add(index,book);
    }

    public void setBooks(List<Book> books){
        this.books = books;
    }


    public void print() {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i) == null) {
                //For tests
                //System.out.println("Pusty z Shelf");
                //System.out.println("-----------------");
            } else {
                books.get(i).print();
            }
        }
    }
}
