package movierental;

/**
 * Class that hold rental's data
 */
public class Rental {

    private Movie _movie; // the movie
    private int _daysRented; // number of rented days

    /**
     * Constructor of the class
     * @param movie
     * @param daysRented
     */
    public Rental(Movie movie, int daysRented) {
        _movie = movie; //set the movie
        _daysRented = daysRented; //set the number of rented days
    }

    /**
     * get number of rented days
     * @return
     */
    public int getDaysRented() {
        return _daysRented;
    }

    /**
     * get the movie
     * @return
     */
    public Movie getMovie() {
        return _movie;
    }
}
