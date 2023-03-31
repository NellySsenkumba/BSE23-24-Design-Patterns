package Product;

public class Clothing implements Product {
    private String name;

    private double price;
    private int quantity;

    private String description;

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public Clothing(String name, double price, String description, int quantity) {
        this.name = name;

        this.price = price;
        this.description = description;
        this.quantity = quantity;

    }

    @Override
    public String getName() {

        return name;
    }

    @Override
    public double getPrice() {

        return price;
    }

}
