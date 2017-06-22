package pl.codementors;

import java.io.Serializable;

/**
 * Created by sit0 on 01.06.17.
 */
public class Book implements Serializable {

    private String title;

    private Author[] authors;

    private int releaseYear;

    public enum Cover {
        HARD,
        SOFT,
        INTEGRATED;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public Author getAuthor(int i){
        return authors[i];
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Book(String title, Author[] authors, int releaseYear) {
        this.title = title;
        this.authors = authors;
        this.releaseYear = releaseYear;
    }

    public Book(int index) {
        this.authors = new Author[index];
    }

    public Book() {

    }

    public void print() {

        System.out.println("Typ: " + getClass().getSimpleName());
        System.out.println("Tytuł: " + title);
        System.out.println("Autorzy:");
        for (int i = 0; i < authors.length; i++) {
            System.out.println("Imię i nazwisko autora " + (i + 1) + ": " + authors[i].getName() + " " + authors[i].getSurName());
            System.out.println("Pseudonim artystyczny: " + authors[i].getStageName());
        }
        System.out.println("Data wydania: " + releaseYear);
        System.out.println("-----------------");
    }
}
