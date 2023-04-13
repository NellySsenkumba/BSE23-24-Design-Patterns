package barcodeScanner;

import java.util.ArrayList;
import java.util.List;

import Product.Product;

public class BarcodeScanner implements BarcodeSubject {
    static private List<Product> invetoryList = new ArrayList<>();// invetory
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
        invetoryList.add(product);
    }

    @Override
    public void detach(Product product) {
        invetoryList.remove(product);
    }

    @Override
    public void scanProduct(String barcode) {
        for (Product pdt : invetoryList) {
            pdt.update(barcode);
        }

    }

    @Override
    public void scanProduct(String barcode, int quantity) {
        for (Product pdt : invetoryList) {
            pdt.update(barcode, quantity);
        }

    }

    @Override
    public List<Product> getAllProducts() {
        return invetoryList;
    }

    @Override
    public void detachAllProducts() {
        invetoryList.clear();
    }

    public void updateInventory(String barcode, int quantity) {
        for (Product pdt : invetoryList) {
            if (pdt.getBarcode().equals(barcode)) {
                pdt.setQuantity(pdt.getQuantity() + quantity);
                break;
            }
        }
    }

    public void reduceInventory(String barcode, int quantity) {
        for (Product pdt : invetoryList) {
            if (pdt.getBarcode().equals(barcode)) {
                System.out.println("Quantity:>>>>>" + pdt.getQuantity());
                pdt.setQuantity(pdt.getQuantity() - quantity);
                break;
            }
        }
    }

}
