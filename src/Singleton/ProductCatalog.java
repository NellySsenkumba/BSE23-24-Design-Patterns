package Singleton;

import java.util.ArrayList;
import java.util.List;
import observerPattern.*;

import Product.*;

public class ProductCatalog implements Subject {
    private static ProductCatalog instance = null;
    private double totalPrice = 0;

    private List<Product> productList = new ArrayList<>();
    private List<Observer> salespersonsList = new ArrayList<>();

    private ProductCatalog() {
    }

    public static ProductCatalog getInstance() {
        if (instance == null) {
            instance = new ProductCatalog();
        }
        return instance;
    }

    public void addProduct(Product product) {
        totalPrice += product.getPrice();
        productList.add(product);
        notifyObservers(product);
    }

    public List<Product> getAllProducts() {
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