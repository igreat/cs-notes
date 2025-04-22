package exam2022.problem1;

public class Manager extends Employee {
    private int bonus;

    public Manager(String name, String department, int pay, int bonus) {
        super(name, department, pay);
        this.bonus = bonus;
    }

    @Override
    public int getMonthlyPay() {
        return super.getMonthlyPay() + bonus;
    }
}
