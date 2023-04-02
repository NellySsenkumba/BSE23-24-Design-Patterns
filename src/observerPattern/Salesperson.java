package observerPattern;

import Product.Product;
import sendMail.SendEmail;

public class Salesperson implements Observer {
    private String name;
    private String email;

    public Salesperson(String name,String email) {
        this.name = name;
        this.email=email;
    }

    @Override
    public void update(Product product) {

        String msg = name + " : " + product.getName() + " (" + product.getDescription() + ")"
                + " has been added to cart\n";

        SendEmail.sendMail(this.email, msg);
        System.out.print(msg);
    }

}
