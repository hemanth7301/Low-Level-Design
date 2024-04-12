package Main;

public class ATMRoom {
    ATM atm;
    User user;

    public static void main(String args[]) {
        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialize();
        atmRoom.atm.printCurrentATMStatus();
        atmRoom.atm.getATMState().insertCard(atmRoom.atm, atmRoom.user.card);
        atmRoom.atm.getATMState().authenticatePin(atmRoom.atm, atmRoom.user.card, 789326);

        // atmRoom.atm.getATMState().selectOperation(atmRoom.atm, atmRoom.user.card,
        // TransactionType.CHECK_BALANCE);
        // atmRoom.atm.getATMState().displayBalance(atmRoom.atm, atmRoom.user.card);

        atmRoom.atm.getATMState().selectOperation(atmRoom.atm, atmRoom.user.card, TransactionType.CASH_WITHDRAWAL);

        atmRoom.atm.getATMState().cashWithdrawal(atmRoom.atm, atmRoom.user.card, 2700);
        atmRoom.atm.printCurrentATMStatus();

    }

    private void initialize() {
        atm = ATM.getATMObject();
        atm.setATMBalance(10, 2, 1);
        this.user = createUser();
    }

    private User createUser() {
        User user = new User();
        user.setCard(createCard());
        return user;
    }

    private Card createCard() {
        Card card = new Card();
        card.setBankAccount(createBankAccount());
        return card;
    }

    private BankAccount createBankAccount() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.balance = 3000;
        return bankAccount;
    }

}
