package exam2010.problem1;

public class Main {
    public static void main(String[] args) {
        Information info1 = new Information("123 Main St", "555-1234", "yourmum@dude.com");
        Information info2 = new Information("456 Elm St", "555-5678", "hahabro@gg.com");
        Information info3 = new Information("789 Oak St", "555-9101", "yessir@lmfao.com");
        ContactManager cm = new ContactManager();
        cm.addPersonContact("John Doe", info1, "01/01/2000");
        cm.addBusinessContact("Jane Doe", info2, 12345);
        cm.addPersonContact("Jane Doe", info3, "01/01/2000");
        System.out.println("John Doe's email addresses:");
        for (Contact c : cm.findAll("John Doe")) {
            System.out.println(c.getInformation().getEmail());
        }
        System.out.println("Jane Doe's email addresses:");
        for (Contact c : cm.findAll("Jane Doe")) {
            System.out.println(c.getInformation().getEmail());
        }
    }
}
