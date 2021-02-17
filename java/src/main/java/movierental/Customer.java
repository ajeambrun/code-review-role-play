package movierental;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

//I put very explicit names on this because the newbies of the squad are unable to read correctly code
public class Customer {

    private String nameOfCustomer;
    private List<Rental> customerRentals = new ArrayList<>();

    public Customer(String nameOfCustomer) {
        this.nameOfCustomer = nameOfCustomer;
    }

    public void addRentalToCustomerRentalList(Rental rental) {
        customerRentals.add(rental);
    }

    public String getNameOfCustomer() {
        return nameOfCustomer;
    }


    // This method should be extracted in the Statement clazz but no-one in the team agreed
    public String generateCustomerStatementString() {

        Statement statement = new Statement("Rental Record for " + getNameOfCustomer() + "\n", 0, 0);

        Consumer<Rental> updateOfCurrentStatement = (Rental rental) -> rentalBiFunction.apply(statement, rental); // If you don't understand this you should go back to school
        customerRentals.forEach(updateOfCurrentStatement);

        statement.appendStatement("Amount owed is " + statement.getAmount() + "\n");
        statement.appendStatement("You earned " + statement.getFrequentRenterPoints() + " frequent renter points");

        return statement.getStatement();
    }

    //DONT TOUCH THIS : it is obviously the best thing to do
    private final BiFunction<Statement, Rental, Statement> rentalBiFunction = (statement, rental) -> {
        updateStatement(statement, rental);
        return statement;
    };

    //TODO : job for newbies : introduce Strategy pattern (if you know what i am talking about)
    private void updateStatement(Statement statement, Rental rental) {
        double thisAmount = 0;

        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR -> {
                thisAmount += 2;
                if (rental.getDaysRented() > 2)
                    thisAmount += (rental.getDaysRented() - 2) * 1.5;
            }
            case Movie.NEW_RELEASE -> thisAmount += rental.getDaysRented() * 3;
            case Movie.CHILDRENS -> {
                thisAmount += 1.5;
                if (rental.getDaysRented() > 3)
                    thisAmount += (rental.getDaysRented() - 3) * 1.5;
            }
        }

        statement.incrementRenterPoints();
        if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
            statement.incrementRenterPoints();

        statement.appendStatement( "\t" + rental.getMovie().getTitle() + "\t" + thisAmount + "\n");
        statement.addAmount(thisAmount);
    }
}
