import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Test {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField name;

    @FXML
    private TextField price;

    @FXML
    private TextField quantity;

    @FXML
    private TextField description;

    @FXML
    private TextField barcode;

    @FXML
    void Inventory(ActionEvent event) {

    }

    @FXML
    void allsalesperson(ActionEvent event) {

    }

    @FXML
    void createBtn(ActionEvent event) {
        System.out.println("clicked");
    }

    @FXML
    void createProduct(ActionEvent event) {

    }

    @FXML
    void logout(ActionEvent event) {

    }

    @FXML
    void registerSalesperson(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'Untitled'.";
        assert price != null : "fx:id=\"price\" was not injected: check your FXML file 'Untitled'.";
        assert quantity != null : "fx:id=\"quantity\" was not injected: check your FXML file 'Untitled'.";
        assert description != null : "fx:id=\"description\" was not injected: check your FXML file 'Untitled'.";
        assert barcode != null : "fx:id=\"barcode\" was not injected: check your FXML file 'Untitled'.";

    }
}
