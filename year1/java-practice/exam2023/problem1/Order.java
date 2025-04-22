package exam2023.problem1;

import java.util.ArrayList;
import java.util.HashMap;

public class Order {
    // hashmap could be problematic here, since there is no explicit statement in the problem
    // saying that the idCode is unique. If it is not unique, then the hashmap will not work
    private HashMap<Integer, Item> items;

    public Order() {
        this.items = new HashMap<>();
    }

    public void addItem(Item item) {
        this.items.put(item.getIdCode(), item);
    }

    public int getTotalShippingCost() {
        return items.values()
                .stream()
                .mapToInt(Item::getShippingCost)
                .sum();
    }

    public Item findItem(int idCode) {
        return items.get(idCode);
    }

    public boolean includesItem(int idCode) {
        return items.containsKey(idCode);
    }

    public static void main(String[] args) {
        Order order = new Order();
        Item lightItem = new LightItem("Light item", 1);
        Item heavyItem = new HeavyItem(10, "Heavy item", 2);
        order.addItem(lightItem);
        order.addItem(heavyItem);
        System.out.println(order.getTotalShippingCost());
        System.out.println(order.findItem(1).getDescription());
        System.out.println(order.includesItem(2));
    }
}
