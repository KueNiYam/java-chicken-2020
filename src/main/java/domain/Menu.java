package domain;

import java.util.Objects;

public class Menu {
    private final int number;
    private final String name;
    private final Category category;
    private final int price;

    public Menu(final int number, final String name, final Category category, final int price) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public double computePriceOfNumber(final OrderNumber orderNumber) {
        return price * orderNumber.getInt();
    }

    public boolean isNumber(final int number) {
        return this.number == number;
    }

    public boolean isChicken() {
        return category == Category.CHICKEN;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Menu menu = (Menu) o;
        return number == menu.number &&
                price == menu.price &&
                Objects.equals(name, menu.name) &&
                category == menu.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, category, price);
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }
}
