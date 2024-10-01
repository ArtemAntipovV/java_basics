package Company.src.src;

public class TopManager  implements Employee {

    public int MONTH_SALARY = 150_000; // фикс
    public double COMISSION = 2.50;  // бонуса в виде 150% от заработной платы, если доход компании более 10 млн рублей.
    private int salary;
    private final int incomeTop;

    public TopManager(Company company) {
        this.salary = getMONTH_SALARY();
        incomeTop = company.getIncome();

    }


    @Override
    public int getMONTH_SALARY() {
        if (incomeTop > 10_000_000) {
            salary = (int) (MONTH_SALARY + (incomeTop * COMISSION));
        } else {
            return MONTH_SALARY;
        }
        return salary;
    }

    @Override
    public String toString() {
        return "TopManager " + salary + " руб.";
    }



}
