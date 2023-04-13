import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import Product.*;
import Singleton.ProductCatalog;
import barcodeScanner.BarcodeScanner;
import observerPattern.Salesperson;
import productFactory.MyProductFactory;
import strategyPattern.Cash;
import strategyPattern.CreditCard;
import strategyPattern.PaymentContext;

public class Client {
        public static void main(String[] args)
                        throws Exception {
                // Fatory method pattern
                Product cloth = new MyProductFactory().create("CLOTHINGS", "Hijab", 50000, "white", 59, "236645875");
                Product tomato = new MyProductFactory().create("Groceries", "Tomato", 500, "fresh", 100, "230645875");
                Product tv = new MyProductFactory().create("Electronic", "Television", 500000, "Hisense 32 inch", 30,
                                "123456789");
                // Singleton Pattern
                ProductCatalog cart = ProductCatalog.getInstance();
                // Observer Pattern
                cart.attach(new Salesperson("Aaron", "aaronmug091@gmail.com"));

                // Decorator Pattern
                // cloth = new ExpressShipping(new GiftWrapping(cloth));
                // tv = new ExpressShipping(tv);

                // adding to cart with barcode
                BarcodeScanner barcodeScanner = BarcodeScanner.getInstance();
                barcodeScanner.updateInventory("230645875", 50);
                // System.out.println(tomato.getQuantity());

                // barcodeScanner.detach(cloth);
                // barcodeScanner.scanProduct("236645875", 7);
                // barcodeScanner.scanProduct("123456789", 6);
                // barcodeScanner.scanProduct("230645875", 20);

                // barcodeScanner.scanProduct("123456789");

                // paymentmethod for the product

                PaymentContext paymentcontext = new PaymentContext(new CreditCard("1234567897635267"));
                PaymentContext paymentcontext1 = new PaymentContext(new Cash());
                // paymentcontext.pay(cart.getTotalPrice());

                // paymentcontext1.pay(cart.getTotalPrice());

                ReceiptGeneartion receipt = new ReceiptGeneartion();
                // receipt.generateReceipt();

                // for (Product pdt : ProductCatalog.getInstance().getAllProducts()) {
                // System.out.println("From cart");
                // System.out.println(pdt.getName() + " Quantity" + pdt.getQuantity());

                // }

                for (Product pdt : BarcodeScanner.getInstance().getAllProducts()) {
                        // System.out.println("From inventory");
                        System.out.println(pdt.getName() + "  Quantity " + pdt.getQuantity());

                }

                BarcodeScanner obj = BarcodeScanner.getInstance();
                obj.reduceInventory("230645875", 3);

                // System.out.println(tomato.getQuantity());

        }

}