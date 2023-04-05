import Product.*;
import Singleton.ProductCatalog;
import barcodeScanner.BarcodeScanner;
import decoratorPattern.*;
import observerPattern.Salesperson;
import strategyPattern.Cash;
import strategyPattern.CreditCard;
import strategyPattern.PaymentContext;

public class Client {
        public static void main(String[] args)
                        throws Exception {
                // Fatory method pattern
                Product cloth = new MyProductFactory().create("CLOTHINGS", "Hijab", 50000, "white", 1);
                // Singleton Pattern
                ProductCatalog cart = ProductCatalog.getInstance();
                // Observer Pattern
                cart.attach(new Salesperson("Brian", "a.brizzy.ba@gmail.com"));

                // Decorator Pattern
                cloth = new ExpressShipping(new GiftWrapping(cloth));

                // Barcode scanner
                BarcodeScanner barcodeScanner = new BarcodeScanner();
                barcodeScanner.attach(cloth);

                // adding to cart with barcode
                barcodeScanner.scanProduct(cart);

                // paymentmethod for the product

                PaymentContext paymentcontext = new PaymentContext(new CreditCard(1234567897635267L));
                PaymentContext paymentcontext1 = new PaymentContext(new Cash());
                paymentcontext.pay(cart.getTotalPrice());
                paymentcontext1.pay(cart.getTotalPrice());

        }
}