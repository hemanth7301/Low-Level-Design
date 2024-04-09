package Main;

import java.util.HashMap;
import java.util.Map;

public class UserExpenseBalanceSheet {

    Map<String, Balance> userVsBalance;
    double totalExpense;
    double totalAmount;
    double totalYouOwe;
    double totalYouNeedToGet;

    public UserExpenseBalanceSheet() {
        userVsBalance = new HashMap<>();
        this.totalExpense = 0;
        this.totalYouOwe = 0;
        this.totalYouNeedToGet = 0;
    }

    public Map<String, Balance> getUserVsBalance() {
        return userVsBalance;
    }

    public void setUserVsBalance(Map<String, Balance> userVsBalance) {
        this.userVsBalance = userVsBalance;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getTotalYouOwe() {
        return totalYouOwe;
    }

    public void setTotalYouOwe(double totalYouOwe) {
        this.totalYouOwe = totalYouOwe;
    }

    public double getTotalYouNeedToGet() {
        return totalYouNeedToGet;
    }

    public void setTotalYouNeedToGet(double totalYouNeedToGet) {
        this.totalYouNeedToGet = totalYouNeedToGet;
    }

}
