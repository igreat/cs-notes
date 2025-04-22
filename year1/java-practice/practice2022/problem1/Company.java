package practice2022.problem1;

import java.util.HashMap;

public class Company {
    private String name;
    private HashMap<String, Depot> depots;

    public Company(String name) {
        this.name = name;
        this.depots = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addDepot(Depot depot) {
        this.depots.put(depot.getName(), depot);
    }

    public void addVehicleToDepot(Vehicle vehicle, String depot) throws Exception {
        Depot depotObj = depots.get(depot);
        if (depotObj == null) {
            throw new Exception("Depot not in company");
        }
        depotObj.addVehicle(vehicle);
    }

    public Depot findDepotWithVehicle(String registration) {
        for (Depot depot : depots.values()) {
            if (depot.getVehicle(registration) != null) {
                return depot;
            }
        }
        return null;
    }
}
