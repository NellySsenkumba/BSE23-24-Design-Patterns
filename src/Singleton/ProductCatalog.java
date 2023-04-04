package Singleton;

import java.util.ArrayList;
import java.util.List;
import observerPattern.*;

import Product.*;
import barcodeScanner.BarcodeScannerObserver;

public class ProductCatalog implements Subject, BarcodeScannerObserver {
    private static ProductCatalog instance = null;
    private List<Product> productList = new ArrayList<>();
    private List<Observer> observerList = new ArrayList<>();
    private List<String> barcodeList = new ArrayList<>();

    private ProductCatalog() {
    }

    public static ProductCatalog getInstance() {
        if (instance == null) {
            instance = new ProductCatalog();
        }
        return instance;
    }

    public void addProduct(Product product) {
        productList.add(product);
        notifyObservers(product);
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    public void detachAllProducts() {
        productList.clear();
    }

    @Override
    public List<Observer> getAllObservers() {
        return observerList;
    }

    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers(Product product) {
        for (Observer observer : observerList) {
            observer.update(product);

        }

    }

    // remove all Observers
    @Override
    public void detachAllObservers() {
        observerList.clear();
    }

    @Override
    public void update(String barcode) {
        barcodeList.add(barcode);
        System.out.println("Added item with barcode " + barcode + " to cart.");
    }

    public List<String> getItems() {
        return barcodeList;
    }

}