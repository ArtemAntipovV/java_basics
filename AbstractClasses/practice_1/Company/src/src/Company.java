package Company.src.src;

import java.util.*;

public class Company  {

    private final ArrayList<Employee> employeeArrayList = new ArrayList<>();

    private int income; //доход компании
    private double salary;
    private int employee;


    public Company() {
    }

    public void hire(Employee employee) { //найм одного сотрудника — hire(Employee employee),
        employeeArrayList.add(employee);
        if (employee instanceof Manager) {
            income +=((Manager) employee).getIncomeForCompany();
        }
    }

    public void hireAll(Collection<Employee> employees) {
        getEMPLOYEES_LIST().remove(employee);

    }

    public void fire(Employee employee) {
        this.employeeArrayList.remove(employee);
    }

    public List<Employee> getTopSalaryStaff(int count) {
        return getFilteredLimitedList(count, (o1, o2) -> o2.getMONTH_SALARY() - o1.getMONTH_SALARY());

    }

    public List<Employee> getLowerSalaryStaff(int count) {
        return getFilteredLimitedList(count, (o1, o2) -> o1.getMONTH_SALARY() - o2.getMONTH_SALARY());
    }

    private List<Employee> getFilteredLimitedList(int count, Comparator<Employee> comparator) {
        List<Employee> copyList = new ArrayList<>(employeeArrayList);
        Collections.sort(copyList, comparator);
        List<Employee> result = new ArrayList<>();
        for (int i = 0; i < count; i++) result.add(copyList.get(i));
        return result;
    }

    public int countEmployeesList() {
        return employeeArrayList.size();
    }

    public ArrayList<Employee> getEMPLOYEES_LIST() {
        return employeeArrayList;
    }

    public int getIncome() {
        return income;
    }

}
