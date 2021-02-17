package movierental;

class Statement {
    String statement;
    double amount;
    int frequentRenterPoints;

    public Statement(String statement, double amount, int frequentRenterPoints) {
        this.statement = statement;
        this.amount = amount;
        this.frequentRenterPoints = frequentRenterPoints;
    }

    public void appendStatement(String statement) {
        this.statement += statement;
    }

    public void addAmount(double amount) {
        this.amount += amount;
    }

    public String getStatement() {
        return statement;
    }

    public double getAmount() {
        return amount;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    public void incrementRenterPoints() {
        frequentRenterPoints++;
    }
}
