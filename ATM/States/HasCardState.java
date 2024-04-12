package States;

import Main.*;

public class HasCardState extends ATMState {
    HasCardState() {
        System.out.println("Enter you pin");
    }

    public void authenticatePin(ATM atm, Card card, int pin) {
        if (card.isValidPin(pin)) {
            atm.setATMState(new SelectOperationState());
        } else {
            System.out.println("Wrong Pin");
            exit(atm);
        }
    }
}
