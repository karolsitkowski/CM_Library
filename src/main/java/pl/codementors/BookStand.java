package pl.codementors;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by sit0 on 02.06.17.
 */
public class BookStand implements Serializable {

    private Shelf[] shelves;


    public BookStand(int size) {
        this.shelves = new Shelf[size];
    }


    public Shelf getShelf(int index) {
        return shelves[index];
    }

    public Shelf[] getShelves() {
        return shelves;
    }

    public void setShelves(Shelf[] shelves) {
        this.shelves = shelves;
    }

    public void addShelf(Shelf shelf, int index) {
        this.shelves[index] = shelf;
    }


    public void print(){
        for(int i = 0; i < shelves.length; i++){
            if (shelves[i] == null){
                //For tests
                //System.out.println("Pusty z Bookstand");
                //System.out.println("-----------------");
            }else {
                shelves[i].print();
            }

        }
    }
}
