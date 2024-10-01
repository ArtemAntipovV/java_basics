package Company.src.src;

public class Main {
    public static void main(String[] args) {
        Company companyDemo = new Company();
        for (int i = 0; i < 180; i++) {
            Employee operator = new Operator();
            companyDemo.hire(operator);
        }
        for (int i = 0; i < 80; i++) {
            Employee manager = new Manager();
            companyDemo.hire(manager);
        }
        for (int i = 0; i < 10; i++) {
            Employee topManager = new TopManager(companyDemo);
            companyDemo.hire(topManager);
        }
        System.out.println("Заработанных денег для компании: " + companyDemo.getIncome() + " руб.");
        System.out.println("Всего сотрудников: " + companyDemo.countEmployeesList());

        System.out.println("Список из 10 самых высоких зарплат: ");
        for (Employee topSalaryStaff : companyDemo.getTopSalaryStaff(10))
            System.out.println(topSalaryStaff);
        System.out.println();
        System.out.println("Список из 30 самых низких зарплат: ");
        for (Employee lowestSalaryStaff : companyDemo.getLowerSalaryStaff(30))
            System.out.println(lowestSalaryStaff);

        int size = companyDemo.countEmployeesList() / 2;
        companyDemo.getEMPLOYEES_LIST().subList(0, size).clear();
        System.out.println("Всего сотрудников: " + companyDemo.countEmployeesList());

        System.out.println("Список из 10 самых высоких зарплат: ");
        for (Employee topSalaryStaff : companyDemo.getTopSalaryStaff(10))
            System.out.println(topSalaryStaff);
        System.out.println();
        System.out.println("Список из 30 самых низких зарплат: ");
        for (Employee lowestSalaryStaff : companyDemo.getLowerSalaryStaff(30))
            System.out.println(lowestSalaryStaff);
    }
}
