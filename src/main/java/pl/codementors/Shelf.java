package pl.codementors;

/**
 * Created by sit0 on 01.06.17.
 */
public class Shelf {

    private Book[] books;

    private int shelfSize;

    public Shelf(int shelfSize) {
        this.books = new Book[shelfSize];
        this.shelfSize = shelfSize;
    }

    public Shelf(Book[] books) {
        this.books = books;
    }

    public Book getBook(int index) {
        return books[index];
    }

    public void setBook(Book book, int index) {
        this.books[index] = book;
    }
//TODO Remove below
    public int length() {
        return shelfSize;
    }

    public void print() {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null){
                //For tests
                //   System.out.println("PUSTE");
            }else{
                books[i].print();
            }

        }
    }


}
