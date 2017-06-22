package pl.codementors;

/**
 * Created by sit0 on 10.06.17.
 */
public class ComicBook extends Book {

    //yyyy-MM
    private String releaseDate;

    private String publishingSeries;

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPublishingSeries() {
        return publishingSeries;
    }

    public void setPublishingSeries(String publishingSeries) {
        this.publishingSeries = publishingSeries;
    }
    @Override
    public void print() {

        System.out.println("Typ: " + getClass().getSimpleName());
        System.out.println("Tytuł: " + getTitle());
        System.out.println("Autorzy:");
        for (int i = 0; i < getAuthors().length; i++) {
            System.out.println("Imię i nazwisko autora " + (i + 1) + ": " + getAuthors()[i].getName() + " " + getAuthors()[i].getSurName());
            System.out.println("Pseudonim artystyczny: " + getAuthors()[i].getStageName());
        }
        System.out.println("Data wydania: " + releaseDate);
        System.out.println("Wydawnictwo: " + publishingSeries);
        System.out.println("Okładka: " + getCover().toString());
        System.out.println("-----------------");

    }
}
