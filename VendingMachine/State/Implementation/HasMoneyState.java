package State.Implementation;

import java.util.List;

import Main.Coin;
import Main.Item;
import Main.VendingMachine;
import State.State;

public class HasMoneyState implements State {
    public HasMoneyState() {
        System.out.println("Vending Machine is in HasMoney State");
    }

    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        return;
    }

    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setVendingMachineState(new SelectionState());
    }

    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        System.out.println("Accepted the coin :" + coin.value);
        vendingMachine.getCoins().add(coin);
    }

    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("You cannot click on StartProductSelection Button ");
    }

    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("You cannot get change in HasMoney state");
    }

    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("You cannot dispense product in HasMoney state");
    }

    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        System.out.println("Amount fully refunded");
        vendingMachine.setVendingMachineState(new IdleState());
        return vendingMachine.getCoins();
    }

    public void updateInventory(VendingMachine vendingMachine, Item item, int code) throws Exception {
        throw new Exception("You cannot update Inventory in HasMoney State");
    }

}