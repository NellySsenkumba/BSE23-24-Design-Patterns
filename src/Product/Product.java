package Product;

import Singleton.ProductCatalog;

public abstract class Product {
    private String name;
    private int quantity;
    private String description;
    private double price;
    private String barcodeNumber;

    public abstract void updateDescription();

    public abstract void update(Product product, ProductCatalog cart);// for barcode

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

}
