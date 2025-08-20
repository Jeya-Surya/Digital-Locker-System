package locker;

import java.util.ArrayList;
import java.util.Scanner;

public class RegularUser extends User{
    private ArrayList<FileItem> files;

    public RegularUser(String username, String password) {
        super(username, password);
        this.files = new ArrayList<>();
    }

        public void addFile(String fileName, String content, String pin) {
            FileItem file = new FileItem(fileName, content, pin);
            files.add(file);
            System.out.println("File \"" + fileName + "\" added and locked successfully.");
        }

        public void listFiles() {
            if (files.isEmpty()) {
                System.out.println("No files stored.");
                return;
            }
            System.out.println("Stored Files:");
            for (FileItem f : files) {
                System.out.println("- " + f.getFileName() + " (Locked: " + f.isLocked() + ")");
            }
        }


    public void unlockFile(String fileName, String pin) {
        for (FileItem f : files) {
            if (f.getFileName().equals(fileName)) {
                if (f.unlock(pin)) {
                    System.out.println("File \"" + fileName + "\" unlocked successfully.");
                } else {
                    System.out.println("Incorrect PIN. File not unlocked.");
                }
                return;
            }
        }
        System.out.println("File not found.");
    }


    public void viewFile(String fileName) {
        for (FileItem f : files) {
            if (f.getFileName().equals(fileName)) {
                System.out.println("File Content: " + f.viewContent());
                return;
            }
        }
        System.out.println("File not found.");
    }


    public void lockFile(String fileName) {
        for (FileItem f : files) {
            if (f.getFileName().equals(fileName)) {
                f.lock();
                System.out.println("File \"" + fileName + "\" is now locked.");
                return;

            }
        }
        System.out.println("File not found.");
    }


    public void deleteFile(String fileName) {
        for (FileItem f : files) {
            if (f.getFileName().equals(fileName)) {
                files.remove(f);
                System.out.println("File \"" + fileName + "\" deleted.");
                return;
            }
        }
        System.out.println("File not found.");
    }
}


