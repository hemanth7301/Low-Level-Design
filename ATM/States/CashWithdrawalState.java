package States;

import Main.*;
import WithDrawalProcessor.*;

public class CashWithdrawalState extends ATMState {
    CashWithdrawalState() {
        System.out.println("Please enter the Withdrawal Amount");
    }

    public void cashWithdrawal(ATM atm, Card card, int withDrawalAmount) {
        if (atm.getATMBalance() < withDrawalAmount) {
            System.out.println("Insufficient funds in ATM");
        } else if (card.getBankBalance() < withDrawalAmount) {
            System.out.println("Insufficient Balance in the account");
        } else {
            card.deductAmount(withDrawalAmount);
            atm.deductATMBalance(withDrawalAmount);
            CashWithDrawProcessor withdrawProcessor = new TwoThousandWithDrawProcessor(
                    new FiveHundredWithDrawProcessor(new OneHundredWithDrawProcessor(null)));
            withdrawProcessor.withdraw(atm, withDrawalAmount);
            System.out.println("Please collect the cash");
        }
        exit(atm);
    }
}
