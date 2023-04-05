package barcodeScanner;

import Product.Product;
import Singleton.ProductCatalog;

public interface BarcodeSubject {
    void attach(Product product);

    void detach(Product product);

    void scanProduct(ProductCatalog pc);
}