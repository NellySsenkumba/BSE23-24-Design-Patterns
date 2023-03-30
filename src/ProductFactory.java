import Product.Product;

public abstract class ProductFactory {
    abstract Product create(String category, String name, double price, String description, int quantity);
}
