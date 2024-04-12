package WithDrawalProcessor;

import Main.ATM;

public class TwoThousandWithDrawProcessor extends CashWithDrawProcessor {

    public TwoThousandWithDrawProcessor(CashWithDrawProcessor nextCashWithDrawProcessor) {
        super(nextCashWithDrawProcessor);
    }

    public void withdraw(ATM atm, int withDrawalAmount) {
        int required = withDrawalAmount / 2000;
        int pendingWithDrawalAmount = withDrawalAmount % 2000;
        if (required <= atm.getNoOfTwoThousand()) {
            atm.deductTwoThousand(required);
            System.out.println("No of 2k Notes Dispensed: " + required);
        } else {
            pendingWithDrawalAmount += (required - atm.getNoOfTwoThousand()) * 2000;
        }
        if (pendingWithDrawalAmount != 0) {
            super.withdraw(atm, pendingWithDrawalAmount);
        }
    }
}
