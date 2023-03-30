package observerPattern.unitTest;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import Product.Electronic;
import Product.Product;
import observerPattern.Salesperson;

public class SalespersonTest {

    @Test
    public void testUpdate() {
        Product product = new Electronic("Smartphone", 999.99, "14 pro max", 3);
        Salesperson Mariam = new Salesperson("Mariam");

        // Getting output from console
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        Mariam.update(product);
        String consoleOutput = outputStream.toString();
        // Ensure update method outputs correct message
        String expectedOutput = "Mariam : Smartphone has been added to cart\n";
        assertEquals(expectedOutput, consoleOutput);
    }
}
