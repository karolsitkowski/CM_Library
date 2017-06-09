package pl.codementors;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by sit0 on 01.06.17.
 */
public class Shelf implements Serializable {

    private Book[] books;

    public Shelf() {
        this.books = new Book[10];
    }

    public Book getBook(int index) {
        return books[index];
    }

    public void addBook(Book book, int index) {
        this.books[index] = book;
    }


    public void print() {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                //For tests
                //System.out.println("Pusty z Shelf");
                //System.out.println("-----------------");
            } else {
                books[i].print();
            }
        }
    }
}
