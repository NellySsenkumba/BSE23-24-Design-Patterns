package decoratorPattern;

import Product.Product;

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

}
