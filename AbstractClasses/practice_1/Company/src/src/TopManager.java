package Company.src.src;

public class TopManager  implements Employee {

    public int monthSalary = 150_000; // фикс
    public double commission = 2.50;  // бонуса в виде 150% от заработной платы, если доход компании более 10 млн рублей.
    private int salary;
    private final int incomeTop;

    public TopManager(Company company) {
        this.salary = getMonthSalary();
        incomeTop = company.getIncome();

    }


    @Override
    public int getMonthSalary() {
        if (incomeTop > 10_000_000) {
            salary = (int) (monthSalary + (incomeTop * commission));
        } else {
            return  monthSalary;
        }
        return salary;
    }

    @Override
    public String toString() {
        return "TopManager " + salary + " руб.";
    }



}
