package domain;

import java.util.Objects;

public class Table {
    private final int number;

    public Table(final int number) {
        this.number = number;
    }

    public boolean isNumber(final int number) {
        return this.number == number;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Table table = (Table) o;
        return number == table.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
