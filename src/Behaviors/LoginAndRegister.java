package Behaviors;

import Entities.User;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginAndRegister {

    private static final String PATH = "C:\\Users\\thait\\OneDrive\\Desktop\\case\\thi_thuc_hanh_module2\\src\\login.dat";
    static List<User> users = (List<User>) ReadWriteFile.readFromFile(PATH);
    ;

    public static void login(String userName, String password) throws Exception {
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                if (user.getPassword().equals(password)) {
                    return;
                }
            }
        }
        throw new Exception("User is not exist!!!");
    }

    public static void register(User user) throws Exception {
        for (User u : users) {
            if (u.getUserName().equals(user.getUserName())) {
                throw new Exception("User existed!!! Please try again");
            }
        }
        users.add(user);
        ReadWriteFile.writeObjectToFile(users, PATH);
    }

    public static void show() {
        for (User u : users) {
            System.out.println("---------------\n" +
                    "Account: " +
                    "\nUsername: " + u.getUserName() +
                    "\nPassword: " + u.getPassword());
        }
    }

    public static void delete(String username) throws Exception {
        for (User u : users) {
            if (u.getUserName().equals(username)) {
                users.remove(u);
                System.out.println("User '" + username + "' has been deleted!!!");
                ReadWriteFile.writeObjectToFile(users, PATH);
                return;
            }
        }
        throw new Exception("User not exist!!!");
    }

    public static boolean checkEmail(String email){
        Pattern pattern = Pattern.compile("([A-Za-z0-9-_.]+@[A-Za-z0-9-_]+(?:\\.[A-Za-z0-9]+)+)");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
