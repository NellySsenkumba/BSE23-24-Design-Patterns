package Product;

public class Groceries extends Product {

    public Groceries(String name, double price, String description, int quantity, String barcode) {
        this.setName(name);
        this.setPrice(price);
        this.setDescription(description);
        this.setQuantity(quantity);
        this.setBarcode(barcode);
        updateDescription();
    }

    @Override
    public void updateDescription() {
        this.setDescription(this.getDescription() + ", groceries");
    }

    

}
