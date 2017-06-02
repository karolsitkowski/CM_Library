package pl.codementors;

import java.util.Scanner;

/**
 * Created by sit0 on 01.06.17.
 */
public class MainApp {
    public static void main(String[] args) {


        Shelf[] bookStand = new Shelf[10];
        for (int i = 0; i < bookStand.length;i++){
            bookStand[i] = new Shelf(10);
        }

//Added books for tests
        Shelf shelf = bookStand[0];
        shelf.setBook(new Book("TestTitle","TestAuthor",1111),1);
        shelf.setBook(new Book("Test2Title","Test2Author",2222),3);
        shelf.setBook(new Book("Test3Title","Test3Author",3333),5);

        Scanner inputScanner = new Scanner(System.in);
        boolean runner = true;
        while(runner){
            System.out.println("MENU:\nWpisz 1 -> Dodaj Ksiązkę\nWpisz 2 -> Wypisz wybraną książkę\nWpisz 3 -> Wypisz wszystkie książki\nWpisz X -> Wyjdz z programu\nWpisz numer operacji");

            switch (inputScanner.nextLine()){
                case "1":{
                    System.out.println("---Wpisujesz książkę---");
                    Book myBook = new Book();
                    Shelf tmpShelf =new Shelf(10);
                    System.out.println("Podaj tytuł książki:");
                    myBook.setTitle(inputScanner.nextLine());
                    System.out.println("Podaj autora:");
                    myBook.setAuthor(inputScanner.nextLine());
                    System.out.println("Podaj rok wydania");
                    myBook.setReleaseYear(inputScanner.nextInt());
                    inputScanner.skip("\n");
                    System.out.println("Twoja książka to:");
                    myBook.printBook();
                    System.out.println("Podaj miejsce na półce(od 1 do " + (shelf.lenght()) + ")");
                    tmpShelf.setBook(myBook,inputScanner.nextInt());
                    inputScanner.skip("\n");
                    System.out.println("Podaj miejsce na regale(od 1 do 10)");
                    bookStand[inputScanner.nextInt()] = tmpShelf;
                    inputScanner.skip("\n");
                    System.out.println("Dziękujemy książka została dodana");
                    break;
                }
                case "2":{
                    System.out.println("Podaj regał");
                    int shelfIndex = inputScanner.nextInt();
                    inputScanner.skip("\n");
                    System.out.println("Podaj połkę");
                    int bookIndex = inputScanner.nextInt();
                    inputScanner.skip("\n");

                    if (bookStand[shelfIndex].getBook(bookIndex) == null){
                        System.out.println("Regał: " + shelfIndex + " Pułka: " + bookIndex + " Półka pusta");
                    }
                    else {
                        System.out.println("Regał: " + shelfIndex + " Pułka: " + bookIndex);
                        bookStand[shelfIndex].getBook(bookIndex).printBook();
                    }
                    break;
                }
                case "3":{
                    System.out.println("Wypisuje wszystkie książki: \n");
                    for (int j = 0; j < bookStand.length; j++) {
                        for (int i = 0; i < shelf.lenght(); i++) {
                            if (bookStand[j].getBook(i) == null) {
                                System.out.println("Regał: " + j + " Pułka: " + i + " TEST---> Puste miejsce");
                                System.out.println("------------------");
                            } else {
                                System.out.println("Regał: " + j + " Pułka: " + i);
                                bookStand[j].getBook(i).printBook();
                            }
                        }

                    }
                    break;
                }

                case "X":{
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