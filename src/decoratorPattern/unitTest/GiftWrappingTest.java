package decoratorPattern.unitTest;

import Product.*;
import decoratorPattern.GiftWrapping;

import org.junit.Test;
import static org.junit.Assert.*;

public class GiftWrappingTest {
    
    @Test
    public void testGetPrice() {
        Product product = new Electronic("Laptop", 2550000.0, "HP Probook", 1);
        GiftWrapping giftWrapping = new GiftWrapping(product);
        double expectedPrice = product.getPrice() + 2000.0;
        assertEquals(expectedPrice, giftWrapping.getPrice(), 0.001);
    }
}
