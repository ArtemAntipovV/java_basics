
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;


public class CustomerStorage {
    private static final Logger log = LogManager.getLogger(CustomerStorage.class);
    private final Map<String, Customer> storage;


    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws RuntimeException {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        try {
            String[] components = data.split("\\s+");
            if (components.length != 4) {
                log.log(Level.INFO, "Пользователь ввел неверное количество строк!");
                throw new IllegalArgumentException("Количество слов в строке должно быть равно 4.");
            }
            String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
            if (!isValidName(components[INDEX_NAME])) {
                log.log(Level.INFO, "Пользователь ввел неверное имя!");
                throw new IllegalArgumentException("Неверное имя!");
            }
            if (!isValidName(components[INDEX_SURNAME])) {
                log.log(Level.INFO, "Пользователь ввел неверную фамилию!");
                throw new IllegalArgumentException("Неверная фамилия!");
            }
            if (!isValid(components[INDEX_EMAIL])) {
                log.log(Level.INFO, "Пользователь ввел неверный email!");
                throw new IllegalArgumentException("Неверный email!");
            }
            if (!isValidTel(components[INDEX_PHONE])) {
                log.log(Level.INFO, "Пользователь ввел неверный телефон!");
                throw new IllegalArgumentException("Неверный телефон!");
            }
            storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
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

    public static boolean isValidTel(String phone) {
        return phone.matches("^\\+?7\\d{10}$");
    }

    public static boolean isValidName(String name) {
        return name.matches("^[а-яА-ЯёЁ0-9_-]{3,23}$");
    }

}


