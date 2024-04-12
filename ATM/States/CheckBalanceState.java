package States;

import Main.*;

public class CheckBalanceState extends ATMState {
    CheckBalanceState() {
    }

    public void displayBalance(ATM atm, Card card) {
        System.out.println("Current Balance: " + card.getBankBalance());
        exit(atm);
    }

}
