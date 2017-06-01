package pl.codementors;

import java.util.Scanner;

/**
 * Created by sit0 on 01.06.17.
 */
public class MainApp {
    public static void main(String[] args) {

        final int INITIAL_SIZE = 10;

        Scanner inputScanner = new Scanner(System.in);

        Book[] bookArr = new Book[10];

        System.out.println("MENU:\nWpisz D -> Dodaj Ksiązkę\nWpisz X -> Wyjdz z programu\nWpisz numer operacji");
        boolean runner = true;
        while(runner){


            switch (inputScanner.nextLine()){
                case "D":{
                    System.out.println("---Wpisujesz książkę---");
                    Book myBook = new Book();
                    System.out.println("Podaj tytuł książki:");
                    myBook.setTitle(inputScanner.nextLine());
                    System.out.println("Podaj autora:");
                    myBook.setAuthor(inputScanner.nextLine());
                    System.out.println("Podaj rok wydania");
                    myBook.setReleaseYear(inputScanner.nextInt());
                    System.out.println("Tytuł książki: " + myBook.getTitle() +"\nAutor: "
                            + myBook.getAuthor() + "\nRok wydania: "
                            + myBook.getReleaseYear() + "\nPodaj miejsce na półce(od 1 do 10)");
                    //TODO dodaj walidacje
                    bookArr[inputScanner.nextInt()-1] = myBook;
                    break;
                }
                case "X":{
                    runner = false;
                    break;
                }


                default: {
                    System.out.println("MENU:\nWpisz D -> Dodaj Ksiązkę\nWpisz X -> Wyjdz z programu\nWpisz numer operacji");
                }

            }
        }






        System.out.println("Test:" + bookArr[0].getTitle());
        System.out.println("Test:" + bookArr[1].getTitle());



    }
}
