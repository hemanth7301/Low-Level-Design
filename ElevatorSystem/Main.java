import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Floor> floorList = new ArrayList<>();
        Floor floor1 = new Floor(1);
        Floor floor2 = new Floor(2);
        Floor floor3 = new Floor(3);
        floorList.add(floor1);
        floorList.add(floor2);
        floorList.add(floor3);

        Building building = new Building(floorList);
        building.getFloors();

    }
}
