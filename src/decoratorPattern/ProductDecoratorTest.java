package decoratorPattern;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import Product.Clothing;
import Product.Product;

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
    public void testGetPriceWithExpressShipping() {
        Product product = new Clothing("Jacket", 100000.0, "Leather", 1);
        Product expressShipping = new ExpressShipping(product);
        double expectedPrice = 105000.0; // price with express shipping
        double actualPrice = expressShipping.getPrice();
        assertEquals(expectedPrice, actualPrice, 0.0);
    }

    @Test
    public void testGetPriceWithExpressShippingAndGiftWrapping() {
        Product product = new Clothing("Jacket", 400000, "Leather", 5);
        Product decoratedProduct = new ExpressShipping(new GiftWrapping(product));
        assertEquals(407000.0, decoratedProduct.getPrice(), 0.001);
    }

}
