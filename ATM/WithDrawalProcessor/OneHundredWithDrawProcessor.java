package WithDrawalProcessor;

import Main.ATM;

public class OneHundredWithDrawProcessor extends CashWithDrawProcessor {

    public OneHundredWithDrawProcessor(CashWithDrawProcessor nextCashWithDrawProcessor) {
        super(nextCashWithDrawProcessor);
    }

    public void withdraw(ATM atm, int withDrawalAmount) {
        int required = withDrawalAmount / 100;
        int pendingWithDrawalAmount = withDrawalAmount % 100;
        if (required <= atm.getNoOfOneHundred()) {
            atm.deductOneHundred(required);
            System.out.println("No of 100 Notes Dispensed: " + required);
        } else {
            pendingWithDrawalAmount += (required - atm.getNoOfOneHundred()) * 100;
        }
        if (pendingWithDrawalAmount != 0) {
            System.out.println("Oops something went wrong");
        }
    }
}