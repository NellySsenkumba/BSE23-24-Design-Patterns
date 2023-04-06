package barcodeScanner;

import Product.Product;

public interface BarcodeSubject {
    void attach(Product product);

    void detach(Product product);

    void scanProduct(String barcode);
}