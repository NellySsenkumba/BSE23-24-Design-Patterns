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
        ProductCatalog pc = ProductCatalog.getInstance();
        Salesperson Mariam = new Salesperson("Mariam");

        Product product = new Electronic("Laptop", 1999.99, "Macbook Pro", 5);

        List<Product> productList = pc.getAllProducts();

        // testing if the salesperson has been notified
        // obtaining notification from console
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        pc.attach(Mariam);
        pc.addProduct(product);

        String consoleOutput = outputStream.toString();
        String expectedOutput = "Mariam : Laptop has been added to cart\n";
        assertTrue(productList.contains(product)); // testing if product has been added to catalog

        assertEquals(expectedOutput, consoleOutput);

    }

    @Test
    public void testAttach() {
        ProductCatalog pc = ProductCatalog.getInstance();
        Salesperson Mariam = new Salesperson("Mariam");

        Product product = new Electronic("Laptop", 1999.99, "Macbook Pro", 5);

        pc.attach(Mariam);
        pc.addProduct(product);
        List<Observer> observerList = pc.getAllObservers();

        assertTrue(observerList.contains(Mariam));
    }

    @Test
    public void testDetach() {
        ProductCatalog pc = ProductCatalog.getInstance();
        Salesperson Mariam = new Salesperson("Mariam");

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
        ProductCatalog pc = ProductCatalog.getInstance();
        List<Product> productList = pc.getAllProducts();
        assertNotNull(productList);
        assertEquals(4, productList.size());
    }

    @Test
    public void testGetAllObserversReturnsAllObservers() {
        ProductCatalog pc = ProductCatalog.getInstance();
        pc.attach(new Salesperson("Mariam"));
        List<Observer> observerList = pc.getAllObservers();
        assertNotNull(observerList);
        assertEquals(1, observerList.size());
    }
}
