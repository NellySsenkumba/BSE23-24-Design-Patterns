package barcodeScanner;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Product.Product;
import productFactory.MyProductFactory;

public class BarcodeScannerTest {

    private BarcodeScanner barcodeScanner;
    private Product product1, product2;

    @Before
    public void setUp() {
        barcodeScanner = BarcodeScanner.getInstance();
        product1 = new MyProductFactory().create("CLOTHINGS", "Hijab", 50000, "white", 59, "236645875");
        product2 = new MyProductFactory().create("Electronic", "Television", 500000, "Hisense 32 inch", 30,
                "123456789");

    }

    @Test
    public void testGetInstance() {
        assertNotNull(barcodeScanner);
    }

    @Test
    public void testAttach() {
        barcodeScanner.detachAllProducts();
        barcodeScanner.attach(product1);
        barcodeScanner.attach(product2);
        List<Product> productList = barcodeScanner.getAllProducts();
        assertEquals(2, productList.size());
        assertTrue(productList.contains(product1));
        assertTrue(productList.contains(product2));
    }

    @Test
    public void testDetach() {
        barcodeScanner.detachAllProducts();
        barcodeScanner.attach(product1);
        barcodeScanner.attach(product2);
        barcodeScanner.detach(product1);
        List<Product> productList = barcodeScanner.getAllProducts();
        assertEquals(1, productList.size());
        assertFalse(productList.contains(product1));
        assertTrue(productList.contains(product2));
    }

    @Test
    public void testScanProduct() {
        barcodeScanner.attach(product1);
        barcodeScanner.attach(product2);
        
        barcodeScanner.scanProduct("236645875");
        assertEquals(50000, product1.getPrice(), 0.001);
        barcodeScanner.scanProduct("123456789");
        assertEquals(500000, product2.getPrice(), 0.001);
    }

    @Test
    public void testGetAllProducts() {
        barcodeScanner.detachAllProducts();
        barcodeScanner.attach(product1);
        barcodeScanner.attach(product2);
        List<Product> productList = barcodeScanner.getAllProducts();
        assertEquals(2, productList.size());
        assertTrue(productList.contains(product1));
        assertTrue(productList.contains(product2));
    }

    @Test
    public void testDetachAllProducts() {
        barcodeScanner.attach(product1);
        barcodeScanner.attach(product2);
        barcodeScanner.detachAllProducts();
        List<Product> productList = barcodeScanner.getAllProducts();
        assertEquals(0, productList.size());
    }

}
