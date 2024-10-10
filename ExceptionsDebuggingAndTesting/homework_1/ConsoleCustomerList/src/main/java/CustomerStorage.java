import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//class MyCustomException extends RuntimeException {
//    public MyCustomException() {
//        super();
//    }
//    public MyCustomException(String message) {
//        super(message);
//    }
//
//
//
//}

public class CustomerStorage {
    private final Map<String, Customer> storage;


    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws RuntimeException {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

//        String[] components = data.split("\\s+");
//        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
//        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));

        try {
            String[] components = data.split("\\s+");
            if (components.length != 4) {
                throw new IllegalArgumentException("Количество слов в строке должно быть равно 4.");
            }
            String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
            storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
            if (!isValid(components[INDEX_EMAIL])) {
                throw new IllegalArgumentException("Неверный email");
            }
            if (!isValidTel(components[INDEX_PHONE])) {
                throw new IllegalArgumentException("Неверный телефон");
            }
        } catch (NullPointerException e) {
            // Обработка исключений для неверного email или номера
            System.err.println("Неверный email или номер: " + e.getMessage());
        }
}


    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }

    public static boolean isValid(String email) {
        return email.matches("^[\\w-\\.]+@[\\w-]+(\\.[\\w-]+)*\\.[a-z]{2,}$");
    }
//
    public static boolean isValidTel(String phone) {
        return phone.matches("^\\+?7\\d{10}$");
    }

    зги

    }


