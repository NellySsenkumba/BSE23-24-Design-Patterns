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
                // barcodeScanner.detach(cloth);
                barcodeScanner.scanProduct("236645875");
                // barcodeScanner.scanProduct("123456789");

                // paymentmethod for the product

                PaymentContext paymentcontext = new PaymentContext(new CreditCard("1234567897635267"));
                PaymentContext paymentcontext1 = new PaymentContext(new Cash());
                paymentcontext.pay(cart.getTotalPrice());
                paymentcontext1.pay(cart.getTotalPrice());

        }
}