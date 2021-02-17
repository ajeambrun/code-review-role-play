package movierental;
import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final Name name;
    private final Rentals rentals = new Rentals();

    public Customer(String name) {
        this.name = new Name(name);
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name.getName();
    }

    public String statement() {
        Amount totalAmount = Amount.zero();
        FrequentRenterPoints frequentRenterPoints = FrequentRenterPoints.zero();
        Statement result = Statement.empty();
        result = result.append("Rental Record for " + getName() + "\n");

        for (Rental each: rentals.all()) {
            Amount thisAmount = Amount.zero();

            //determine amounts for each line
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR -> {
                    thisAmount = thisAmount.add(Amount.of(2));
                    if (each.getDaysRented() > 2) {
                        final var addedAmount = Amount.of((each.getDaysRented() - 2) * 1.5);
                        thisAmount = thisAmount.add(addedAmount);
                    }
                }
                case Movie.NEW_RELEASE -> {
                    final var newReleaseAmount = Amount.of(each.getDaysRented() * 3);
                    thisAmount = thisAmount.add(newReleaseAmount);
                }
                case Movie.CHILDRENS -> {
                    thisAmount = thisAmount.add(Amount.of(1.5));
                    if (each.getDaysRented() > 3) {
                        final var childrenAmount = Amount.of((each.getDaysRented() - 3) * 1.5);
                        thisAmount = thisAmount.add(childrenAmount);
                    }
                }
            }

            // add frequent renter points
            frequentRenterPoints = frequentRenterPoints.increment();
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenterPoints = frequentRenterPoints.increment();

            // show figures for this rental
            result = result.append("\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n");
            totalAmount = totalAmount.add(thisAmount);
        }

        // add footer lines
        result = result.append("Amount owed is " + totalAmount + "\n");
        result = result.append("You earned " + frequentRenterPoints + " frequent renter points");

        return result.toString();
    }
}
