package decoratorPattern;
import Product.Product;


class ProductDecorator implements Product{
    Product product;
    ProductDecorator(Product product){
        super();
        this.product=product;

    }

    @Override
    public String getName() {
        return product.getName();
    }

    @Override
    public int getQuantity() {
        return product.getQuantity();
    }

    @Override
    public String getDescription() {
        return product.getDescription();
    }

    @Override
    public double getPrice() {
        return product.getPrice();
    }

}
