import Product.*;
import Singleton.ProductCatalog;
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
                // cart.attach(new Salesperson("Brian", "a.brizzy.ba@gmail.com"));
                cart.addProduct(cloth);
                // Decorator Pattern
                cloth = new ExpressShipping(new GiftWrapping(cloth));

                cart.addProduct(cloth);

                // paymentmethod
                

                PaymentContext paymentcontext = new PaymentContext(new CreditCard(1234567897635267L));
                PaymentContext paymentcontext1 = new PaymentContext(new Cash());
                paymentcontext.pay(5000.0);
                paymentcontext1.pay(5000.0);

        }
}