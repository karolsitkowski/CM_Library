package pl.codementors;

import java.util.Scanner;


/**
 * Created by sit0 on 01.06.17.
 */
public class MainApp {
    public static void main(String[] args) {

        //creating shelfs and bookstands
        BookStand[] bookStandArr = new BookStand[10];

        for (int i = 0; i < bookStandArr.length; i++) {
            bookStandArr[i] = new BookStand(10);
            for (int j = 0; j < 10; j++) {
                bookStandArr[i].addShelveToBookStand(new Shelf(10), j);
            }
        }

        //Added books for tests
        Shelf shelf = bookStandArr[0].getShelfFromBookstand(1);
        shelf.setBook(new Book("TestTitle", "TestAuthor", 1111), 1);
        shelf.setBook(new Book("Test2Title", "Test2Author", 2222), 3);
        shelf.setBook(new Book("Test3Title", "Test3Author", 3333), 5);

        Scanner inputScanner = new Scanner(System.in);
        boolean runner = true;
        while (runner) {
            System.out.println("MENU:\nWpisz 1 -> Dodaj Ksiązkę\nWpisz 2 -> Wypisz wybraną książkę\nWpisz 3 -> Wypisz wszystkie książki\nWpisz X -> Wyjdz z programu\nWpisz numer operacji");

            switch (inputScanner.nextLine()) {
                case "1": {
                    System.out.println("---Wpisujesz książkę---");
                    Book myBook = new Book();
                    Shelf tmpShelf = new Shelf(10);
                    System.out.println("Podaj tytuł książki:");
                    myBook.setTitle(inputScanner.nextLine());
                    System.out.println("Podaj autora:");
                    myBook.setAuthor(inputScanner.nextLine());
                    System.out.println("Podaj rok wydania");
                    myBook.setReleaseYear(inputScanner.nextInt());
                    inputScanner.skip("\n");
                    System.out.println("Twoja książka to:");
                    myBook.printBook();
                    System.out.println("Podaj rząd regału(od 1 do 10)");
                    int indexOfBookStandArr = inputScanner.nextInt();
                    inputScanner.skip("\n");
                    System.out.println("Podaj miejsce na regale(od 1 do 10)");
                    bookStandArr[indexOfBookStandArr].addShelveToBookStand(tmpShelf, inputScanner.nextInt());
                    inputScanner.skip("\n");
                    System.out.println("Podaj miejsce na półce(od 1 do 10)");
                    tmpShelf.setBook(myBook, inputScanner.nextInt());
                    inputScanner.skip("\n");
                    System.out.println("Dziękujemy książka została dodana");
                    break;
                }
                case "2": {
                    System.out.println("Podaj rząd regałów");
                    int bookStandsIndex = inputScanner.nextInt();
                    inputScanner.skip("\n");
                    System.out.println("Podaj regał");
                    int shelfIndex = inputScanner.nextInt();
                    inputScanner.skip("\n");
                    System.out.println("Podaj połkę");
                    int bookIndex = inputScanner.nextInt();
                    inputScanner.skip("\n");

                    if (bookStandArr[bookStandsIndex].getShelfFromBookstand(shelfIndex).getBook(bookIndex) == null) {
                        System.out.println("Rząd: " + bookStandsIndex + "Regał: " + shelfIndex + " Pułka: " + bookIndex + " Półka pusta");
                    } else {
                        System.out.println("Rząd: " + bookStandsIndex + "Regał: " + shelfIndex + " Pułka: " + bookIndex);
                        bookStandArr[bookStandsIndex].getShelfFromBookstand(shelfIndex).getBook(bookIndex).printBook();
                    }
                    break;
                }
                case "3": {
                    System.out.println("Wypisuje wszystkie książki: \n");
                    for (int k = 0; k < bookStandArr.length; k++) {
                        for (int j = 0; j < bookStandArr[k].lenght(); j++) {
                            for (int i = 0; i < 10; i++) {
                                if (bookStandArr[k].getShelfFromBookstand(j).getBook(i) == null) {
                                    System.out.println("Rząd: " + k + " Regał: " + j + " Pułka: " + i + " TEST---> Puste miejsce");
                                    System.out.println("------------------");
                                } else {
                                    System.out.println("Rząd: " + k + " Regał: " + j + " Pułka: " + i);
                                    bookStandArr[k].getShelfFromBookstand(j).getBook(i).printBook();
                                }
                            }

                        }

                    }


                    break;
                }

                case "X": {
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