package States;

import Main.*;

public class IdleState extends ATMState {
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card Inserted");
        atm.setATMState(new HasCardState());
    }
}