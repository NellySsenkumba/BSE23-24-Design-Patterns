import java.util.List;

import Product.*;
import Singleton.*;
import decoratorPattern.*;
import observerPattern.*;

public class Client {
    public static void main(String[] args) {
        // factory method pattern
        MyProductFactory pf = new MyProductFactory();
        Product electronic = pf.create("electronic", "Phone", 3400000, "iphone 14 promax", 8);
        System.out.println("\tFACTORY METHOD PATTERN");
        System.out
                .println("Category: " + electronic.getClass().getName() + "\nName: " +
                        electronic.getName()
                        + " \nPrice: "
                        + electronic.getPrice() + " \nDescription: "
                        + electronic.getDescription() + " \nQuantity: " + electronic.getQuantity() +
                        " items");

        // singleton pattern
        ProductCatalog pc = new ProductCatalog();
        pc.addProduct(new Electronic("TV", 3000, "Hisense 40 inch", 1));
        pc.addProduct(new Clothing("Jacket", 400000, "Leather", 5));
        List<Product> products = pc.getAllProducts();
        System.out.println("\n\n\n\n\tSINGLETON PATTERN");
        for (Product pdt : products) {
            System.out
                    .println("Category: " + pdt.getClass().getName() + "\nName: " + pdt.getName()
                            + " \nPrice: "
                            + pdt.getPrice() + " \nDescription: "
                            + pdt.getDescription() + " \nQuantity: " + pdt.getQuantity() + "items\n\n\n");

        }

        // Decorator Pattern
        MyProductFactory pf2 = new MyProductFactory();
        Product phone = pf2.create("electronic", "Phone", 3400000, "iphone 14 promax", 8);
        System.out.println("\n\n\n\n\tDECORATOR PATTERN");
        GiftWrapping wrapped_phone = new GiftWrapping(phone);

        System.out.println(
                "The updated price (With Wrapping) is " + wrapped_phone.getPrice() + wrapped_phone.getDescription());

        // Observer pattern
        System.out.println("\n\n\n\n\tOBSERVER PATTERN");
        ProductCatalog cart = new ProductCatalog();

        Salesperson Mariam = new Salesperson("Mariam");
        Salesperson Aaron = new Salesperson("Aaron");
        cart.attach(Mariam); // Mariam subscribing
        cart.attach(Aaron); // Aaron subscribing

        cart.addProduct(new Clothing("Jacket", 400000, "Leather", 5));
        cart.detach(Mariam);// Mariam unsubscribing
        cart.addProduct(new Electronic("Speaker", 400000, "JBL", 10));

    }
}