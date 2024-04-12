package WithDrawalProcessor;

import Main.ATM;

public class CashWithDrawProcessor {
    CashWithDrawProcessor nextCashWithDrawProcessor;

    public CashWithDrawProcessor(CashWithDrawProcessor nextCashWithDrawProcessor) {
        this.nextCashWithDrawProcessor = nextCashWithDrawProcessor;
    }

    public void withdraw(ATM atm, int withDrawalAmount) {
        if (nextCashWithDrawProcessor != null) {
            nextCashWithDrawProcessor.withdraw(atm, withDrawalAmount);
        }
    }

}
