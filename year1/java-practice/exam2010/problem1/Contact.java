package exam2010.problem1;

public abstract class Contact {
    private String name;
    private Information info;

    public Contact(String name, Information info) {
        this.name = name;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public Information getInformation() {
        return info;
    }
}