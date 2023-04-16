package org.strategyPattern;

public class CreditCard implements PaymentMethod {
    private char[] cardNumber = new char[16];

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber.toCharArray();

    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " with credit card (card number: " + cardNumber[0] + cardNumber[1]
                + cardNumber[2] + "************" + cardNumber[14] + cardNumber[15] + ")");
    }

}
