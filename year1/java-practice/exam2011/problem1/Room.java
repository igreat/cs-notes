package exam2011.problem1;

import java.util.HashMap;

public class Room {
    private int capacity;
    private HashMap<String, Employee> employees;

    public Room(int capacity) {
        this.capacity = capacity;
        employees = new HashMap<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getFreeCapacity() {
        return capacity - employees.size();
    }

    public void addEmployee(Employee employee) {
        employees.put(employee.getName(), employee);
    }

    public boolean isEmployeeInRoom(String name) {
        return employees.containsKey(name);
    }
}