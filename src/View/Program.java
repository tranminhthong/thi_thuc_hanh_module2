package View;

import Behaviors.ContactsManagement;
import Behaviors.LoginAndRegister;
import Behaviors.ReadWriteFile;
import Entities.Contacts;

import java.util.Scanner;

public class Program {
    static Scanner sc = new Scanner(System.in);
    static ContactsManagement cm = new ContactsManagement();

    public static void main(String[] args) {
        login:
        do {
            System.out.print(">>>>>>>>>>><<<<<<<<<<" +
                    "\n1. Login" +
                    "\n2. Register" +
                    "\nEnter choice: ");
            try {
                int choices = Integer.parseInt(sc.nextLine());
                if (choices == 1) {
                    Menus.login();
                    boolean exit = true;
                    do {
                        System.out.print("-------Contacts Management------" +
                                "\n1: Display all contacts" +
                                "\n2: Add contact" +
                                "\n3: Update contact" +
                                "\n4: Delete  contact" +
                                "\n5: Search contact by name" +
                                "\n6: Read from file" +
                                "\n7: Exit" +
                                "\n8: Log out" +
                                "\nEnter your choice: ");
                        try {
                            int choice = Integer.parseInt(sc.nextLine());
                            switch (choice) {
                                case 1:
                                    cm.show();
                                    break;
                                case 2:
                                    Contacts contact = Menus.getInfoContact();
                                    cm.add(contact);
                                    break;
                                case 3:
                                    System.out.println("Enter phone number: ");
                                    int phoneNumber = Integer.parseInt(sc.nextLine());
                                    cm.check(phoneNumber);
                                    System.out.println("Enter name: ");
                                    String name = sc.nextLine();
                                    cm.update(phoneNumber, name);
                                    break;
                                case 4:
                                    System.out.println("Enter phone number delete: ");
                                    int phoneNumber1 = Integer.parseInt(sc.nextLine());
                                    cm.delete(phoneNumber1);
                                    break;
                                case 5:
                                    System.out.println("Enter search name: ");
                                    String name1 = sc.nextLine();
                                    System.out.println(cm.searchByName(name1));
                                    break;
                                case 6:
                                    String pathFile = "C:\\Users\\thait\\OneDrive\\Desktop\\case\\src\\Contacts.csv";
                                    ReadWriteFile.readFromFileCsv(pathFile);
                                    break;
                                case 7:
                                    exit = false;
                                    break;
                                case 8:
                                    continue login;
                            }
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                        }

                    } while (exit);
                } else if (choices == 2) {
                    Menus.register();
                }else if (choices==3){
                    LoginAndRegister.show();
                }else if (choices==4){
                    String username = sc.nextLine();
                    LoginAndRegister.delete(username);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
    }
}
