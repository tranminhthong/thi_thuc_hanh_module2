package Behaviors;

import Entities.Contacts;

import java.util.ArrayList;
import java.util.List;

public class ContactsManagement {
    private static final String PATH_FILE = "C:\\Users\\thait\\OneDrive\\Desktop\\case\\thi_thuc_hanh_module2\\src\\Contacts.csv";
    static ArrayList<Contacts> contacts = (ArrayList<Contacts>) ReadWriteFile.readCSV(PATH_FILE);

    public void add(Contacts c) {
        contacts.add(c);
        ReadWriteFile.writeToFileCsv(contacts, PATH_FILE);
    }

    public void update(String phoneNumber, String name) {
        for (Contacts c : contacts) {
            if (c.getPhoneNumber().equals(phoneNumber)) {
                c.setName(name);
            }
        }
        ReadWriteFile.writeToFileCsv(contacts, PATH_FILE);
    }

    public void delete(String phoneNumber) {
        contacts.removeIf(c -> c.getPhoneNumber().equals(phoneNumber));
        ReadWriteFile.writeToFileCsv(contacts, PATH_FILE);
    }

    public void show() {
        for (Contacts c : contacts) {
            System.out.print(c);
        }
    }

    public List<Contacts> searchByName(String name) throws Exception {
        List<Contacts> contacts1 = new ArrayList<>();
        for (Contacts c : contacts) {
            if (c.getName().equals(name)) {
                contacts1.add(c);
            }
        }
        if (contacts1.size() == 0) throw new Exception("Not exist!!");
        return contacts1;
    }

    public void check(String phone) throws Exception {
        boolean checkPhone = false;
        for (Contacts c : contacts) {
            if (c.getPhoneNumber().equals(phone)) {
                checkPhone = true;
                break;
            }
        }
        if (!checkPhone) {
            System.out.println("No contacts with phone number.");
            throw new Exception();
        }
    }
}
