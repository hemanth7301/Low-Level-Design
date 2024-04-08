public class ElevatorCar {
    int id;
    int currentFloor;
    ElevatorDisplay elevatorDisplay;
    ElevatorDoor elevatorDoor;
    Direction direction;
    ElevatorState elevatorState;
    InternalButtons internalButtons;

    public ElevatorCar() {
        elevatorDisplay = new ElevatorDisplay();
        internalButtons = new InternalButtons();
        elevatorState = ElevatorState.IDLE;
        currentFloor = 0;
        direction = Direction.UP;
        elevatorDoor = new ElevatorDoor();

    }

    public void showDisplay() {
        elevatorDisplay.showDisplay();
    }

    public void pressButton(int destination) {
        internalButtons.pressButton(destination, this);
    }

    public void setDisplay() {
        this.elevatorDisplay.setDisplay(currentFloor, direction);
    }

    boolean moveElevator(Direction dir, int destinationFloor) {
        int startFloor = currentFloor;
        if (dir == Direction.UP) {
            for (int i = startFloor; i <= destinationFloor; i++) {

                this.currentFloor = startFloor;
                setDisplay();
                showDisplay();
                if (i == destinationFloor) {
                    elevatorDoor.openDoor();
                    elevatorDoor.closeDoor();
                    return true;
                }
            }
        }

        if (dir == Direction.DOWN) {
            for (int i = startFloor; i >= destinationFloor; i--) {

                this.currentFloor = startFloor;
                setDisplay();
                showDisplay();
                if (i == destinationFloor) {
                    elevatorDoor.openDoor();
                    elevatorDoor.closeDoor();
                    return true;
                }
            }
        }
        return false;
    }
}
