package pl.codementors;

/**
 * Created by sit0 on 01.06.17.
 */
public class Book {

    private String title;
    private String author;
    private int releaseYear;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Book(String title, String author, int releaseYear) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
    }

    public Book(){

    }

    public void printBook(){
        System.out.println("Tytuł: " + title);
        System.out.println("Autor: " + author);
        System.out.println("Data wydania" + releaseYear);
        System.out.println("-----------------");
    }


}
