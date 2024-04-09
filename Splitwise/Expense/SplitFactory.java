package Expense;

import Expense.Split.*;
import Expense.Split.ExpenseSplit;

public class SplitFactory {
    public static ExpenseSplit getSplitObject(ExpenseSplitType expenseSplitType) {
        switch (expenseSplitType) {
            case EQUAL:
                return new EqualExpenseSplit();
            case UNEQUAL:
                return new UnEqualExpenseSplit();
            case PERCENTAGE:
                return new PercentageSplit();
            default:
                return null;
        }
    }
}
