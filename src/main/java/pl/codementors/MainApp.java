package pl.codementors;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


/**
 * Created by sit0 on 01.06.17.
 */
public class MainApp {


    public static void main(String[] args) {


        Library library = Library.readFromBinaryFile();

//        Library library = new Library();
//       library = library.readFromTxtFile();

        Scanner inputScanner = new Scanner(System.in);
        boolean runner = true;
        while (runner) {
            System.out.println("MENU:\nWpisz 1 -> Dodaj Ksiązkę\n" +
                    "Wpisz 2 -> Wypisz wybraną książkę\n" +
                    "Wpisz 3 -> Wypisz wszystkie książki\n" +
                    "Wpisz 0 -> Wyjdz z programu\nWpisz numer operacji");

            switch (inputScanner.nextLine()) {

                case "1": {
                    Library.addBook(library);
                    break;
                }
                case "2": {
                    Library.printOneBook(library);
                    break;
                }
                case "3": {
                    Library.print(library);
                    break;
                }
                case "0": {
                    runner = false;
                    break;
                }
                default: {
                    System.out.println("Nie ma takiej pozycji w MENU. Wpisz raz jeszcze");
                }

            }
        }
        Library.saveToBinaryFile(library);
        library.saveToTxtFile();
    }
}