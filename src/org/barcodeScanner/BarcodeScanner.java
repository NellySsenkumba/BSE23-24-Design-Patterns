package org.barcodeScanner;

import java.util.HashMap;
import java.util.Map;

import org.Product.Product;
import org.productFactory.MyProductFactory;

public class BarcodeScanner implements BarcodeSubject {
    private Map<String, Product> invetoryList = new HashMap<>(); // inventory

    public static BarcodeScanner instance = null;

    private BarcodeScanner() {

    }

    public static BarcodeScanner getInstance() {
        if (instance == null) {
            instance = new BarcodeScanner();

            // initial products in inventory
            new MyProductFactory().create("CLOTHINGS", "Hijab", 50000, "white", 59, "1");
            new MyProductFactory().create("Groceries", "Tomato", 500, "fresh", 50, "2");
            new MyProductFactory().create("Electronic", "Television", 500000, "Hisense 32 inch", 20, "3");
            new MyProductFactory().create("Electronic", "Fridge", 3000000, "hisense", 8, "4");
            new MyProductFactory().create("Electronic", "Watches", 150000, "galaxy watch", 10, "5");
            new MyProductFactory().create("Groceries", "Onions", 200, "big", 500, "6");
        }

        return instance;
    }

    @Override
    public void attach(Product product) {
        invetoryList.put(product.getBarcode(), product);
    }

    @Override
    public void detach(Product product) {
        invetoryList.remove(product.getBarcode());
    }

    @Override
    public void scanProduct(String barcode) throws CloneNotSupportedException {// update method
        invetoryList.get(barcode).update(barcode);

    }

    @Override
    public void scanProduct(String barcode, int quantity) throws CloneNotSupportedException {
        invetoryList.get(barcode).update(barcode, quantity);

    }

    @Override
    public Map<String, Product> getAllProducts() {
        return invetoryList;
    }

    @Override
    public void detachAllProducts() {
        invetoryList.clear();
    }

    public void updateInventory(String barcode, int quantity) {
        Product pdt = invetoryList.get(barcode);
        pdt.setQuantity(pdt.getQuantity() + quantity);

    }

    public void reduceInventory(String barcode, int quantity) {
        Product pdt = invetoryList.get(barcode);
        pdt.setQuantity(pdt.getQuantity() - quantity);

    }

}
