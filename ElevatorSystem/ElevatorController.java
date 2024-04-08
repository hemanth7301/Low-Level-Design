import java.util.PriorityQueue;

public class ElevatorController {
    PriorityQueue<Integer> upMinPQ;
    PriorityQueue<Integer> downMaxPQ;
    ElevatorCar elevatorCar;

    ElevatorController(ElevatorCar elevatorCar) {

        this.elevatorCar = elevatorCar;
        upMinPQ = new PriorityQueue<>();
        downMaxPQ = new PriorityQueue<>((a, b) -> b - a);
    }

    public void externalRequest(int floor, Direction direction) {
        if (direction == Direction.DOWN) {
            downMaxPQ.offer(floor);
        } else {
            upMinPQ.offer(floor);
        }
    }

    public void internalRequest(int floor, Direction direction) {

    }
}
