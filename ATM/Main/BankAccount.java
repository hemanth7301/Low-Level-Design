package Main;

public class BankAccount {
    int balance;

    public void withDrawAmount(int withDrawAmount) {
        this.balance = this.balance - withDrawAmount;
    }
}
