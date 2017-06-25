package pl.codementors;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sit0 on 02.06.17.
 */
public class BookStand implements Serializable {

    private List<Shelf> shelves;


    public BookStand() {
        this.shelves = new ArrayList<>();
    }


    public Shelf getShelf(int index) {
        return shelves.get(index);
    }

    public List<Shelf> getShelves() {
        return shelves;
    }

    public void setShelves(List<Shelf> shelves) {
        this.shelves = shelves;
    }

    public void addShelf(Shelf shelf, int index) {
        this.shelves.add(index,shelf);
    }


    public void print(){
        for(int i = 0; i < shelves.size(); i++){
            if (shelves.get(i) == null){
                //For tests
                //System.out.println("Pusty z Bookstand");
                //System.out.println("-----------------");
            }else {
                shelves.get(i).print();
            }

        }
    }
}
