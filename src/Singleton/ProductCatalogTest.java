package Singleton;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

import Product.*;

public class ProductCatalogTest {
    @Test
    public void testGetInstanceReturnsSingletonInstance() {
        ProductCatalog pc1 = ProductCatalog.getInstance();
        ProductCatalog pc2 = ProductCatalog.getInstance();
        assertSame(pc1, pc2);
    }

    @Test
    public void testAddProductAddsProductToList() {
        ProductCatalog pc = ProductCatalog.getInstance();
        Product product = new Electronic("Laptop", 1999.99, "Macbook Pro", 5);
        pc.addProduct(product);
        List<Product> productList = pc.getAllProducts();
        assertTrue(productList.contains(product));
    }

    @Test
    public void testGetAllProductsReturnsAllProducts() {
        ProductCatalog pc = ProductCatalog.getInstance();
        List<Product> productList = pc.getAllProducts();
        assertNotNull(productList);
        assertEquals(4, productList.size());
    }
}
