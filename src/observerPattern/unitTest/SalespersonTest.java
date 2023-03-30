package observerPattern.unitTest;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;

import Product.Electronic;
import Product.Product;
import observerPattern.Salesperson;

public class SalespersonTest {

    @Test
    public void testUpdate() {
        Product product = new Electronic("Smartphone", 999.99, "14 pro max", 3);
        Salesperson salesperson = new Salesperson("John");

        // Ensure update method outputs correct message
        String expectedOutput = "John : Smartphone has been added to cart";
        assertEquals(expectedOutput, System.out.toString());
    }
}
