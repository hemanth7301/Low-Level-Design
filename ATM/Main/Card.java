package Main;

import java.sql.Date;

public class Card {
    int cardNumber;
    int cvv;
    Date expiryDate;
    String cardOwnerName;
    BankAccount bankAccount;
    static private final int pin = 789326;

    public boolean isValidPin(int pinEntered) {
        return pin == pinEntered;
    }

    public int getBankBalance() {
        return bankAccount.balance;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void deductAmount(int amount) {
        bankAccount.withDrawAmount(amount);
    }

}
