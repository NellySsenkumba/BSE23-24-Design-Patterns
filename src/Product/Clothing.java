package Product;

import Singleton.ProductCatalog;

public class Clothing extends Product {

    public Clothing(String name, double price, String description, int quantity) {

        this.setName(name);
        this.setPrice(price);
        this.setDescription(description);
        this.setQuantity(quantity);
        updateDescription();

    }

    @Override
    public void updateDescription() {
        this.setDescription(this.getDescription() + ", clothing");
    }
    @Override
    public void update(Product product,ProductCatalog cart) {
    
        cart.addProduct(product);
    }

}
