package Product;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import Singleton.ProductCatalog;
import productFactory.MyProductFactory;

public class ProductTest {
    @Test
    public void testUpdate() {
        ProductCatalog cart = ProductCatalog.getInstance();
        Product product1 = new MyProductFactory().create("CLOTHINGS", "Hijab", 50000, "white", 59, "236645875");
        Product product2 = new MyProductFactory().create("Electronic", "Television", 500000, "Hisense 32 inch", 30,
                "123456789");

        product1.update("236645875");
        assertEquals(1, cart.getAllProducts().size());
        product2.update("123456789");
        assertEquals(2, cart.getAllProducts().size());
        product2.update("00000");
        assertEquals(2, cart.getAllProducts().size());
    }
}
