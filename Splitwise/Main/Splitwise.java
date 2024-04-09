package Main;

import java.util.ArrayList;
import java.util.List;

import Expense.ExpenseSplitType;
import Expense.Split.Split;
import Group.Group;
import Group.GroupController;
import User.User;
import User.UserController;

public class Splitwise {
    UserController userController;
    GroupController groupController;
    BalanceSheetController balanceSheetController;

    Splitwise() {
        userController = new UserController();
        groupController = new GroupController();
        balanceSheetController = new BalanceSheetController();
    }

    public void demo() {

        setupUserAndGroup();

        Group group = groupController.getGroup("G001");
        group.addMember(userController.getUser("ID002"));
        group.addMember(userController.getUser("ID003"));

        List<Split> splits = new ArrayList<>();
        Split split1 = new Split(userController.getUser("ID001"), 300);
        Split split2 = new Split(userController.getUser("ID002"), 300);
        Split split3 = new Split(userController.getUser("ID003"), 300);
        splits.add(split1);
        splits.add(split2);
        splits.add(split3);
        group.createExpense("Exp001", "Snacks", 900, splits, ExpenseSplitType.EQUAL,
                userController.getUser("ID001"));

        for (User user : userController.getAllUsers()) {
            balanceSheetController.showBalanceSheet(user);
        }
    }

    public void setupUserAndGroup() {

        addUsersToSplitwiseApp();
        User user1 = userController.getUser("ID001");
        groupController.createNewGroup("G001", "MITRULU", user1);

    }

    private void addUsersToSplitwiseApp() {

        User user1 = new User("ID001", "Hemanth");
        User user2 = new User("ID002", "Balaji");
        User user3 = new User("ID003", "Phani");

        userController.addUser(user1);
        userController.addUser(user2);
        userController.addUser(user3);
    }

}
