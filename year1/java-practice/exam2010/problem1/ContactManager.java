package exam2010.problem1;

import java.util.ArrayList;
import java.util.List;

public class ContactManager {
    List<Contact> contacts;

    public ContactManager() {
        contacts = new ArrayList<>();
    }

    public void addPersonContact(String name, Information info,
                                 String birthday) {
        contacts.add(new PersonalContact(name, info, birthday));
    }

    public void addBusinessContact(String name, Information info,
                                   int accountNo) {
        contacts.add(new BusinessContact(name, info, accountNo));
    }

    public ArrayList<Contact> findAll(String name) {
        ArrayList<Contact> matches = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                matches.add(contact);
            }
        }
        return matches;
    }
}