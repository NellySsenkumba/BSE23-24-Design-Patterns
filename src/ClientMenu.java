

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import userInterface.Cart;

public class ClientMenu {

    MenuBar menubar = new MenuBar();

    public MenuBar menuBar(BorderPane layout) {

        Menu cartMenu = new Menu("Cart");
        MenuItem scan = new MenuItem("Scan");
        cartMenu.getItems().addAll(scan);

        Menu logoutMenu = new Menu("Logout");
        MenuItem logoutItem = new MenuItem("Logout");
        logoutMenu.getItems().addAll(logoutItem);

        menubar.getMenus().addAll(cartMenu, logoutMenu);

        cartMenu.setOnAction(e -> {
            ScrollPane scrollPane = new ScrollPane(new Cart().viewCart(layout));
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            layout.setCenter(scrollPane);
        });

        logoutItem.setOnAction(e -> {
            // Get the current stage

            Stage stage = (Stage) layout.getScene().getWindow();
            // Close the stage
            stage.close();

            Stage loginStage = new Stage();
            Scene loginScene = new Login().login(loginStage);
            loginStage.setScene(loginScene);
            loginStage.show();
        });
        return menubar;

    }
}
