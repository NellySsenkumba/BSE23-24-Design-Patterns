package strategyPattern;

public class CreditCard implements PaymentMethod {
    private int[] cardNumber = new int[16];

    public CreditCard(long cardNumber) {
        this.cardNumber = Long.toString(cardNumber).chars().toArray();

    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " with credit card (card number: " + cardNumber[0] + cardNumber[1]
                + cardNumber[2] + "************" + cardNumber[14] + cardNumber[15] + ")");
    }

}
