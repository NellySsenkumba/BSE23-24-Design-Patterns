package userInterface;

import org.productFactory.MyProductFactory;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class CreateProduct {
    String productName;
    double productPrice;
    int productQuantity;
    String productDescription;
    String productCategory;
    String productBarcode;

    public GridPane grid = new GridPane();

    public GridPane create(BorderPane layout) {
        Button submit = new Button("Create");
        grid.getChildren().clear();
        grid.setPadding(new Insets(5));
        Label category = new Label("Category");
        Label name = new Label("Name");
        Label price = new Label("price");
        Label quantity = new Label("Quantity");
        Label description = new Label("Description");
        Label barcode = new Label("barcode");

        // category
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Electronic", "Clothings", "Groceries");
        comboBox.setValue("Electronic");

        TextField nameText = new TextField();
        TextField priceText = new TextField();
        TextField quantityText = new TextField();
        TextField descriptionText = new TextField();
        TextField barcodeText = new TextField();

        quantityText.setTextFormatter(new NumberFormatter().numberFormatter());

        priceText.setTextFormatter(new NumberFormatter().decimalFormatter());

        grid.setAlignment(Pos.CENTER);

        grid.addRow(0, category, comboBox);
        grid.addRow(1, name, nameText);
        grid.addRow(2, price, priceText);
        grid.addRow(3, quantity, quantityText);
        grid.addRow(4, description, descriptionText);
        grid.addRow(5, barcode, barcodeText);
        grid.addRow(6, submit);
        grid.setHgap(10);
        grid.setVgap(10);

        submit.setOnAction(event -> {

            productName = nameText.getText();
            productQuantity = Integer.parseInt(quantityText.getText());
            productPrice = Double.parseDouble(priceText.getText());
            productDescription = descriptionText.getText();
            productBarcode = barcodeText.getText();
            productCategory = comboBox.getValue();

            new MyProductFactory().create(productCategory, productName, productPrice, productDescription,
                    productQuantity, productBarcode);
            ScrollPane scrollPane = new ScrollPane(new AllProducts().getAllProducts(layout));
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            layout.setCenter(scrollPane);
        });

        nameText.getText();
        return grid;

    }
}
