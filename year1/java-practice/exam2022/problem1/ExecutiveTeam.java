package exam2022.problem1;

import java.util.HashMap;

public class ExecutiveTeam {
    private HashMap<String, Manager> managers;

    public ExecutiveTeam() {
        this.managers = new HashMap<>();
    }

    public void add(Manager manager) {
        managers.put(manager.getName(), manager);
    }

    public void remove(String name) {
        managers.remove(name);
    }
}
