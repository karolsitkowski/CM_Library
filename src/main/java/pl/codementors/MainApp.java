package pl.codementors;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 * Created by sit0 on 01.06.17.
 */
public class MainApp {


    public static void main(String[] args) {



        //Added books for tests
        Library library = new Library();

        //Added books for tests
        Book testBook1 = new Book("TestTitle", "TestAuthor", 1111);
        Book testBook2 = new Book("Test2Title", "Test2Author", 2222);
        Book testBook3 = new Book("Test3Title", "Test3Author", 3333);
        Book testBook4 = new Book("Test4Title", "Test4Author", 4444);
        Book testBook5 = new Book("Test5Title", "Test5Author", 5555);
        Book testBook6 = new Book("Test6Title", "Test6Author", 6666);

        library.addBookStand(new BookStand(),0);
        library.getBookStand(0).addShelf(new Shelf(),0);
        library.getBookStand(0).getShelf(0).addBook(testBook1,1);
        library.getBookStand(0).getShelf(0).addBook(testBook2,3);
        library.getBookStand(0).getShelf(0).addBook(testBook3,5);

        library.addBookStand(new BookStand(),2);
        library.getBookStand(2).addShelf(new Shelf(),3);
        library.getBookStand(2).addShelf(new Shelf(),1);
        library.getBookStand(2).getShelf(1).addBook(testBook4,1);
        library.getBookStand(2).getShelf(1).addBook(testBook5,4);
        library.getBookStand(2).getShelf(3).addBook(testBook6,7);


        
        Scanner inputScanner = new Scanner(System.in);
        boolean runner = true;
        while (runner) {
            System.out.println("MENU:\nWpisz 1 -> Dodaj Ksiązkę\nWpisz 2 -> Wypisz wybraną książkę\nWpisz 3 -> Wypisz wszystkie książki\nWpisz 0 -> Wyjdz z programu\nWpisz numer operacji");

            switch (inputScanner.nextInt()) {
                case 1: {
                    Book setBook = new Book();
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


                    System.out.println("Dziękujemy książka została dodana");
                    break;
                }
                case 2: {
                    System.out.println("Podaj rząd regałów");
                    int bookStandsIndex = inputScanner.nextInt();
                    inputScanner.skip("\n");
                    System.out.println("Podaj regał");
                    int shelfIndex = inputScanner.nextInt();
                    inputScanner.skip("\n");
                    System.out.println("Podaj połkę");
                    int bookIndex = inputScanner.nextInt();
                    inputScanner.skip("\n");

                    if (library.getBookStand(bookStandsIndex).getShelf(shelfIndex).getBook(bookIndex) == null) {
                        System.out.println("Rząd: " + bookStandsIndex + "Regał: " + shelfIndex + " Pułka: " + bookIndex + " Półka pusta");
                    } else {
                        System.out.println("Rząd: " + bookStandsIndex + "Regał: " + shelfIndex + " Pułka: " + bookIndex);
                        library.getBookStand(bookStandsIndex).getShelf(shelfIndex).getBook(bookIndex).print();

                    }
                    break;
                }
                case 3: {

                    System.out.println("Wypisuje wszystkie książki: \n");

                    library.print();

                    break;
                }

                case 4: {

                    library.printToFile();
                    System.out.println("Książki zostały zapisane");

                    break;
                }

                case 5: {

                    library.readFromFile();
                    System.out.println("Książki zostały odczytane");
                    break;
                }

                case 0: {
                    runner = false;
                    break;
                }

                default: {
                    System.out.println("Default");
                }

            }
        }

    }
}
//TODO dodaj walidacje