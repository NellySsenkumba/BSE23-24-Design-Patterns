package decoratorPattern;

import Product.Product;

abstract class ProductDecorator extends Product {
    Product product;

    ProductDecorator(Product product) {
        super();
        this.product = product;
        this.setName(product.getName());
        this.setDescription(product.getDescription());
        this.setQuantity(product.getQuantity());
        this.setPrice(product.getPrice());

    }

}
