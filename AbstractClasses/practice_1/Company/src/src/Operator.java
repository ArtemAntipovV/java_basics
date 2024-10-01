package Company.src.src;

public class Operator implements Employee {


    public int MONTH_SALARY = 45_000; // зп только фикс
    private int salary;

    public Operator() {
        this.salary = getMONTH_SALARY();
    }

    @Override
    public int getMONTH_SALARY() {
        salary = MONTH_SALARY;
        return  salary;
    }

    @Override
    public String toString() {
        return "Operator: " + salary +
                "руб.";
    }
}
