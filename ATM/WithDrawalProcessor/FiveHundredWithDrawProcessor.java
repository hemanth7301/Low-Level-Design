package WithDrawalProcessor;

import Main.ATM;

public class FiveHundredWithDrawProcessor extends CashWithDrawProcessor {

    public FiveHundredWithDrawProcessor(CashWithDrawProcessor nextCashWithDrawProcessor) {
        super(nextCashWithDrawProcessor);
    }

    public void withdraw(ATM atm, int withDrawalAmount) {
        int required = withDrawalAmount / 500;
        int pendingWithDrawalAmount = withDrawalAmount % 500;
        if (required <= atm.getNoOfFiveHundred()) {
            atm.deductFiveHundred(required);
            System.out.println("No of 500 Notes Dispensed: " + required);
        } else {
            pendingWithDrawalAmount += (required - atm.getNoOfFiveHundred()) * 500;
        }
        if (pendingWithDrawalAmount != 0) {
            super.withdraw(atm, pendingWithDrawalAmount);
        }
    }
}
