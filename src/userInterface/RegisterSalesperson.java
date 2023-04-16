package userInterface;
import org.Singleton.ProductCatalog;
import org.observerPattern.Salesperson;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class RegisterSalesperson {

    public GridPane grid = new GridPane();
    Salesperson salesperson;

    public RegisterSalesperson(BorderPane layout) {
        register(layout);
    }

    public void register(BorderPane layout) {
        grid.getChildren().clear();
        grid.setPadding(new Insets(5));
        Button registerButton = new Button("Register");

        Label name = new Label("Name");
        Label email = new Label("Email");

        TextField nameText = new TextField();
        TextField emailText = new TextField();

        registerButton.setOnAction(e -> {

            salesperson = new Salesperson(nameText.getText(), emailText.getText());

            ProductCatalog.getInstance().attach(salesperson);
            ScrollPane scrollPane = new ScrollPane(new Salespersons().viewSalesperson(layout));
            layout.setCenter(scrollPane);
        });

        grid.setAlignment(Pos.CENTER);

        grid.addRow(0, name, nameText);
        grid.addRow(1, email, emailText);

        grid.addRow(4, registerButton);

        grid.setHgap(10);
        grid.setVgap(10);

    }
}
