package practice2022.problem1;

import java.util.HashMap;

public class Depot {
    private String name;
    private HashMap<String, Vehicle> vehicles;

    public Depot(String name) {
        this.name = name;
        this.vehicles = new HashMap<>();
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.put(vehicle.getRegistration(), vehicle);
    }

    public String getName() {
        return name;
    }

    public Vehicle getVehicle(String registration) {
        return this.vehicles.get(registration);
    }
}
