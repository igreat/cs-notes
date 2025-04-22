package exam2010.problem1;

public class PersonalContact extends Contact {
    private String birthday;

    public PersonalContact(String name, Information info, String birthday) {
        super(name, info);
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }
}
