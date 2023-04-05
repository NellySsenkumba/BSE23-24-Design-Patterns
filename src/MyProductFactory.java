
import Product.*;

public class MyProductFactory extends ProductFactory {
    @Override
     Product create(String category, String name, double price, String description, int quantity) {
        if (category.toLowerCase().contains("elect")) {
            return new Electronic(name, price, description, quantity);
        } else if (category.toLowerCase().contains("grocer")) {
            return new Groceries(name, price, description, quantity);
        } else if (category.toLowerCase().contains("cloth")) {
            return new Clothing(name, price, description, quantity);
        } else {
            throw new IllegalArgumentException("Invalid product category: " + category);
        }

    }

}
