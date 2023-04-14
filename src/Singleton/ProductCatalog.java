package Singleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import observerPattern.*;

import Product.*;
import barcodeScanner.BarcodeScanner;

public class ProductCatalog implements Subject {
    private static ProductCatalog instance = null;
    private double totalPrice = 0;

    private Map<String, Product> productList = new HashMap<>();

    private List<Observer> salespersonsList = new ArrayList<>();

    private ProductCatalog() {
    }

    public static ProductCatalog getInstance() {
        if (instance == null) {
            instance = new ProductCatalog();
        }
        return instance;
    }

    public void addProduct(Product product) throws CloneNotSupportedException {
        totalPrice += product.getPrice();
        product = product.clone();

        if (productList.containsKey(product.getBarcode())) {
            product.setQuantity(product.getQuantity() + 1);

        } else {
            product.setQuantity(1);
            productList.put(product.getBarcode(), product);

        }

        notifyObservers(product);
        // update invetory
        BarcodeScanner barcodeScanner = BarcodeScanner.getInstance();
        barcodeScanner.reduceInventory(product.getBarcode(), 1);
    }

    public void addProduct(Product product, int quantity) throws CloneNotSupportedException {

        totalPrice += (product.getPrice() * quantity);
        product = product.clone();
        if (productList.containsKey(product.getBarcode())) {
            product.setQuantity(product.getQuantity() + quantity);

        } else {
            product.setQuantity(quantity);
            productList.put(product.getBarcode(), product);

        }

        notifyObservers(product);
        BarcodeScanner barcodeScanner = BarcodeScanner.getInstance();
        barcodeScanner.reduceInventory(product.getBarcode(), quantity);

    }

    public Map<String, Product> getAllProducts() {
        return productList;
    }

    public void detachAllProducts() {
        productList.clear();
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    @Override
    public List<Observer> getAllObservers() {
        return salespersonsList;
    }

    @Override
    public void attach(Observer observer) {
        salespersonsList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        salespersonsList.remove(observer);
    }

    @Override
    public void notifyObservers(Product product) {
        for (Observer salesperson : salespersonsList) {
            salesperson.update(product);

        }

    }

    // remove all Observers
    @Override
    public void detachAllObservers() {
        salespersonsList.clear();
    }

}