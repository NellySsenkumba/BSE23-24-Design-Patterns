package decoratorPattern;

import Product.Product;
import Singleton.ProductCatalog;

public class GiftWrapping extends ProductDecorator {

    public GiftWrapping(Product product) {
        super(product);
        updateDescription();
        this.setPrice(wrap(product.getPrice()));
    }

    double wrap(double price) {
        return price + 2000.0;
    }


    @Override
    public void updateDescription() {
        this.setDescription(product.getDescription() + ", gift_wrapped");
    }

    @Override
    public void update(Product product,ProductCatalog cart) {
    
        cart.addProduct(product);
    }
}
