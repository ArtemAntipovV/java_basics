public class Main {

    public static void main(String[] args) {

        Arithmetic arithmetic = new Arithmetic(5,6);
        System.out.println("Сумма чисел: " + arithmetic.sum());

        Arithmetic arithmetic1 = new Arithmetic(5,6);
        System.out.println("Произведение чисел: " + arithmetic1.multiNumber());

        Arithmetic arithmetic2 = new Arithmetic(5,6);
        System.out.println("Наибольшее число: " + arithmetic2.maximalNumber());

        Arithmetic arithmetic3 = new Arithmetic(5,6);
        System.out.println("Наибольшее число: " + arithmetic3.minimalNumber());






        Basket basket = new Basket();
        basket.add("Milk", 40,5,3);
        basket.print("Milk");



    }
}
