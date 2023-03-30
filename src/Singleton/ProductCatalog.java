package Singleton;

import java.util.ArrayList;
import java.util.List;
import observerPattern.*;

import Product.*;

public class ProductCatalog implements Subject {
    private static ProductCatalog instance = null;
    private List<Product> productList = new ArrayList<>();
    private List<Observer> observerList = new ArrayList<>();
    

    public ProductCatalog() {
        // Initial products to the catalog
        productList.add(new Electronic("Smartphone", 999.99, "14 pro max", 3));
        productList.add(new Clothing("T-Shirt", 19.99, "Long sleeve", 10));
        productList.add(new Groceries("Bananas", 2.99, "ripe", 50));
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

}