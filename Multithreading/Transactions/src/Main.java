
import java.util.Hashtable;
import java.util.Map;


public class Main {

    public static void main(String[] args) {

        Account account1 = new Account();
        account1.setAccNumber("123");
        account1.setBalance(25000000);
        System.out.println("Баланс клиента 1: " + account1.getBalance());

        Account account2 = new Account();
        account2.setAccNumber("234");
        account2.setBalance(25000);
        System.out.println("Баланс клиента 2: " + account2.getBalance());


        // Создаем карту счетов
        Map<String, Account> accounts = new Hashtable<>();
        accounts.put("123", account1);
        accounts.put("234", account2);
        // Создаем банк с картой счетов
        Bank bank = new Bank(accounts);

        Thread[] threads = new Thread[1000];


        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for(int j = 0; j < 100000; j++) {
                    try {
                        bank.transfer("123", "234", 20);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
            threads[i].start();
        }


        // Проверяем финальные балансы
        System.out.println("Финальный баланс клиента 1: " + bank.getBalance("123"));
        System.out.println("Финальный баланс клиента 2: " + bank.getBalance("234"));


    }
}
