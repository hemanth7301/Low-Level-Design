package States;

import Main.*;

public class SelectOperationState extends ATMState {

    SelectOperationState() {
        showOperations();
    }

    public void selectOperation(ATM atm, Card card, TransactionType transactionType) {
        switch (transactionType) {
            case CHECK_BALANCE:
                atm.setATMState(new CheckBalanceState());
                break;
            case CASH_WITHDRAWAL:
                atm.setATMState(new CashWithdrawalState());
                break;
            default:
                System.out.println("Invalid Operation");
                exit(atm);
        }
    }

    public void showOperations() {
        System.out.println("Select Transaction Type from below");
        TransactionType.showAllTransactionTypes();
    }
}
