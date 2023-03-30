
import org.junit.Test;
import static org.junit.Assert.*;
import Product.*;

public class ProductFactoryTest {
    @Test
    public void testCreateElectronic() {
        MyProductFactory factory = new MyProductFactory();
        Product product = factory.create("electronic", "Phone", 3400000, "iphone 14 pro max", 8);
        assertEquals("Phone", product.getName());
        assertEquals(3400000, product.getPrice(), 0.001);
        assertEquals("iphone 14 pro max", product.getDescription());
        assertEquals(8, product.getQuantity());
    }

    @Test
    public void testCreateClothing() {
        MyProductFactory factory = new MyProductFactory();
        Product product = factory.create("clothing", "Jacket", 40000, "Leather", 5);
        assertEquals("Jacket", product.getName());
        assertEquals(40000, product.getPrice(), 0.001);
        assertEquals("Leather", product.getDescription());
        assertEquals(5, product.getQuantity());
    }

    @Test
    public void testCreateGroceries() {
        MyProductFactory factory = new MyProductFactory();
        Product product = factory.create("groceries", "Tomatoes", 500, "Ripe large", 20);
        assertEquals("Tomatoes", product.getName());
        assertEquals(500, product.getPrice(), 0.001);
        assertEquals("Ripe large", product.getDescription());
        assertEquals(20, product.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidProductType() {
        MyProductFactory factory = new MyProductFactory();
        Product product = factory.create("InvalidType", "InvalidName", 0.0, "", 0);

    }

}