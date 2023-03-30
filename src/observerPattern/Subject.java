package observerPattern;

import Product.Product;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(Product product);
    

}
