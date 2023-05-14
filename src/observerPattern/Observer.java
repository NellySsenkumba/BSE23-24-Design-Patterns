package observerPattern;

import Product.Product;

public interface Observer {
    void update(Product product);
}