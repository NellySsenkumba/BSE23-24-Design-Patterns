package userInterface;

import java.util.ArrayList;
import java.util.Map;

import org.Product.Product;
import org.barcodeScanner.BarcodeScanner;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class AllProducts {
    public GridPane getAllProducts(BorderPane layout) {
        BarcodeScanner obj = BarcodeScanner.getInstance();

        Map<String, Product> productList = obj.getAllProducts();
        ArrayList<ProductsView> viewList = new ArrayList<>();
        for (Map.Entry<String, Product> entry : productList.entrySet()) {
            // String key = entry.getKey();
            Product product = entry.getValue();
            viewList.add(new ProductsView(product.getName(), product.getDescription(), product.getQuantity(),
                    product.getPrice(), product.getBarcode(), layout));

        }

        GridPane grid = new GridPane();
        int track = 0;
        for (int i = 0; track != -1; i++) {

            for (int j = 0; j < 5; j++) {
                if (track != viewList.size()) {
                    grid.add(viewList.get(track), j, i);
                    track++;
                } else {
                    track = -1;
                    break;

                }
            }
        }
        return grid;
    }
}
