package pl.codementors;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by sit0 on 01.06.17.
 */
public class Book implements Serializable {

    private String title;

    private Author author;

    private int releaseYear;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Book(String title, Author author, int releaseYear) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
    }

    public Book() {

    }

    public void print() {

        System.out.println("Tytuł: " + title);
        System.out.println("Imię i nazwisko autora: " + author.getName() + " " + author.getSurName());
        System.out.println("Pseudonim artystyczny: " + author.getStageName());
        System.out.println("Data wydania: " + releaseYear);
        System.out.println("-----------------");
    }
}
