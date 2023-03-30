package observerPattern;

import Product.Product;

public class Salesperson implements Observer {
    private String name;

    public Salesperson(String name) {
        this.name = name;
    }

    @Override
    public void update(Product product) {
        System.out.println(name + " : " + product.getName() + " has been added to cart");
    }

}
