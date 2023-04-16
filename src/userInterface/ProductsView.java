package userInterface;

import org.Product.Product;
import org.Singleton.ProductCatalog;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ProductsView extends BorderPane {

    private Label nameLabel;
    private Label descriptionLabel;
    private Label quantityLabel;
    private Label priceLabel;
    private Label barcodeLabel;

    private Button removeFromCartButton;

    public ProductsView(Product pdt, BorderPane layout) {
        cartProducts(pdt, layout);
    }

    public ProductsView(String name, String description, int quantity, double price, String barcode,
            BorderPane layout) {
        allProducts(name, description, quantity, price, barcode, layout);
    }

    public void allProducts(String name, String description, int quantity, double price, String barcode,
            BorderPane layout) {

        // Create the name label
        nameLabel = new Label(name);
        nameLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
        nameLabel.setAlignment(Pos.CENTER);

        // Create the description label
        descriptionLabel = new Label(description);
        descriptionLabel.setWrapText(true);

        // Create the quantity label
        quantityLabel = new Label(Integer.toString(quantity));
        quantityLabel.setWrapText(true);

        // Create the description label
        priceLabel = new Label(Double.toString(price));
        priceLabel.setWrapText(true);
        // Create the description label
        barcodeLabel = new Label(barcode);
        barcodeLabel.setWrapText(true);

        // Create the "add to cart" button
        removeFromCartButton = new Button("Manage Inventory");
        removeFromCartButton.setStyle("-fx-font-size: 16; -fx-background-color: #4CAF50; -fx-text-fill: white;");
        // clicks a button
        removeFromCartButton.setOnAction(e -> {
            // add to cart

        });
        // putting key value

        HBox descHBox = new HBox(2, new Label("Description:"), descriptionLabel);
        // nameHBox.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");

        HBox qntHBox = new HBox(2, new Label("Quantity:"), quantityLabel);
        // nameHBox.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");

        HBox prcHBox = new HBox(2, new Label("Price:"), priceLabel);
        // nameHBox.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");

        HBox barHBox = new HBox(2, new Label("Barcode:"), barcodeLabel);
        // nameHBox.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");

        // Add the name label, description label, and button to the card
        VBox vBox = new VBox(10, nameLabel, descHBox, qntHBox, prcHBox, barHBox);
        vBox.setAlignment(Pos.CENTER_LEFT);
        setCenter(vBox);
        setBottom(removeFromCartButton);

        // Set padding and margins for the card
        setPadding(new Insets(10));
        setMargin(removeFromCartButton, new Insets(10));
    }

    public void cartProducts(Product pdt, BorderPane layout) {
        String name = pdt.getName();
        String description = pdt.getDescription();
        int quantity = pdt.getQuantity();
        double price = pdt.getPrice();
        String barcode = pdt.getBarcode();
        // Create the name label
        nameLabel = new Label(name);
        nameLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
        nameLabel.setAlignment(Pos.CENTER);

        // Create the description label
        descriptionLabel = new Label(description);
        descriptionLabel.setWrapText(true);

        // Create the quantity label
        quantityLabel = new Label(Integer.toString(quantity));
        quantityLabel.setWrapText(true);

        // Create the description label
        priceLabel = new Label(Double.toString(price));
        priceLabel.setWrapText(true);
        // Create the description label

        // Create the "add to cart" button
        removeFromCartButton = new Button("Remove");
        removeFromCartButton.setStyle("-fx-font-size: 10; -fx-background-color: #FF0000; -fx-text-fill: white;");
        // clicks a button
        removeFromCartButton.setOnAction(e -> {
            ProductCatalog cart = ProductCatalog.getInstance();
            cart.removeProduct(barcode);

            ScrollPane scrollPane = new ScrollPane(new Cart().viewCart(layout));
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            layout.setCenter(scrollPane);

        });
        // putting key value

        HBox descHBox = new HBox(2, new Label("Description:"), descriptionLabel);
        // nameHBox.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");

        HBox qntHBox = new HBox(2, new Label("Quantity:"), quantityLabel);
        // nameHBox.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");

        HBox prcHBox = new HBox(2, new Label("Price:"), priceLabel);
        // nameHBox.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");

        // Add the name label, description label, and button to the card
        VBox vBox = new VBox(10, nameLabel, descHBox, qntHBox, prcHBox);
        vBox.setAlignment(Pos.CENTER_LEFT);
        setCenter(vBox);
        setBottom(removeFromCartButton);

        // Set padding and margins for the card
        setPadding(new Insets(10));
        setMargin(removeFromCartButton, new Insets(10));
    }

}