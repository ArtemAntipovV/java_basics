public class Elevator {

    private int currentFloor = 1; // текущий этаж
    private int minFloor; // минимальный этаж
    private int maxFloor; // максимальный этаж

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveDown() {
        currentFloor = currentFloor > minFloor ? currentFloor - 1 : currentFloor; // уменьшающий значение переменной currentFloor на единицу
    }

    public void moveUp() {
        currentFloor = currentFloor < maxFloor ? currentFloor + 1 : currentFloor; // перемещающий лифт на один этаж вверх.

    }

    public void move(int floor) {

    }


}

