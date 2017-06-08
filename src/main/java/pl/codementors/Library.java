package pl.codementors;

import java.io.*;
import java.util.Scanner;

/**
 * Created by sit0 on 02.06.17.
 */
public class Library {

    private BookStand[] bookStands;


    public Library() {
        this.bookStands = new BookStand[10];
    }

    public BookStand getBookStand(int index) {
        return bookStands[index];
    }

    public void addBookStand(BookStand bookStand, int index) {
        this.bookStands[index] = bookStand;
    }

    public void print(){
        for(int i = 0; i < bookStands.length;i++){
            if (bookStands[i] == null){
                //For tests
                //System.out.println("Pusta z Liblary");
                //System.out.println("-----------------");
            }else {
                bookStands[i].print();
            }

        }
    }

    public void printToFile(){

        try(FileWriter fw = new FileWriter("libmem.txt");
            BufferedWriter stream = new BufferedWriter(fw);){
            int bookCounter = 0;
            for (int i = 0; i < 10; i++) {
                if (bookStands[i] == null){
                }else{
                    for (int j = 0; j < 10; j++) {
                        if (bookStands[i].getShelf(j) == null) {
                        } else {
                            for (int k = 0; k < 10; k++) {
                                if (bookStands[i].getShelf(j).getBook(k) == null) {
                                }
                                else {
                                    bookCounter++;
                                }
                            }
                        }
                    }
                }
            }
            stream.write(bookCounter + "\n");
            for (int i = 0; i < 10; i++) {
                if (bookStands[i] == null){
                }else{
                    for (int j = 0; j < 10; j++) {
                        if (bookStands[i].getShelf(j) == null) {
                        } else {
                            for (int k = 0; k < 10; k++) {
                                if (bookStands[i].getShelf(j).getBook(k) == null) {
                                }
                                else {
                                    stream.write("" + i + " " + j + " " + k + "\n");
                                    stream.write(bookStands[i].getShelf(j).getBook(k).getTitle() + "\n");
                                    stream.write(bookStands[i].getShelf(j).getBook(k).getAuthor() + "\n");
                                    stream.write(bookStands[i].getShelf(j).getBook(k).getReleaseYear() + "\n");
                                }
                            }
                        }
                    }
                }
            }
        }catch (IOException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void readFromFile() {
        try (FileReader fr = new FileReader("libmem.txt");
             Scanner scanner = new Scanner(fr);) {

//            bookStands[i].addBookStand(new BookStand(),scanner.nextInt());




        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }

    }


}
