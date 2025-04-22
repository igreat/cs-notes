package exam2023.problem1;

public abstract class Item {
    private String description;
    private int idCode;

    public Item(String description, int idCode) {
        this.description = description;
        this.idCode = idCode;
    }

    public abstract int getShippingCost();

    public String getDescription() {
        return description;
    }

    public int getIdCode() {
        return idCode;
    }
}
