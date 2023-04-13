package barcodeScanner;

import java.util.Map;

import Product.Product;

public interface BarcodeSubject {
    void attach(Product product);

    void detach(Product product);

    void scanProduct(String barcode) throws CloneNotSupportedException;

    void scanProduct(String barcode, int quantity) throws CloneNotSupportedException;

    public Map<String, Product> getAllProducts();

    public void detachAllProducts();
}