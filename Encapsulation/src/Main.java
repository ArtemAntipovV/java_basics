import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
//
//        Elevator elevator = new Elevator(-3, 26);
//        while (true) {
//            System.out.print("Введите номер этажа: ");
//            int floor = new Scanner(System.in).nextInt();
//            elevator.move(floor);
//
            Dimensions dimensions = new Dimensions(99, 33, 56);
            Cargo cargo = new Cargo(345, 33,"Екатерибург","опасный груз",
                    "324234fdws", false, false);
            System.out.println(cargo.toString());
            Dimensions copyDimension = dimensions;
            Cargo copyCargo = cargo.setGabarites(44);
            Cargo copyCopyCargo = copyCargo.setDeliveryAdress("Г Большой исток");
            System.out.println(copyCargo);
            System.out.println(copyCopyCargo);
    }
}