public class Inventory {
    ItemShelf[] inventory;

    public Inventory(int itemCount) {
        inventory = new ItemShelf[itemCount];
        initializeInventory();
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    public void initializeInventory() {
        int code = 101;
        for (int i = 0; i < inventory.length; i++) {
            ItemShelf space = new ItemShelf();
            space.setCode(code);
            space.setSoldOut(true);
            inventory[i] = space;
            code++;
        }
    }

    public void additem(Item item, int code) throws Exception {
        for (ItemShelf shelf : inventory) {
            if (shelf.code == code) {
                if (shelf.isSoldOut()) {
                    shelf.item = item;
                    shelf.setSoldOut(false);
                } else {
                    throw new Exception("Item is already present");
                }
            }
        }
    }

    public Item getItem(int code) throws Exception {
        for (ItemShelf shelf : inventory) {
            if (shelf.code == code) {
                if (shelf.isSoldOut()) {
                    throw new Exception("Item is already Sold");
                } else {
                    return shelf.item;
                }
            }
        }
        throw new Exception("Invalid Code");
    }

    public void updateSoldOutItem(int code) {
        for (ItemShelf shelf : inventory) {
            if (shelf.code == code) {
                shelf.setSoldOut(true);
            }
        }
    }
}
