package Main;

import State.State;

public class Main {
    public static void main(String args[]) {

        VendingMachine vendingMachine = new VendingMachine();
        try {

            System.out.println("-----------------------");
            System.out.println("Filling up the inventory");
            fillUpInventory(vendingMachine);
            System.out.println("-----------------------");
            displayInventory(vendingMachine);

            System.out.println("clicking on InsertCoinButton");
            State vendingState = vendingMachine.getVendingMachineState();
            vendingState.clickOnInsertCoinButton(vendingMachine);
            vendingState = vendingMachine.getVendingMachineState();
            vendingState.insertCoin(vendingMachine, Coin.QUARTER);
            vendingState.insertCoin(vendingMachine, Coin.QUARTER);
            System.out.println("-----------------------");

            System.out.println("clicking on ProductSelectionButton");
            vendingState.clickOnStartProductSelectionButton(vendingMachine);
            vendingState = vendingMachine.getVendingMachineState();
            vendingState.chooseProduct(vendingMachine, 102);
            System.out.println("-----------------------");

            displayInventory(vendingMachine);
        } catch (Exception e) {
            displayInventory(vendingMachine);
            System.out.println(e.getMessage());
        }

    }

    private static void fillUpInventory(VendingMachine vendingMachine) {
        ItemShelf[] slots = vendingMachine.getInventory().getShelfs();
        for (int i = 0; i < slots.length; i++) {
            Item newItem = new Item();
            if (i >= 0 && i < 3) {
                newItem.setItemType(ItemType.COKE);
                newItem.setPrice(12);
            } else if (i >= 3 && i < 5) {
                newItem.setItemType(ItemType.CHIPS);
                newItem.setPrice(9);
            } else if (i >= 5 && i < 7) {
                newItem.setItemType(ItemType.JUICE);
                newItem.setPrice(13);
            } else if (i >= 7 && i < 10) {
                newItem.setItemType(ItemType.CAKE);
                newItem.setPrice(7);
            }
            slots[i].setItem(newItem);
            slots[i].setSoldOut(false);
        }
    }

    private static void displayInventory(VendingMachine vendingMachine) {

        ItemShelf[] slots = vendingMachine.getInventory().getShelfs();
        for (int i = 0; i < slots.length; i++) {

            System.out.println("Code : " + slots[i].getCode() +
                    " Item : " + slots[i].getItem().getItemType().name() +
                    " Price : " + slots[i].getItem().getPrice() +
                    " isAvailable : " + !slots[i].isSoldOut());
        }
    }

}
