package pl.codementors;

import java.util.Scanner;

/**
 * Created by sit0 on 01.06.17.
 */
public class MainApp {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Book myBook = new Book();

        System.out.println("Podaj tytuł książki");
        myBook.setTitle(inputScanner.nextLine());
        System.out.println("Podaj autora:");
        myBook.setAuthor(inputScanner.nextLine());
        System.out.println("Podaj rok wydania");
        myBook.setReleaseYear(inputScanner.nextInt());

        System.out.println("Tytuł książki: " + myBook.getTitle() +"\nAutor: " + myBook.getAuthor() + "\nRok wydania: " + myBook.getReleaseYear());



    }
}
