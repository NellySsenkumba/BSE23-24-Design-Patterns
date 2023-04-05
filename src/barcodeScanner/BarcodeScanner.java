package barcodeScanner;

import java.util.ArrayList;
import java.util.List;

import Product.Product;
import Singleton.ProductCatalog;

public class BarcodeScanner implements BarcodeSubject {
    private List<Product> productList = new ArrayList<>();

    @Override
    public void attach(Product product) {
        this.productList.add(product);
    }

    @Override
    public void detach(Product product) {
        this.productList.remove(product);
    }

    @Override
    public void scanProduct(ProductCatalog pc) {
        for (Product pdt : productList) {
            System.out
                    .println(pdt.getName() + "(" + pdt.getDescription() + ")" + " has been scanned and added to cart.");
            pdt.update(pdt, pc);
        }

    }

}