package barcodeScanner;

import java.util.List;

import Product.Product;

public interface BarcodeSubject {
    void attach(Product product);

    void detach(Product product);

    void scanProduct(String barcode);

    public List<Product> getAllProducts();

    public void detachAllProducts();
}