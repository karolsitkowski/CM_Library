package pl.codementors;

import java.io.*;
import java.util.Scanner;

/**
 * Created by sit0 on 02.06.17.
 */
public class Library implements Serializable {

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

    public void saveToTxtFile(){

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

    public Library readFromTxtFile() {
        Library library = new Library();

        try (FileReader fr = new FileReader("libmem.txt");
             Scanner scanner = new Scanner(fr);) {

            int numberOfBooks = scanner.nextInt();
            for(int i = 0; i< numberOfBooks;i++){

                int bookStandIndex = scanner.nextInt();
                int shelfIndex = scanner.nextInt();
                int bookIndex = scanner.nextInt();
                scanner.nextLine();
                Book book = new Book(scanner.nextLine(),scanner.nextLine(),scanner.nextInt());
                if(library.getBookStand(bookStandIndex) == null){

                    library.addBookStand(new BookStand(),bookStandIndex);
                }
                if(library.getBookStand(bookStandIndex).getShelf(shelfIndex) == null){

                    library.getBookStand(bookStandIndex).addShelf(new Shelf(),shelfIndex);
                }
                library.getBookStand(bookStandIndex).getShelf(shelfIndex).addBook(book,bookIndex);
            }
        } catch (IOException ex) {
            System.out.print("Błąd odczytu pliku: ");
            System.out.println(ex);
        }

        return library;
    }

    public void saveToBinaryFile(Library library){

        try(FileOutputStream fos = new FileOutputStream("libmem.bin");
            ObjectOutputStream ois = new ObjectOutputStream(fos);){

            ois.writeObject(library);

        }catch (IOException ex){
            System.out.println("Problem z zapisem binarnym");
            System.out.println(ex);
        }



    }

    public Library readFromBinaryFile(){
        Library library = new Library();
        try(FileInputStream fis = new FileInputStream("libmem.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);){

            library = (Library) ois.readObject();
        }catch (IOException | ClassNotFoundException ex){
            System.out.println("Problem z odczytem binarnym");
            System.out.println(ex);
        }
        return library;
    }
}
