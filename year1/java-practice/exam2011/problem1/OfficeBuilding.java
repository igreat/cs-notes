package exam2011.problem1;

import java.util.ArrayList;
import java.util.List;

public class OfficeBuilding extends Location {
    private List<Room> rooms;

    public OfficeBuilding(String name) {
        super(name);
        rooms = new ArrayList<>();
    }

    @Override
    public boolean addEmployee(Employee employee) {
        for (Room room : rooms) {
            if (room.getFreeCapacity() > 0) {
                room.addEmployee(employee);
                return true;
            }
        }
        return false;
    }

    public Room findEmployeeRoom(String name) {
        for (Room room : rooms) {
            if (room.isEmployeeInRoom(name)) {
                return room;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        OfficeBuilding building = new OfficeBuilding("Building");
        Room room1 = new Room(2);
        Room room2 = new Room(2);
        building.rooms.add(room1);
        building.rooms.add(room2);
        Employee employee1 = new Employee("Alice", "Address1");
        Employee employee2 = new Employee("Bob", "Address2");
        Employee employee3 = new Employee("Charlie", "Address3");
        building.addEmployee(employee1);
        building.addEmployee(employee2);
        building.addEmployee(employee3);
        System.out.println(building.findEmployeeRoom("Alice").getFreeCapacity()); // should print 0
        System.out.println(building.findEmployeeRoom("Bob").getFreeCapacity()); // should print 0
        System.out.println(building.findEmployeeRoom("Charlie").getFreeCapacity()); // should print 1
    }
}