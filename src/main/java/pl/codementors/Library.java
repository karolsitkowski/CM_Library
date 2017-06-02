package pl.codementors;

/**
 * Created by sit0 on 02.06.17.
 */
public class Library {

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

    public void print(){
        for(int i = 0; i < bookStands.length;i++){
            if (bookStands[i] == null){
                //For tests
                //   System.out.println("PUSTE");
            }else {
                bookStands[i].print();
            }

        }
    }



}
