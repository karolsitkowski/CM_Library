package pl.codementors;

/**
 * Created by sit0 on 01.06.17.
 */
public class Shelf {

    private Book[] books;

    public Shelf(int shelfSize) {
        this.books = new Book[shelfSize];
    }

    public Shelf(Book[] books) {
        this.books = books;
    }

    public Book getBook(int index){
        return books[index];
    }

    public void setBook(Book book,int index){
        this.books[index] = book;
    }




}
