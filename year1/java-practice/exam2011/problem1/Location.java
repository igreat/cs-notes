package exam2011.problem1;

import java.util.HashMap;

public abstract class Location {
    private String name;
    private HashMap<String, Employee> employees;

    public Location(String name) {
        this.name = name;
        employees = new HashMap<>();
    }

    public abstract boolean addEmployee(Employee employee);
}