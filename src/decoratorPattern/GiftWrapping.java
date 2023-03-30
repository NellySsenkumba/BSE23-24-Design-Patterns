package decoratorPattern;

import Product.Product;

public class GiftWrapping extends ProductDecorator {

    public GiftWrapping(Product product) {
        super(product);
    }

    double wrap(double price){
        return price +2000.0;
    }
    @Override
    public double getPrice() {
        return wrap(product.getPrice());
    }
    
}
