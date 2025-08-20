package locker;

public class FileItem {
    private String fileName;
    private String content;
    private boolean isLocked;
    private String pin; // Used to unlock the file

    public FileItem(String fileName, String content, String pin) {
        this.fileName = fileName;
        this.content = content;
        this.pin = pin;
        this.isLocked = true; // Files are locked by default
    }

    public String getFileName() {
        return fileName;
    }

    public boolean unlock(String inputPin) {
        if (pin.equals(inputPin)) {
            isLocked = false;
            return true;
        }
        return false;
    }

    public void lock() {
        isLocked = true;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public String viewContent() {
        if (!isLocked) {
            return content;
        } else {
            return "File is locked. Please unlock with correct PIN.";
        }
    }
}
