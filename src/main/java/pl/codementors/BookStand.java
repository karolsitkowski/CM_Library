package pl.codementors;

/**
 * Created by sit0 on 02.06.17.
 */
public class BookStand {

    private Shelf[] bookStand;


    public BookStand(int size) {
        this.bookStand = new Shelf[size];
    }

    public BookStand() {
    }

    public Shelf getShelf(int index) {
        return bookStand[index];
    }

    public void addShelve(Shelf shelf, int index) {
        this.bookStand[index] = shelf;
    }

    public int length() {
        return bookStand.length;
    }

    public void print(){
        for(int i = 0; i < bookStand.length;i++){
            if (bookStand[i] == null){
                //For tests
                //   System.out.println("PUSTE");
            }else {
                bookStand[i].print();
            }

        }
    }
}
