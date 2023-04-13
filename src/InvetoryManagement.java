import java.util.List;

import Product.Product;
import barcodeScanner.BarcodeScanner;

public class InvetoryManagement {
    List<Product> productList=BarcodeScanner.getInstance().getAllProducts();

    void updateInventory(String barcode,int quantity) {
        for (Product pdt:productList){
            if (pdt.getBarcode().equals(barcode)){
                pdt.setQuantity(quantity);
            }
        }
    }

}
