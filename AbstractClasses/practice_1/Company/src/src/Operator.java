package Company.src.src;

public class Operator implements Employee {


    public int monthSalary = 45_000; // зп только фикс
    private int salary;

    public Operator() {
        this.salary = getMonthSalary();
    }

    @Override
    public int getMonthSalary() {
        salary = monthSalary;
        return  salary;
    }

    @Override
    public String toString() {
        return "Operator: " + salary +
                "руб.";
    }
}
