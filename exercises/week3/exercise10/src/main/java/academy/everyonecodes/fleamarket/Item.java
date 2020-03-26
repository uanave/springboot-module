package academy.everyonecodes.fleamarket;

public class Item {
    private String name;
    private double price;

    public Item() {
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    void setPrice(double price) {
        this.price = price;
    }
}
