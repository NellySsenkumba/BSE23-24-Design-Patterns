package org;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.Product.Product;
import org.Singleton.ProductCatalog;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ReceiptGeneration {
    ProductCatalog cart = ProductCatalog.getInstance();
    Map<String, Product> purchased = cart.getAllProducts();

    public void generateReceipt() {
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
            try (FileWriter file = new FileWriter("receipt.json")) {
                file.write(json.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(json);

        }
    }
}
