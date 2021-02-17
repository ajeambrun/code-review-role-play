package movierental;

import java.util.ArrayList;
import java.util.List;

class Rentals {
    private final List<Rental> rentals = new ArrayList<>();

    public void add(Rental rental) {
        rentals.add(rental);
    }

    public List<Rental> all() {
        return rentals;
    }
}
