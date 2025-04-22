package exam2023.problem1;

public class HeavyItem extends Item {
    private int weight;

    public HeavyItem(int weight, String description, int idCode) {
        super(description, idCode);
        this.weight = weight;
    }

    @Override
    public int getShippingCost() {
        return 2 * weight;
    }
}
