package pl.codementors;

import java.util.Scanner;


/**
 * Created by sit0 on 01.06.17.
 */
public class MainApp {


    public static void main(String[] args) {

        Library library = new Library();
//        library = library.readFromTxtFile();
        library = library.readFromBinaryFile();

        Scanner inputScanner = new Scanner(System.in);
        boolean runner = true;
        while (runner) {
            System.out.println("MENU:\nWpisz 1 -> Dodaj Ksiązkę\n" +
                    "Wpisz 2 -> Wypisz wybraną książkę\n" +
                    "Wpisz 3 -> Wypisz wszystkie książki\n" +
                    "Wpisz 0 -> Wyjdz z programu\nWpisz numer operacji");
            switch (inputScanner.nextInt()) {

                case 1: {
                    inputScanner.skip("\n");
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
                    inputScanner.skip("\n");
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

                    library.saveToTxtFile();
                    break;
                }

                case 5: {

                    library = library.readFromTxtFile();
                    break;
                }

                case 6: {
                    library.saveToBinaryFile(library);
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
//        library.saveToTxtFile();
        library.saveToBinaryFile(library);
    }
}
//TODO dodaj walidacje