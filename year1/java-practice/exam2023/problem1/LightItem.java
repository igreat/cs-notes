package exam2023.problem1;

public class LightItem extends Item {

    public LightItem(String description, int idCode) {
        super(description, idCode);
    }

    @Override
    public int getShippingCost() {
        return 1;
    }
}

