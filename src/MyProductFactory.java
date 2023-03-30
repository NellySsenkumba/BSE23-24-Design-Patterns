
import Product.*;

public class MyProductFactory extends ProductFactory {
    @Override
    Product create(String category, String name, double price, String description, int quantity) {
        if (category.equals("electronic")) {
            return new Electronic(name, price, description, quantity);
        } else if (category.equals("groceries")) {
            return new Groceries(name, price, description, quantity);
        } else if (category.equals("clothing")) {
            return new Clothing(name, price, description, quantity);
        } else {
            throw new IllegalArgumentException("Invalid product category: " + category);
        }
    }

}
