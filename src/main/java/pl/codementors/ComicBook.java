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
}
