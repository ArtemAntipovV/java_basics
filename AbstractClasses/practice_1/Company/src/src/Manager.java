package Company.src.src;

import java.util.Random;

public  class Manager implements Employee {

    public double monthSalary = 50_000; // окладная часть
    private static final double COMISSION = 0.05;// 5% от продаж;
    private int salary;
    private int randomSalary;

    public Manager() {
       this.salary = getMonthSalary();
    }

    @Override
    public int getMonthSalary() {
        Random rand = new Random();
        randomSalary = rand.nextInt(115_000, 140_000);
        salary = (int) ((int) monthSalary + (randomSalary * COMISSION));
        return salary;
    }

    @Override
    public String toString() {
        return "Manager: " + monthSalary + "руб.";

    }

    public int getIncomeForCompany() {
        return randomSalary;
    }

}
