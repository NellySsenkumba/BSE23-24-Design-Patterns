package userInterface;
import java.util.List;

import org.Singleton.ProductCatalog;
import org.observerPattern.Observer;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class Salespersons {
    public GridPane viewSalesperson(BorderPane layout) {
        ProductCatalog cart = ProductCatalog.getInstance();
        List<Observer> salespersonList = cart.getAllObservers();
        GridPane gridPane = new GridPane();
        gridPane.setHgap(15);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        // Add column constraints to make the first column wider
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(70);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(30);
        gridPane.getColumnConstraints().addAll(col1, col2);

        // Add row constraints to make each row the same height
        for (int i = 0; i < salespersonList.size(); i++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100.0 / salespersonList.size());
            gridPane.getRowConstraints().add(row);
        }

        for (int i = 0; i < salespersonList.size(); i++) {
            Observer salesperson = salespersonList.get(i);
            Label nameLabel = new Label(salesperson.getName());
            Button detachButton = new Button("Detach");
            detachButton.setOnAction(e -> {
                cart.detach(salesperson);

                ScrollPane scrollPane = new ScrollPane(new Salespersons().viewSalesperson(layout));
                layout.setCenter(scrollPane);
            });

            GridPane.setConstraints(nameLabel, 0, i);
            GridPane.setConstraints(detachButton, 1, i);
            gridPane.getChildren().addAll(nameLabel, detachButton);
        }

        return gridPane;
    }
}
