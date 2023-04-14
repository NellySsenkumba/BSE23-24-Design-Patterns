import Product.*;
import Singleton.ProductCatalog;
import barcodeScanner.BarcodeScanner;
import decoratorPattern.ExpressShipping;
import decoratorPattern.GiftWrapping;
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
                Product tomato = new MyProductFactory().create("Groceries", "Tomato", 500, "fresh", 50, "230645875");
                Product tv = new MyProductFactory().create("Electronic", "Television", 500000, "Hisense 32 inch", 20,
                                "123456789");
                // Singleton Pattern
                ProductCatalog cart = ProductCatalog.getInstance();
                // Observer Pattern
                cart.attach(new Salesperson("Aaron", "aaronmug091@gmail.com"));
                cart.detach(new Salesperson("Aaron", "aaronmug091@gmail.com"));

                // Decorator Pattern
                cloth = new ExpressShipping(new GiftWrapping(cloth));
                tv = new ExpressShipping(tv);

                // update inventory
                BarcodeScanner barcodeScanner = BarcodeScanner.getInstance();
                barcodeScanner.updateInventory("230645875", 50);

                System.out.println(tomato.getQuantity());// 100

                // adding to cart with barcode
                barcodeScanner.scanProduct("236645875");
                barcodeScanner.scanProduct("236645875", 7);
                barcodeScanner.scanProduct("123456789", 6);
                barcodeScanner.scanProduct("230645875", 20);

                // paymentmethod for the product

                PaymentContext paymentcontext = new PaymentContext(new CreditCard("1234567897635267"));
                PaymentContext paymentcontext1 = new PaymentContext(new Cash());
                paymentcontext.pay(cart.getTotalPrice());

                paymentcontext1.pay(cart.getTotalPrice());

                // generating receipt
                new ReceiptGeneration().generateReceipt();

                System.out.println(tomato.getQuantity());// 80

        }

}