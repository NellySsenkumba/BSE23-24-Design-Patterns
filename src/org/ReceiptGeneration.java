package org;
import java.util.Map;

import org.Product.Product;
import org.Singleton.ProductCatalog;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

class ReceiptGeneration {
    ProductCatalog cart = ProductCatalog.getInstance();
    Map<String, Product> purchased = cart.getAllProducts();

    void generateReceipt() {
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();

        for (String barcode : purchased.keySet()) {
            Product pdt = purchased.get(barcode);
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
