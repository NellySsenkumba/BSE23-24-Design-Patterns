import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login extends Application {
    String role;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Login Page");

        primaryStage.setScene(login(primaryStage));
        primaryStage.show();
    }

    private boolean isValidCredentials(String username, String password) {
        if (username.equals("Joe") && password.equals("1234")) {
            role = "Admin";
            return true;
        } else if (username.equals("Aaron") && password.equals("1234")) {
            role = "Client";
            return true;
        } else {
            return false;
        }

    }

    Scene login(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        Text sceneTitle = new Text("BSE23-24 Point Of Sale System");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        gridPane.add(sceneTitle, 0, 0, 2, 1);

        Label usernameLabel = new Label("Username:");
        gridPane.add(usernameLabel, 0, 1);

        TextField usernameTextField = new TextField();
        gridPane.add(usernameTextField, 1, 1);

        Label passwordLabel = new Label("Password:");
        gridPane.add(passwordLabel, 0, 2);

        PasswordField passwordField = new PasswordField();
        gridPane.add(passwordField, 1, 2);

        Button loginButton = new Button("Login");
        gridPane.add(loginButton, 1, 3);

        Text errorMessage = new Text();
        gridPane.add(errorMessage, 1, 4);

        loginButton.setOnAction(e -> {
            String username = usernameTextField.getText();
            String password = passwordField.getText();
            if (isValidCredentials(username, password)) {

                errorMessage.setFill(javafx.scene.paint.Color.GREEN);
                errorMessage.setText("Login successful!");
                try {
                    if (role.equals("Admin")) {
                        primaryStage.setScene(new PointOfSaleSystem().dashboardScene(role));
                        primaryStage.setTitle("Point Of Sale System");
                    } else if (role.equals("Client")) {
                        primaryStage.setScene(new PointOfSaleSystem().dashboardScene(role));
                        primaryStage.setTitle("Point Of Sale System");
                    } else {

                    }

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            } else {
                errorMessage.setFill(javafx.scene.paint.Color.RED);
                errorMessage.setText("Invalid username or password.");
            }
        });

        Scene scene = new Scene(gridPane, 300, 275);
        return scene;
    }

}
