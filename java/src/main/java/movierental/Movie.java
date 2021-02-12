package movierental;

/**
 * Class that hold a movie's data
 */
public class Movie {

    public static final int CHILDRENS = 2; // CHILDRENS movie category
    public static final int NEW_RELEASE = 1; // NEW_RELEASE movie category
    public static final int REGULAR = 0; // REGULAR movie category

    private String _title; //movie's title
    private int _priceCode; //movie's priceCode

    /**
     * Contructor
     * @param title
     * @param priceCode
     */
    public Movie(String title, int priceCode) {
        _title = title; //set the title
        _priceCode = priceCode; //set the price code
    }

    /**
     * get the movie renting price
     * @return
     */
    public int getPriceCode() {
        return _priceCode;
    }

    /**
     * set the movie renting price
     * @param arg
     */
    public void setPriceCode(int arg) {
        _priceCode = arg;
    }

    /**
     * get the movie's title
     * @return
     */
    public String getTitle() {
        return _title;
    }


}
