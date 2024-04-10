package State.Implementation;

import java.util.ArrayList;
import java.util.List;

import Main.Coin;
import Main.Item;
import Main.VendingMachine;
import State.State;

public class IdleState implements State {
    public IdleState() {
        System.out.println("-----------------------");
        System.out.println("Vending Machine is in Idle State");
    }

    public IdleState(VendingMachine vendingMachine) {
        System.out.println("Vending Machine is in Idle State");
        vendingMachine.setCoins(new ArrayList<>());
    }

    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setVendingMachineState(new HasMoneyState());
    }

    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Click on insert coin");
    }

    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("You cannot insert coin in idle state");
    }

    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("You cannot choose product in idle state");
    }

    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("You cannot get change in idle state");
    }

    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("You cannot dispense product in idle state");
    }

    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        throw new Exception("You cannot get refund in idle state");
    }

    public void updateInventory(VendingMachine vendingMachine, Item item, int code) throws Exception {
        vendingMachine.getInventory().additem(item, code);
    }

}
