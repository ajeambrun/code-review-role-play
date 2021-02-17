package movierental;

class FrequentRenterPoints {
    private final int points;

    private FrequentRenterPoints(int points) {
        this.points = points;
    }

    public FrequentRenterPoints increment() {
        return new FrequentRenterPoints(points + 1);
    }

    public static FrequentRenterPoints zero() {
        return new FrequentRenterPoints(0);
    }

    public String toString() {
        return Integer.toString(points);
    }
}
