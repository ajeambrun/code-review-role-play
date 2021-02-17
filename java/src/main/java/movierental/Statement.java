package movierental;

class Statement {
    private final String statement;

    private Statement(String statement) {
        this.statement = statement;
    }

    public Statement append(String toAppend) {
        return new Statement(this.statement + toAppend);
    }

    public String toString() {
        return statement;
    }

    public static Statement empty() {
        return new Statement("");
    }
}
