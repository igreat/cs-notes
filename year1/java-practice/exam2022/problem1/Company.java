package exam2022.problem1;

import java.util.List;
import java.util.ArrayList;

public class Company {
    private String name;
    private ExecutiveTeam executiveTeam;
    private List<Employee> employees;

    public Company(String name) {
        this.name = name;
        this.executiveTeam = new ExecutiveTeam();
        this.employees = new ArrayList<>();
    }

    public void addWorker(String name, String department, int pay) {
        employees.add(new Worker(name, department, pay));
    }

    public void addManager(String name, String department, int pay, int bonus) {
        Manager manager = new Manager(name, department, pay, bonus);
        employees.add(manager);
        addToExecutiveTeam(manager);
    }

    private void addToExecutiveTeam(Manager manager) {
        executiveTeam.add(manager);
    }

    public int getTotalPayPerMonth() {
        return employees
                .stream()
                .mapToInt(Employee::getMonthlyPay)
                .sum();
    }

    public static void main(String[] args) {
        Company company = new Company("ACME");
        company.addWorker("Alice", "HR", 3000);
        company.addWorker("Bob", "HR", 2500);
        company.addManager("Charlie", "HR", 5000, 1000);
        System.out.println(company.getTotalPayPerMonth());
    }
}
