package exam2012.problem1;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Company {
    String name;
    List<Employee> employees;
    ExecutiveTeam executiveTeam;

    public Company(String name) {
        this.name = name;
        employees = new ArrayList<>();
        executiveTeam = new ExecutiveTeam();
    }

    public void addWorker(String name, String department, int pay) {
        employees.add(new Worker(name, department, pay));
    }

    public void addManager(String name, String department, int pay, int bonus) {
        employees.add(new Manager(name, department, pay, bonus));
    }

    public void addToExecutiveTeam(Manager manager) {
        employees.add(manager);
        executiveTeam.add(manager);
    }

    public int getTotalPayPerMonth() {
        return employees
                .stream()
                .mapToInt(Employee::getMonthlyPay)
                .sum();
    }
}