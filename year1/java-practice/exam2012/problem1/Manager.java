package exam2012.problem1;

public class Manager extends Employee {
    private int bonus;

    public Manager(String name, String department, int pay, int bonus) {
        super(name, department, pay);
        this.bonus = bonus;
    }

    public int getMonthlyPay() {
        return super.getMonthlyPay() + bonus;
    }
}
