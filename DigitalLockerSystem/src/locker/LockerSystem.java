package locker;
import java.util.ArrayList;
import java.util.Scanner;

public class LockerSystem {
    private ArrayList<RegularUser> users;
    private AdminUser admin;

    public LockerSystem() {
        users = new ArrayList<>();
        admin = new AdminUser("jeya surya", "0107");
    }


    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("===== Welcome to the Digital Locker System =====");

        while (running) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Register as New User");
            System.out.println("2. Login as User");
            System.out.println("3. Login as Admin");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    register(scanner);
                    break;
                case 2:
                    loginAsUser(scanner);
                    break;
                case 3:
                    loginAsAdmin(scanner);
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using the Digital Locker System!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }


    private void register(Scanner scanner) {
        System.out.print("Enter new username: ");
        String username = scanner.nextLine();
        System.out.print("Enter new password: ");
        String password = scanner.nextLine();

        RegularUser newUser = new RegularUser(username, password);
        users.add(newUser);
        System.out.println("User registered successfully!");
    }


    private void loginAsUser(Scanner scanner) {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        for (RegularUser user : users) {
            if (user.getUsername().equals(username) && user.checkPassword(password)) {
                System.out.println("Login successful!");
                userMenu(scanner, user);
                return;
            }
        }
        System.out.println("Invalid username or password.");
    }


    private void loginAsAdmin(Scanner scanner) {
        System.out.print("Admin Username: ");
        String username = scanner.nextLine();
        System.out.print("Admin Password: ");
        String password = scanner.nextLine();

        if (admin.getUsername().equals(username) && admin.checkPassword(password)) {
            System.out.println("Admin login successful!");
            adminMenu(scanner);
        } else {
            System.out.println("Invalid admin credentials.");
        }
    }


    private void userMenu(Scanner scanner, RegularUser user) {
        boolean active = true;
        while (active) {
            System.out.println("\nUser Menu:");
            System.out.println("1. Add File");
            System.out.println("2. View Files");
            System.out.println("3. View File Content");
            System.out.println("4. Unlock File");
            System.out.println("5. Lock File");
            System.out.println("6. Delete File");
            System.out.println("7. Logout");
            System.out.print("Choice: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter file name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter content: ");
                    String content = scanner.nextLine();
                    System.out.print("Set file PIN: ");
                    String pin = scanner.nextLine();
                    user.addFile(name, content, pin);
                    break;
                case 2:
                    user.listFiles();
                    break;
                case 3:
                    System.out.print("Enter file name to view: ");
                    user.viewFile(scanner.nextLine());
                    break;
                case 4:
                    System.out.print("Enter file name to unlock: ");
                    String fileToUnlock = scanner.nextLine();
                    System.out.print("Enter PIN: ");
                    String unlockPin = scanner.nextLine();
                    user.unlockFile(fileToUnlock, unlockPin);
                    break;
                case 5:
                    System.out.print("Enter file name to lock: ");
                    user.lockFile(scanner.nextLine());
                    break;
                case 6:
                    System.out.print("Enter file name to delete: ");
                    user.deleteFile(scanner.nextLine());
                    break;
                case 7:
                    active = false;
                    System.out.println("Logged out.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void adminMenu(Scanner scanner) {
        boolean active = true;
        while (active) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. View All Users");
            System.out.println("2. Reset User Password");
            System.out.println("3. Delete User");
            System.out.println("4. Logout");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    admin.viewAllUsers(users);
                    break;
                case 2:
                    System.out.print("Enter username to reset password: ");
                    String target = scanner.nextLine();
                    System.out.print("Enter new password: ");
                    String newPass = scanner.nextLine();
                    admin.resetUserPassword(users, target, newPass);
                    break;
                case 3:
                    System.out.print("Enter username to delete: ");
                    admin.deleteUser(users, scanner.nextLine());
                    break;
                case 4:
                    active = false;
                    System.out.println("Admin logged out.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}


