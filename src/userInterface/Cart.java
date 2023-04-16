package userInterface;

import java.util.ArrayList;
import java.util.Map;

import org.Product.Product;
import org.Singleton.ProductCatalog;
import org.barcodeScanner.BarcodeScanner;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Cart {
    ProductCatalog cart = ProductCatalog.getInstance();
    BarcodeScanner obj = BarcodeScanner.getInstance();

    public VBox viewCart(BorderPane layout) {
        VBox box = new VBox();

        Map<String, Product> productList = cart.getAllProducts();
        ArrayList<ProductsView> viewList = new ArrayList<>();
        for (Map.Entry<String, Product> entry : productList.entrySet()) {
            // String key = entry.getKey();
            Product product = entry.getValue();
            viewList.add(new ProductsView(product, layout));

        }

        GridPane grid = new GridPane();
        int track = 0;
        for (int i = 0; track != -1; i++) {

            for (int j = 0; j < 5; j++) {
                if (track != productList.size()) {
                    grid.add(viewList.get(track), j, i);
                    track++;
                } else {
                    track = -1;
                    break;

                }
            }
        }

        if (!viewList.isEmpty()) {
            Button checkout = new Button("CheckOut");
            checkout.setStyle("-fx-font-size: 16; -fx-background-color: #0B662E; -fx-text-fill: white;");
            checkout.setOnAction(e -> {
                // print receipt
            });
            box.getChildren().addAll(grid, checkout, scan(layout));
        } else {
            box.getChildren().addAll(grid, scan(layout));
        }

        return box;
    }

    GridPane scan(BorderPane layout) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        Text sceneTitle = new Text("Scanner");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        gridPane.add(sceneTitle, 0, 0, 2, 1);

        Label barcodeLabel = new Label("Barcode:");
        gridPane.add(barcodeLabel, 0, 1);

        TextField barcodeTextField = new TextField();
        gridPane.add(barcodeTextField, 1, 1);

        Label quantityLabel = new Label("Quantity:");
        gridPane.add(quantityLabel, 0, 2);

        TextField quantityTextField = new TextField();
        gridPane.add(quantityTextField, 1, 2);

        Label decorate = new Label("Extra:     ");
        gridPane.add(decorate, 0, 3);
        CheckBox expressShiping = new CheckBox("Express Shipping");
        CheckBox giftWrapping = new CheckBox("Gift Wrapping");

        HBox root = new HBox();
        root.getChildren().addAll(expressShiping, giftWrapping);
        root.setSpacing(5);

        gridPane.add(root, 1, 3);

        Button addButton = new Button("Add");
        gridPane.add(addButton, 1, 4);

        Text errorMessage = new Text();
        gridPane.add(errorMessage, 1, 5);

        addButton.setOnAction(e -> {
            String barcode = barcodeTextField.getText();
            String quantity = quantityTextField.getText();

            if (quantity.equals("")) {

                try {
                    obj.scanProduct(barcode);
                } catch (CloneNotSupportedException e1) {
                    e1.printStackTrace();
                }
            } else {
                try {
                    int quantityInt = Integer.parseInt(quantityTextField.getText());
                    obj.scanProduct(barcode, quantityInt);
                } catch (CloneNotSupportedException e1) {
                    e1.printStackTrace();
                }
            }

            ScrollPane scrollPane = new ScrollPane(new Cart().viewCart(layout));
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            layout.setCenter(scrollPane);

        });

        return gridPane;
    }

}
