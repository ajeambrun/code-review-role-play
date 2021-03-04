package movierental;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statement statement1 = (Statement) o;
        return statement.equals(statement1.statement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statement);
    }
}
