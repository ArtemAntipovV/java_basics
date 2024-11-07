import javax.security.auth.login.AccountLockedException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

public class Bank {

    private Hashtable<String, Account> accounts;
    private final Random random = new Random();

    public Bank(Map<String, Account> accounts) {
        this.accounts = (Hashtable<String, Account>) accounts;
    }

    public Bank(String number, Account account) {
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public synchronized void  transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        if (amount > 50000) {
            if (isFraud(fromAccountNum, toAccountNum, amount)) {
                lockAccounts(fromAccountNum, toAccountNum);
                System.out.println("Транзакция заблокирована из-за подозрений на мошенничество.");
            }
        }
        Account accountFrom = accounts.get(fromAccountNum);
        Account accountTo = accounts.get(toAccountNum);

        if (accountFrom == null || accountTo == null) {
            System.out.println("Неверный номер счета");
        }

        if (accountFrom.getBalance() < amount) {
            System.out.println("Недостаточно средств на счете");
        }
        // Уменьшаем баланс отправителя
        try {
            accountFrom.withdraw(amount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Увеличиваем баланс получателя
        try {
            accountTo.deposit(amount);
        } catch (Exception e) {
           e.printStackTrace();
        }

        accounts.put(fromAccountNum, accountFrom);
        accounts.put(toAccountNum, accountTo);
    }

    private void lockAccounts(String fromAccountNum, String toAccountNum) {
        Account accountFrom = accounts.get(fromAccountNum);
        Account accountTo = accounts.get(toAccountNum);

        if (accountFrom != null) {
            accountFrom.lock();
            accounts.put(fromAccountNum, accountFrom);
        }

        if (accountTo != null) {
            accountTo.lock();
            accounts.put(toAccountNum, accountTo);
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        Account account = accounts.get(accountNum);
        return account.getBalance();
    }

    public long getSumAllAccounts() {
        return accounts.values().stream()
                .mapToLong(Account::getBalance)
                .sum();
    }

}
