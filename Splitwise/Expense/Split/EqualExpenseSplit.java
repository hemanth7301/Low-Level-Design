package Expense.Split;

import java.util.List;

public class EqualExpenseSplit implements ExpenseSplit {
    public void validateSplitRequest(List<Split> splitList, double totalAmount) {
        double amountPresentShouldBe = totalAmount / splitList.size();
        for (Split split : splitList) {
            if (split.getAmountOwe() != amountPresentShouldBe) {
                System.out.println("Amount mismatch");
            }
        }
    }
}
