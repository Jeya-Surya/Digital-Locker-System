package locker;
import java.util.ArrayList;

public class AdminUser extends User{
    public AdminUser(String username, String password) {
        super(username, password);
    }


    public void viewAllUsers(ArrayList<RegularUser> users) {
        if (users.isEmpty()) {
            System.out.println("No registered users found.");
            return;
        }

        System.out.println("List of Registered Users:");
        for (RegularUser user : users) {
            System.out.println("- " + user.getUsername());
        }
    }


    public void resetUserPassword(ArrayList<RegularUser> users, String targetUsername, String newPassword) {
        for (RegularUser user : users) {
            if (user.getUsername().equals(targetUsername)) {
                user.setPassword(newPassword);
                System.out.println("Password reset successfully for user: " + targetUsername);
                return;
            }
        }
        System.out.println("User not found.");
    }


    public void deleteUser(ArrayList<RegularUser> users, String targetUsername) {
        for (RegularUser user : users) {
            if (user.getUsername().equals(targetUsername)) {
                users.remove(user);
                System.out.println("User \"" + targetUsername + "\" deleted.");
                return;
            }
        }
        System.out.println("User not found.");
    }
}


