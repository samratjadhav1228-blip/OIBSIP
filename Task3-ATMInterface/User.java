

public class User {

    private String userId;
    private String pin;

    public User(String userId, String pin) {
        this.userId = userId;
        this.pin = pin;
    }

    public boolean login(String id, String pin) {
        if (this.userId.equals(id) && this.pin.equals(pin)) {
            return true;
        }
        return false;
    }
}