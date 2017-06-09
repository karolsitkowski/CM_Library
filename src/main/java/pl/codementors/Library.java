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

    public static void saveToBinaryFile(Library library){

        try(FileOutputStream fos = new FileOutputStream("libmem.bin");
            ObjectOutputStream ois = new ObjectOutputStream(fos);){

            ois.writeObject(library);
        }catch (IOException ex){
            System.out.println("Problem z zapisem binarnym");
            System.out.println(ex);
        }
    }

    public static Library readFromBinaryFile(){
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

    public static void addBook(Library library){
        Book setBook = new Book();
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("---Wpisujesz książkę---");
        System.out.println("Podaj tytuł książki:");
        setBook.setTitle(inputScanner.nextLine());
        System.out.println("Podaj autora:");
        setBook.setAuthor(inputScanner.nextLine());
        System.out.println("Podaj rok wydania");
        setBook.setReleaseYear(inputScanner.nextInt());
        inputScanner.skip("\n");
        System.out.println("Twoja książka to:");
        setBook.print();

        System.out.println("Podaj rząd regału(od 1 do 10)");
        int indexOfBookStand = inputScanner.nextInt();
        inputScanner.skip("\n");
        System.out.println("Podaj miejsce na regale(od 1 do 10)");
        int indexOfShelf = inputScanner.nextInt();
        inputScanner.skip("\n");
        System.out.println("Podaj miejsce na półce(od 1 do 10)");
        int indexOfBook = inputScanner.nextInt();
        inputScanner.skip("\n");

        if(library.getBookStand(indexOfBookStand) == null){
            library.addBookStand(new BookStand(),indexOfBookStand);
        }
        if(library.getBookStand(indexOfBookStand).getShelf(indexOfShelf) == null){
            library.getBookStand(indexOfBookStand).addShelf(new Shelf(),indexOfShelf);
        }
        library.getBookStand(indexOfBookStand).getShelf(indexOfShelf).addBook(setBook,indexOfBook);
    }

    public static void printOneBook(Library library){

        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Podaj rząd regałów");
        int bookStandsIndex = inputScanner.nextInt();
        System.out.println("Podaj regał");
        int shelfIndex = inputScanner.nextInt();
        System.out.println("Podaj połkę");
        int bookIndex = inputScanner.nextInt();

        if (library.getBookStand(bookStandsIndex).getShelf(shelfIndex).getBook(bookIndex) == null) {
            System.out.println("Rząd: " + bookStandsIndex + "Regał: " + shelfIndex + " Pułka: " + bookIndex + " Półka pusta");
        } else {
            System.out.println("Rząd: " + bookStandsIndex + "Regał: " + shelfIndex + " Pułka: " + bookIndex);
            library.getBookStand(bookStandsIndex).getShelf(shelfIndex).getBook(bookIndex).print();

        }
    }

    public static void print(Library library){

        for(int i = 0; i < 10;i++){
            if (library.getBookStand(i) == null){
                //For tests
                //System.out.println("Pusta z Liblary");
                //System.out.println("-----------------");
            }else {
                library.getBookStand(i).print();
            }
        }
    }
}
