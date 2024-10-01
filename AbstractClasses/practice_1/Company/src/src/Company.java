package Company.src.src;

import java.util.*;

public class Company  {

    private final ArrayList<Employee> EMPLOYEES_LIST = new ArrayList<>();

    protected int income; //доход компании
    protected double salary;
    protected int employee;


    public Company() {
    }

    public void hire(Employee employee) { //найм одного сотрудника — hire(Employee employee),
        EMPLOYEES_LIST.add(employee);
        if (employee instanceof Manager) {
            income +=((Manager) employee).getIncomeForCompany();
        }
    }

    public void hireAll(Collection<Employee> employees) {
        getEMPLOYEES_LIST().remove(employee);

    }

    public void fire(Employee employee) {
        this.EMPLOYEES_LIST.remove(employee);
    }

    public List<Employee> getTopSalaryStaff(int count) {
        return getFilteredLimitedList(count, (o1, o2) -> o2.getMonthSalary() - o1.getMonthSalary());

    }

    public List<Employee> getLowerSalaryStaff(int count) {
        return getFilteredLimitedList(count, (o1, o2) -> o1.getMonthSalary() - o2.getMonthSalary());
    }

    private List<Employee> getFilteredLimitedList(int count, Comparator<Employee> comparator) {
        List<Employee> copyList = new ArrayList<>(EMPLOYEES_LIST);
        Collections.sort(copyList, comparator);
        List<Employee> result = new ArrayList<>();
        for (int i = 0; i < count; i++) result.add(copyList.get(i));
        return result;
    }

    public int countEmployeesList() {
        return EMPLOYEES_LIST.size();
    }

    public ArrayList<Employee> getEMPLOYEES_LIST() {
        return EMPLOYEES_LIST;
    }

    public int getIncome() {
        return income;
    }

}
