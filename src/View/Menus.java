package View;

import Behaviors.LoginAndRegister;
import Entities.Contacts;
import Entities.User;

import java.util.Scanner;

public class Menus {
    static Scanner sc = new Scanner(System.in);

    public static Contacts getInfoContact() {
        Contacts contact = new Contacts();
        System.out.println("Enter name: ");
        contact.setName(sc.nextLine());
        System.out.println("Enter phone number: ");
        String phoneNumber = sc.nextLine();
        if (LoginAndRegister.checkPhoneNumber(phoneNumber)) contact.setPhoneNumber(phoneNumber);
        else {
            System.err.println("has 10 number, begin 0");
            getInfoContact();
        }
        System.out.println("Enter address: ");
        contact.setAddress(sc.nextLine());
        System.out.println("Enter email(Note: example@example.com): ");
        String email = sc.nextLine();
        if (LoginAndRegister.checkEmail(email)) contact.setEmail(email);
        else {
            System.err.println("Email: example@example.com");
            getInfoContact();
        }
        System.out.println("Enter facebook: ");
        contact.setFacebook(sc.nextLine());
        System.out.println("Enter nickname: ");
        contact.setNickname(sc.nextLine());
        return contact;
    }

    public static void login() throws Exception {
        System.out.println("------Login------");
        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String pass = sc.nextLine();
        LoginAndRegister.login(username, pass);
    }

    public static void register() throws Exception {
        System.out.println("------Register------");
        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String pass = sc.nextLine();
        User user = new User(username, pass);
        LoginAndRegister.register(user);
    }
}
