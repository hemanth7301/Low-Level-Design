package Main;

import States.ATMState;
import States.IdleState;

public class ATM {
    private static ATM ATMobject = new ATM();
    int noOfFiveHundred;
    int noofTwoThousand;
    int noOfOneHundred;
    int ATMBalance;
    ATMState ATMState;

    private ATM() {
    }

    public ATMState getATMState() {
        return ATMState;
    }

    public void setATMState(ATMState atmState) {
        this.ATMState = atmState;
    }

    public static ATM getATMObject() {
        ATMobject.setATMState(new IdleState());
        return ATMobject;
    }

    public int getATMBalance() {
        return this.ATMBalance;
    }

    public void setATMBalance(int noOfOneHundred, int noOfFiveHundred, int noofTwoThousand) {
        this.ATMBalance = 100 * noOfOneHundred + 500 * noOfFiveHundred + 2000 * noofTwoThousand;
        this.noOfFiveHundred = noOfFiveHundred;
        this.noofTwoThousand = noofTwoThousand;
        this.noOfOneHundred = noOfOneHundred;
    }

    public int getNoOfFiveHundred() {
        return this.noOfFiveHundred;
    }

    public int getNoOfTwoThousand() {
        return this.noofTwoThousand;
    }

    public int getNoOfOneHundred() {
        return this.noOfOneHundred;
    }

    public void deductOneHundred(int num) {
        this.noOfOneHundred -= num;
    }

    public void deductFiveHundred(int num) {
        this.noOfFiveHundred -= num;
    }

    public void deductTwoThousand(int num) {
        this.noofTwoThousand -= num;
    }

    public void deductATMBalance(int withDrawalAmount) {
        this.ATMBalance -= withDrawalAmount;
    }

    public void printCurrentATMStatus() {
        System.out.println("-----------------------------");
        System.out.println("Balance: " + this.ATMBalance);
        System.out.println("2k Notes: " + this.noofTwoThousand);
        System.out.println("500 Notes: " + this.noOfFiveHundred);
        System.out.println("100 Notes: " + this.noOfOneHundred);
        System.out.println("-----------------------------");

    }

}
