package org.Product;



public class Electronic extends Product {

    public Electronic(String name, double price, String description, int quantity,String barcode) {
        this.setName(name);
        this.setPrice(price);
        this.setDescription(description);
        this.setQuantity(quantity);
        this.setBarcode(barcode);
        updateDescription();
    }

    @Override
    public void updateDescription() {
        this.setDescription(this.getDescription() + ", electronic");
    }
    

}
