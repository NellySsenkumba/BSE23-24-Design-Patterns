package Singleton;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import Product.*;
import observerPattern.Observer;
import observerPattern.Salesperson;

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
    public void testAddProductAddsProductToListwithSalessperson() {
        ProductCatalog test1 = ProductCatalog.getInstance();
        test1.detachAllObservers();
        Salesperson Ndagire = new Salesperson("Ndagire","ssenkumbanelson.sn@gmail.com");

        Product product = new Groceries("Tomatoes", 500, "RIpe", 7);

        List<Product> productList = test1.getAllProducts();
        List<Observer> observerList = test1.getAllObservers();

        // testing if the salesperson has been notified
        // obtaining notification from console
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        test1.attach(Ndagire);
        assertEquals(1, observerList.size());
        test1.addProduct(product);

        String consoleOutput = outputStream.toString();
        String expectedOutput = "Ndagire : Tomatoes has been added to cart\n";
        assertTrue(productList.contains(product)); // testing if product has been added to catalog

        assertEquals(expectedOutput, consoleOutput);// tests for the expected output of the console

    }

    @Test
    public void testAttach() {
        ProductCatalog pc = ProductCatalog.getInstance();
        Salesperson Mariam = new Salesperson("Mariam","ssenkumbanelson.sn@gmail.com");

        Product product = new Electronic("Laptop", 1999.99, "Macbook Pro", 5);

        pc.attach(Mariam);
        pc.addProduct(product);
        List<Observer> observerList = pc.getAllObservers();

        assertTrue(observerList.contains(Mariam));
    }

    @Test
    public void testDetach() {
        ProductCatalog pc = ProductCatalog.getInstance();
        Salesperson Mariam = new Salesperson("Mariam","ssenkumbanelson.sn@gmail.com");

        Product product = new Electronic("Laptop", 1999.99, "Macbook Pro", 5);

        pc.attach(Mariam);
        pc.addProduct(product);
        List<Observer> observerList = pc.getAllObservers();

        assertTrue(observerList.contains(Mariam));
        pc.detach(Mariam);
        assertTrue(!observerList.contains(Mariam));

    }

    @Test
    public void testGetAllProductsReturnsAllProducts() {
        ProductCatalog catlog = ProductCatalog.getInstance();
        catlog.detachAllProducts();
        List<Product> productList = catlog.getAllProducts();

        
        assertNotNull(productList);
        assertEquals(0, productList.size());
    }

    @Test
    public void testGetAllObserversReturnsAllObservers() {
        ProductCatalog cart = ProductCatalog.getInstance();
        cart.detachAllObservers();
        cart.attach(new Salesperson("Mariam","ssenkumbanelson.sn@gmail.com"));
        List<Observer> observerList = cart.getAllObservers();
        assertNotNull(observerList);
        assertEquals(1, observerList.size());
    }
}
