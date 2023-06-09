package org.Product;

import org.Singleton.ProductCatalog;
import org.barcodeScanner.ProductObserver;

public abstract class Product implements ProductObserver, Cloneable {
    private String name;
    private int quantity;
    private String description;
    private double price;
    private String barcodeNumber;

    public abstract void updateDescription();

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBarcode() {
        return this.barcodeNumber;
    }

    public void setBarcode(String barcodeNumber) {
        this.barcodeNumber = barcodeNumber;
    }

    @Override
    public void update(String barcode) throws CloneNotSupportedException {
        ProductCatalog cart = ProductCatalog.getInstance();
        if (this.getBarcode().equals(barcode)) {
            cart.addProduct(this);

        }

    }

    @Override
    public void update(String barcode, int quantity) throws CloneNotSupportedException {
        ProductCatalog cart = ProductCatalog.getInstance();
        if (this.getBarcode().equals(barcode)) {
            cart.addProduct(this, quantity);

        }

    }

    public Product clone() throws CloneNotSupportedException {
        return (Product) super.clone();
    }

}
