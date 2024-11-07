import javax.security.auth.login.AccountLockedException;

public class Account {


    private String accNumber;
    private long balance;
    private boolean locked;

    public long getBalance() {
        return balance;
    }

    public boolean isLocked() {
        return locked;
    }

    public void unlock() {
        locked = false;
    }

    public void lock() {
        locked = true;
    }
    public void setBalance(long balance) {
        this.balance = balance;
    }


    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public void withdraw(long amount) throws AccountLockedException {

        if (locked) {
            throw new AccountLockedException("Счет заблокирован");
        }
        if (balance < amount) {
            System.out.println("Недостаточно средств на счете");
        }
        balance -= amount;
    }

    public void deposit(long amount) throws AccountLockedException {
        if (locked) {
            throw new AccountLockedException("Счет заблокирован");
        }
        balance += amount;
    }
    }

