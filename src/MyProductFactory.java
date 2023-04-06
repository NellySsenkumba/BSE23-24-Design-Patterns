
import java.util.Random;

import Product.*;
import barcodeScanner.BarcodeScanner;

public class MyProductFactory extends ProductFactory {

    @Override
    Product create(String category, String name, double price, String description, int quantity, String barcode) {
        BarcodeScanner barcodeScaner = BarcodeScanner.getInstance();
        Product pdt;

        if (category.toLowerCase().contains("elect")) {
            pdt = new Electronic(name, price, description, quantity, barcode);
            barcodeScaner.attach(pdt);
            return pdt;
        } else if (category.toLowerCase().contains("grocer")) {
            pdt = new Groceries(name, price, description, quantity, barcode);
            barcodeScaner.attach(pdt);
            return pdt;
        } else if (category.toLowerCase().contains("cloth")) {
            pdt = new Clothing(name, price, description, quantity, barcode);
            barcodeScaner.attach(pdt);
            return pdt;
        } else {
            throw new IllegalArgumentException("Invalid product category: " + category);
        }

    }

}
