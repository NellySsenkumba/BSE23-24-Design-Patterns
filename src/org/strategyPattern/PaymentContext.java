package strategyPattern;

public class PaymentContext {
    PaymentMethod paymentmethod;

    public PaymentContext(PaymentMethod paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public void pay(double amount) {
        paymentmethod.pay(amount);
    }
}
