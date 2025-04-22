package exam2012.problem1;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Manager("John", "HR", 1000, 200);
        Employee e2 = new Worker("Jane", "IT", 800);
        System.out.println(e1.getName() + " " + e1.getDepartment() + " " + e1.getMonthlyPay());
        System.out.println(e2.getName() + " " + e2.getDepartment() + " " + e2.getMonthlyPay());

        ExecutiveTeam team = new ExecutiveTeam();
        Manager m1 = new Manager("Alice", "HR", 1200, 300);
        Manager m2 = new Manager("Bob", "IT", 1100, 250);
        team.add(m1);
        team.add(m2);
        team.remove("Alice");

        Company company = new Company("ABC");
        company.addWorker("Tom", "HR", 900);
        company.addManager("Eve", "IT", 1000, 150);
        company.addToExecutiveTeam(m2);
        System.out.println(company.getTotalPayPerMonth());

        // Output:
        // John HR 1200
        // Jane IT 800
        // 3400
    }
}
