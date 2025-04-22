package exam2012.problem1;

public abstract class Employee {
    private String name;
    private String department;
    private int monthlyPay;

    public Employee(String name, String department, int pay) {
        this.name = name;
        this.department = department;
        this.monthlyPay = pay;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getMonthlyPay() {
        return monthlyPay;
    }
}