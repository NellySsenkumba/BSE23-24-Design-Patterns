package observerPattern;

import java.util.List;

import Product.Product;

public interface Subject {
    void attach(Observer observer);

    void detach(Observer observer);

    void notifyObservers(Product product);

    public List<Observer> getAllObservers();

    public void detachAllObservers();

}
