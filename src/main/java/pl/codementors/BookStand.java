package pl.codementors;

/**
 * Created by sit0 on 02.06.17.
 */
public class BookStand {

    private Shelf[] bookStand;
    private int bookStandSize;

    public BookStand(int size) {
        this.bookStand = new Shelf[size];
    }

    public BookStand(){
    }

    public Shelf getShelfFromBookstand(int index) {
        return bookStand[index];
    }

    public void addShelveToBookStand(Shelf shelf,int index) {
        this.bookStand[index] = shelf;
    }

    public int lenght(){
        return bookStand.length;
    }
}
