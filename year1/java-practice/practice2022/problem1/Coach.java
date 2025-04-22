package practice2022.problem1;

public class Coach extends Vehicle {
    private boolean luxury;

    public Coach(String registration, int numberSeats, boolean luxury) {
        super(registration, numberSeats);
        this.luxury = luxury;
    }

    public int getHireCost(int days) {
        int costPerDay = this.luxury ? 15 : 10;
        return costPerDay * days;
    }
}
