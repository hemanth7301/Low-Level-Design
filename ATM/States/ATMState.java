package States;

import Main.ATM;
import Main.Card;
import Main.TransactionType;

public abstract class ATMState implements Exit {
    public void insertCard(ATM atm, Card card) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void authenticatePin(ATM atm, Card card, int pin) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void selectOperation(ATM atm, Card card, TransactionType txnType) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void cashWithdrawal(ATM atm, Card card, int withdrawAmount) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void displayBalance(ATM atm, Card card) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void exit(ATM atm) {
        returnCard();
        atm.setATMState(new IdleState());
        System.out.println("Exited");
    }

    public void returnCard() {
        System.out.println("Collect your card");
    }

}
