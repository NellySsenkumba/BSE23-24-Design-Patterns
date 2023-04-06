package barcodeScanner;

import java.util.ArrayList;
import java.util.List;

import Product.Product;
import Singleton.ProductCatalog;

public class BarcodeScanner implements BarcodeSubject {
    private static List<Product> productList = new ArrayList<>();
    public static BarcodeScanner instance = null;

    private BarcodeScanner() {

    }

    public static BarcodeScanner getInstance() {
        if (instance == null) {
            return new BarcodeScanner();

        }
        return instance;
    }

    @Override
    public void attach(Product product) {
        this.productList.add(product);
    }

    @Override
    public void detach(Product product) {
        this.productList.remove(product);
    }

    @Override
    public void scanProduct(String barcode) {
        ProductCatalog cart = ProductCatalog.getInstance();
        int exist = 0;
        Product pdt = null;
        for (Product product : productList) {
            if (product.getBarcode().equals(barcode)) {
                exist = 1;
                pdt = product;
                break;
            }
        }
        if (exist == 1) {
            cart.addProduct(pdt);
        } else {
            System.out.println("Product doesnt exist");
        }

    }

}
