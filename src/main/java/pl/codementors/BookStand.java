package pl.codementors;

/**
 * Created by sit0 on 02.06.17.
 */
public class BookStand {

    private Shelf[] shelves;


    public BookStand() {
        this.shelves = new Shelf[10];
    }


    public Shelf getShelf(int index) {
        return shelves[index];
    }

    public void addShelf(Shelf shelf, int index) {
        this.shelves[index] = shelf;
    }


    public void print(){
        for(int i = 0; i < shelves.length; i++){
            if (shelves[i] == null){
                //For tests
                //   System.out.println("PUSTE");
            }else {
                shelves[i].print();
            }

        }
    }
}
