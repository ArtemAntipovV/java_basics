public class Encapsulation {

     private int currentFloor = 1; // текущий этаж
     private int minFloor; // минимальный этаж
     private int maxFloor; // максимальный этаж

    public Encapsulation(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public  getCurrentFloor() {
        return currentFloor;
    }


}
