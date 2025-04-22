package practice2022.problem1;

public abstract class Vehicle {
   private String registration;
   private int numberSeats;

   public Vehicle(String registration, int numberSeats) {
      this.registration = registration;
      this.numberSeats = numberSeats;
   }

    public String getRegistration() {
        return registration;
    }

    public int getNumberSeats() {
        return numberSeats;
    }

    public abstract int getHireCost(int days);
}
