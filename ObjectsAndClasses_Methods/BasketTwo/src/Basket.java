public class Basket {


    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;

    private double totalWeight = 0;
    private static int totalCost; //Общая стоимость корзин
    private static int amountBasket; // кол - во корзин
    private static int averagePrice; // отношение общей стоимости всех корзин к общему количеству всех товаров
    private static int averageCostBasket; // отношение общей стоимости всех корзин к количеству корзин




    public Basket() {
        inaverageCostBasket(1);
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public static int getaveragePrice() {
        return averagePrice;
    }

    public static int getAverageCostBasket() {
        return averageCostBasket;
    }

    public Basket(String items, int totalPrice, double weight) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
        this.totalWeight = weight * count;



    }
    public static int getTotalCost() {
        return totalCost;
    }

    public static int getAmountBasket() {
        return amountBasket;
    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public static void inaverageCostBasket(int averageCostBasket) {
        Basket.averageCostBasket = Basket.averageCostBasket + averageCostBasket;

    }


    public void add(String name, int price, int count) {

        add(name, price, count, 1);
    }

    public void add(String name, int price, int count, double weight) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " шт. - " + price + " руб " + "\nBес товара: " + weight + " г";
        totalPrice = totalPrice + count * price;
        totalWeight = totalWeight + weight * count;
        totalCost = totalPrice;
        amountBasket = amountBasket + count;
        averagePrice = totalCost / amountBasket;
        averageCostBasket = totalCost / averageCostBasket;


    }

    public void clear() {
        items = "";
        totalPrice = 0;
        totalWeight = 0;
        totalCost = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
        System.out.println("\n" + "Общий вес корзины: " + totalWeight + " г");
        System.out.println("Cумма всех корзин: " + totalCost + " руб");
        System.out.println("Количество товаров во всех корзинах: " + amountBasket + " шт");
        System.out.println("Средняя цена товара: " + averagePrice + " руб");
        System.out.println("Средняя стоиомсть корзин: " + averageCostBasket + " руб");

    }
}
