package Main;

public class Inventory {
    ItemShelf[] shelfs;

    public Inventory(int itemCount) {
        shelfs = new ItemShelf[itemCount];
        initializeShelfs();
    }

    public ItemShelf[] getShelfs() {
        return shelfs;
    }

    public void setShelfs(ItemShelf[] inventory) {
        this.shelfs = inventory;
    }

    public void initializeShelfs() {
        int code = 101;
        for (int i = 0; i < shelfs.length; i++) {
            ItemShelf space = new ItemShelf();
            space.setCode(code);
            space.setSoldOut(true);
            shelfs[i] = space;
            code++;
        }
    }

    public void additem(Item item, int code) throws Exception {
        for (ItemShelf shelf : shelfs) {
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
        for (ItemShelf shelf : shelfs) {
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
        for (ItemShelf shelf : shelfs) {
            if (shelf.code == code) {
                shelf.setSoldOut(true);
            }
        }
    }
}
