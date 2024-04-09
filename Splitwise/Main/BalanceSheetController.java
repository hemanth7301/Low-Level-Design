package Main;

import java.util.*;

import Expense.Split.Split;
import User.User;

public class BalanceSheetController {
    public void updateUserExpenseBalanceSheet(User expensePaidBy, List<Split> splits, double totalExpenseAmount) {
        UserExpenseBalanceSheet paidByUserExpenseSheet = expensePaidBy.getUserExpenseBalanceSheet();
        paidByUserExpenseSheet.setTotalAmount(paidByUserExpenseSheet.getTotalAmount() + totalExpenseAmount);

        for (Split split : splits) {

            User userOwe = split.getUser();
            UserExpenseBalanceSheet oweUserExpenseSheet = userOwe.getUserExpenseBalanceSheet();
            double oweAmount = split.getAmountOwe();

            if (expensePaidBy.getUserId().equals(userOwe.getUserId())) {
                paidByUserExpenseSheet.setTotalExpense(paidByUserExpenseSheet.getTotalExpense() + oweAmount);
            } else {
                paidByUserExpenseSheet.setTotalYouNeedToGet(paidByUserExpenseSheet.getTotalYouNeedToGet() + oweAmount);

                Balance userOweBalance;
                if (paidByUserExpenseSheet.getUserVsBalance().containsKey(userOwe.getUserId())) {

                    userOweBalance = paidByUserExpenseSheet.getUserVsBalance().get(userOwe.getUserId());
                } else {
                    userOweBalance = new Balance();
                    paidByUserExpenseSheet.getUserVsBalance().put(userOwe.getUserName(), userOweBalance);
                }

                userOweBalance.setAmountYouGetNeedToGetBack(userOweBalance.getAmountYouGetNeedToGetBack() + oweAmount);

                oweUserExpenseSheet.setTotalYouOwe(oweUserExpenseSheet.getTotalYouOwe() + oweAmount);
                oweUserExpenseSheet.setTotalExpense(oweUserExpenseSheet.getTotalExpense() + oweAmount);

                Balance userPaidBalance;
                if (oweUserExpenseSheet.getUserVsBalance().containsKey(expensePaidBy.getUserId())) {
                    userPaidBalance = oweUserExpenseSheet.getUserVsBalance().get(expensePaidBy.getUserId());
                } else {
                    userPaidBalance = new Balance();
                    oweUserExpenseSheet.getUserVsBalance().put(expensePaidBy.getUserName(), userPaidBalance);
                }
                userPaidBalance.setAmountYouOwe(userPaidBalance.getAmountYouOwe() + oweAmount);
            }
        }

    }

    public void showBalanceSheet(User user) {
        System.out.println("---------------------------------------");

        System.out.println("Balance sheet of user : " + user.getUserName());

        UserExpenseBalanceSheet userExpenseBalanceSheet = user.getUserExpenseBalanceSheet();

        System.out.println("Total Expenses: " + userExpenseBalanceSheet.getTotalExpense());
        System.out.println("Total You need to get back: " + userExpenseBalanceSheet.getTotalYouNeedToGet());
        System.out.println("Total You Owe: " + userExpenseBalanceSheet.getTotalYouOwe());
        System.out.println("Total Payment Made: " + userExpenseBalanceSheet.getTotalAmount());
        for (Map.Entry<String, Balance> entry : userExpenseBalanceSheet.getUserVsBalance().entrySet()) {

            String userName = entry.getKey();
            Balance balance = entry.getValue();

            System.out.println("user : " + userName + " You need to get back:" + balance.getAmountYouGetNeedToGetBack()
                    + " You Owe:"
                    + balance.getAmountYouOwe());
        }

        System.out.println("---------------------------------------");

    }
}
