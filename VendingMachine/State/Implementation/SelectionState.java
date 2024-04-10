package State.Implementation;

import java.util.List;

import Main.Coin;
import Main.Item;
import Main.VendingMachine;
import State.State;

public class SelectionState implements State {
    public SelectionState() {
        System.out.println("Machine is currently in Selection State");
    }

    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("You cannot click on insert coin in Selection State");
    }

    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        return;
    }

    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("You cannot insert coin in Selection State");
    }

    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        Item item = machine.getInventory().getItem(codeNumber);
        int paidByUser = 0;
        for (Coin coin : machine.getCoins()) {
            paidByUser += coin.value;
        }
        if (paidByUser < item.getPrice()) {
            System.out.println("Amount you paid : " + paidByUser);
            System.out.println("Price of item :" + item.getPrice());
            refundFullMoney(machine);
            throw new Exception("Insufficient funds");
        } else {
            if (paidByUser - item.getPrice() > 0)
                getChange(paidByUser - item.getPrice());
            machine.setVendingMachineState(new DispenseState(machine, codeNumber));
        }
    }

    public int getChange(int returnChangeMoney) throws Exception {
        System.out.println("Change dispensed in tray :" + returnChangeMoney);
        return returnChangeMoney;
    }

    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("You cannot dispense product in Selection State");
    }

    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        System.out.println("Amount fully refunded");
        machine.setVendingMachineState(new IdleState());
        return machine.getCoins();
    }

    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("Inventory cannot be updated in Selection State");
    }

}
