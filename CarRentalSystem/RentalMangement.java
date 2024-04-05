import java.util.List;

public class RentalMangement {
    List<User> users;
    List<Store> stores;

    public RentalMangement(List<User> users, List<Store> stores) {
        this.users = users;
        this.stores = stores;
    }

    public Store getStore(Location locationId) {
        return stores.get(0);
    }

}
