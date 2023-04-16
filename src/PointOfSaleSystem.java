
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import userInterface.Cart;
import userInterface.CreateProduct;

public class PointOfSaleSystem {

    GridPane grid;

    public Scene dashboardScene(String role) {
        BorderPane layout = new BorderPane();

        // Client menu bar
        if (role.equals("Admin")) {
            layout.setTop(new AdminMenu().menuBar(layout));
            grid = new CreateProduct().create(layout);
            ScrollPane scrollPane = new ScrollPane(grid);
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            layout.setCenter(scrollPane);
        } else {
            layout.setTop(new ClientMenu().menuBar(layout));
            VBox grid = new Cart().viewCart(layout);
            ScrollPane scrollPane = new ScrollPane(grid);
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            layout.setCenter(scrollPane);
        }

        // layout.setBottom(scrollBar);
        return new Scene(layout, 500, 500);

    }
}
