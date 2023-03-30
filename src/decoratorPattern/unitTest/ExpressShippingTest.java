package decoratorPattern.unitTest;

import org.junit.Test;
import static org.junit.Assert.*;
import Product.Clothing;
import Product.Product;
import decoratorPattern.ExpressShipping;

public class ExpressShippingTest {
    @Test
    public void testGetPrice() {
        Product product = new Clothing("Jacket", 100000.0, "Leather", 1);
        Product expressShipping = new ExpressShipping(product);
        double expectedPrice = 105000.0; // price with express shipping
        double actualPrice = expressShipping.getPrice();
        assertEquals(expectedPrice, actualPrice, 0.0);
    }
}
