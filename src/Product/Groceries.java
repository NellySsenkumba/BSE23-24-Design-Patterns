package Product;

import Singleton.ProductCatalog;

public class Groceries extends Product {

    public Groceries(String name, double price, String description, int quantity) {
        this.setName(name);
        this.setPrice(price);
        this.setDescription(description);
        this.setQuantity(quantity);
        updateDescription();
    }

    @Override
    public void updateDescription() {
        this.setDescription(this.getDescription() + ", groceries");
    }

    @Override
    public void update(Product product,ProductCatalog cart) {
    
        cart.addProduct(product);
    }

}
