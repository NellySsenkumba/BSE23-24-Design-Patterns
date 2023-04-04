import Product.*;
import Singleton.ProductCatalog;
import decoratorPattern.*;
import observerPattern.Salesperson;

public class Client {
        public static void main(String[] args)
                        throws Exception {
                // Fatory method pattern
                Product cloth = new MyProductFactory().create("CLOTHINGS", "Hijab", 50000, "white", 1);
                // Singleton Pattern
                ProductCatalog cart = ProductCatalog.getInstance();
                // Observer Pattern
                cart.attach(new Salesperson("Brian", "a.brizzy.ba@gmail.com"));
                cart.addProduct(cloth);
                // Decorator Pattern
                cloth = new ExpressShipping(new GiftWrapping(cloth));

                cart.addProduct(cloth);

                

        }
}