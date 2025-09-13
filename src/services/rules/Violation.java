package services.rules;

public class Violation {
    private final String message;

    private Violation(String message) { // constructor is private
        this.message = message;
    }

    public static Violation of(String message) {
        return new Violation(message);
    }

    public String getMessage() {
        return message;
    }
}
