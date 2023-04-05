package decoratorPattern;

import Product.Product;
import Singleton.ProductCatalog;

public class ExpressShipping extends ProductDecorator {

    public ExpressShipping(Product product) {
        super(product);
        updateDescription();
        this.setPrice(ship(product.getPrice()));
    }

    double ship(double price) {
        return price + 5000.0;
    }

    @Override
    public void updateDescription() {
        this.setDescription(product.getDescription() + ", express_shipped");
    }

    @Override
    public void update(Product product, ProductCatalog cart) {

        cart.addProduct(product);
    }

}
