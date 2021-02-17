package movierental;

class Amount {
    private final double amount;

    private Amount(double amount) {
        this.amount = amount;
    }

    public Amount add(Amount addedAmount) {
        return of(this.amount + addedAmount.amount);
    }

    @Override
    public String toString() {
        return Double.toString(amount);
    }

    public static Amount of(double amount) {
        return new Amount(amount);
    }

    public static Amount zero() {
        return of(0.);
    }
}
