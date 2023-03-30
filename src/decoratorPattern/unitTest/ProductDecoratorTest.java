package decoratorPattern.unitTest;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Product.Clothing;
import Product.Product;
import decoratorPattern.ExpressShipping;
import decoratorPattern.GiftWrapping;

public class ProductDecoratorTest {

    @Test
    public void testGetPriceWithGiftWrapping() {
        // create a product to be decorated
        Product product = new Clothing("Jacket", 400000, "Leather", 5);
        // decorate the product with gift wrapping
        Product decoratedProduct = new GiftWrapping(product);
        // check if the price of the decorated product is correct
        assertEquals(402000.0, decoratedProduct.getPrice(), 0.001);
    }
    
    @Test
    public void testGetPriceWithExpressShippingAndGiftWrapping() {
        // create a product to be decorated
        Product product = new Clothing("Jacket", 400000, "Leather", 5);
        // decorate the product with gift wrapping and express shipping
        Product decoratedProduct = new ExpressShipping(new GiftWrapping(product));
        // check if the price of the decorated product is correct
        assertEquals(407000.0, decoratedProduct.getPrice(), 0.001);
    }

}
