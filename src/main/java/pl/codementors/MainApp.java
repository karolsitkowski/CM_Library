package pl.codementors;

import java.util.Scanner;

/**
 * Created by sit0 on 01.06.17.
 */
public class MainApp {
    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);

//        added for future quick tests
//        Book[] bookArrTest = new Book[INITIAL_SIZE];
//        bookArrTest[1] = new Book("TestTitle","TestAuthor",1111);
//        bookArrTest[3] = new Book("Test2Title","Test2Author",2222);
//        bookArrTest[5] = new Book("Test3Title","Test3Author",3333);
//        Shelf bookArr = new Shelf(bookArrTest);


        Shelf bookArr = new Shelf(10);

        boolean runner = true;
        while(runner){
            System.out.println("MENU:\nWpisz 1 -> Dodaj Ksiązkę\nWpisz 2 -> Wypisz wybraną książkę\nWpisz 3 -> Wypisz wszystkie książki\nWpisz X -> Wyjdz z programu\nWpisz numer operacji");


            switch (inputScanner.nextLine()){
                //TODO scanner.skip("/n")
                case "1":{
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
                    bookArr.setBook(myBook,inputScanner.nextInt()-1);
                    inputScanner.skip("\n");
                    break;
                }
                case "2":{

                    System.out.println("Z której półki książkę");
                    int index = inputScanner.nextInt();

                    if (bookArr.getBook(index-1) == null){
                        System.out.println("Półka pusta");
                    }
                    else {
                        bookArr.getBook(index-1).printBook();
                    }

                    inputScanner.skip("\n");
                    break;

                }
                case "3":{
                    System.out.println("Wypisuje wszystkie książki: \n");
                    for(int i = 0; i < bookArr.lenght(); i++){
                        if(bookArr.getBook(i) == null){
                        }
                        else {
                            bookArr.getBook(i).printBook();
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
