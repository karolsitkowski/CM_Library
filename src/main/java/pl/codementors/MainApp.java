package pl.codementors;

import java.util.Scanner;

/**
 * Created by sit0 on 01.06.17.
 */
public class MainApp {
    public static void main(String[] args) {

        final int INITIAL_SIZE = 10;

        Scanner inputScanner = new Scanner(System.in);

        Book[] bookArr = new Book[INITIAL_SIZE];

        //added books for quick tests
        bookArr[1] = new Book("TestTitle","TestAuthor",1111);
        bookArr[3] = new Book("Test2Title","Test2Author",2222);
        bookArr[5] = new Book("Test3Title","Test3Author",3333);


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
                    bookArr[inputScanner.nextInt()-1] = myBook;
                    inputScanner.skip("\n");
                    break;
                }
                case "2":{

                    System.out.println("Z której półki książkę");
                    int index = inputScanner.nextInt();

                    if (bookArr[index-1] == null){
                        System.out.println("Półka pusta");
                    }
                    else {
                        bookArr[index-1].printBook();
                    }

                    inputScanner.skip("\n");
                    break;

                }
                case "3":{
                    System.out.println("Wypisuje wszystkie książki: \n");
                    for(int i = 0; i < bookArr.length; i++){
                        if(bookArr[i] == null){
                        }
                        else {
                            bookArr[i].printBook();
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






//        System.out.println("Test:" + bookArr[0].getTitle());
//        System.out.println("Test:" + bookArr[1].getTitle());



    }
}
