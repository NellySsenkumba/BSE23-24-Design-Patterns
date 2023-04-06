package barcodeScanner;

import java.util.ArrayList;
import java.util.List;

import Product.Product;


public class BarcodeScanner implements BarcodeSubject {
    static List<Product> productList = new ArrayList<>();
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
        productList.add(product);
    }

    @Override
    public void detach(Product product) {
        productList.remove(product);
    }

    @Override
    public void scanProduct(String barcode) {
        for (Product pdt: productList){
            pdt.update(barcode);
        }
        
    }

    @Override
    public List<Product> getAllProducts() {
        return productList;
    }

    @Override
    public void detachAllProducts() {
        productList.clear();
    }

}
