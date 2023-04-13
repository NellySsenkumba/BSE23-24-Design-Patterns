import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import Product.Product;
import Singleton.ProductCatalog;

class ReceiptGeneartion {
    ProductCatalog cart = ProductCatalog.getInstance();
    List<Product> purchased = cart.getAllProducts();

    void generateReceipt() {
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();

        for (Product pdt : purchased) {
            double subTotal = pdt.getQuantity() * pdt.getPrice();

            jsonObject.addProperty("Name", pdt.getName());
            jsonObject.addProperty("Description", pdt.getDescription());
            jsonObject.addProperty("Quantity", pdt.getQuantity());
            jsonObject.addProperty("Unit Price", pdt.getPrice());
            jsonObject.addProperty("Sub Total", subTotal);
            String json = gson.toJson(jsonObject);
            System.out.println(json);

        }
    }
}
