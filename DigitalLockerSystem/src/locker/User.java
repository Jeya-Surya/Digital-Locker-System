package locker;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String inputPassword) {
        return password.equals(inputPassword);
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
}
