package barcodeScanner;

import java.util.HashMap;
import java.util.Map;

import Product.Product;

public class BarcodeScanner implements BarcodeSubject {
    private Map<String, Product> invetoryList = new HashMap<>(); // inventory
    public static BarcodeScanner instance = null;

    private BarcodeScanner() {

    }

    public static BarcodeScanner getInstance() {
        if (instance == null) {
            instance = new BarcodeScanner();
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
    public void scanProduct(String barcode) throws CloneNotSupportedException {
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
