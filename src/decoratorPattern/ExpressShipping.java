package decoratorPattern;

import Product.Product;

public class ExpressShipping extends ProductDecorator {

    public ExpressShipping(Product product) {
        super(product);
    }

    double ship(double price){
        return price +5000.0;
    }
    @Override
    public double getPrice() {
        return ship(product.getPrice());
    }
    
}
