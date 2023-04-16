
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import userInterface.AllProducts;
import userInterface.CreateProduct;
import userInterface.RegisterSalesperson;
import userInterface.Salespersons;

public class AdminMenu {

    MenuBar menubar = new MenuBar();

    public MenuBar menuBar(BorderPane layout) {

        Menu productMenu = new Menu("Product");

        MenuItem createProduct = new MenuItem("Create");
        MenuItem inventoryProduct = new MenuItem("Inventory");
        productMenu.getItems().addAll(createProduct, inventoryProduct);

        Menu salespersonMenu = new Menu("Salesperson");
        MenuItem registerSalesperson = new MenuItem("Register");
        MenuItem Salesperson = new MenuItem("Salesperson");

        salespersonMenu.getItems().addAll(registerSalesperson, Salesperson);

        Menu logoutMenu = new Menu("Logout");
        MenuItem logoutItem = new MenuItem("Logout");

        logoutMenu.getItems().addAll(logoutItem);

        menubar.getMenus().addAll(productMenu, salespersonMenu, logoutMenu);
        // menu events
        inventoryProduct.setOnAction(e -> {
            ScrollPane scrollPane = new ScrollPane(new AllProducts().getAllProducts(layout));
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            layout.setCenter(scrollPane);
        });
        registerSalesperson.setOnAction(event -> {

            ScrollPane scrollPane = new ScrollPane(new RegisterSalesperson(layout).grid);
            layout.setCenter(scrollPane);

        });
        Salesperson.setOnAction(event -> {

            ScrollPane scrollPane = new ScrollPane(new Salespersons().viewSalesperson(layout));
            layout.setCenter(scrollPane);

        });

        createProduct.setOnAction(e -> {
            ScrollPane scrollPane = new ScrollPane(new CreateProduct().create(layout));
            layout.setCenter(scrollPane);
        });
        logoutMenu.setOnAction(e -> {
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
