package validation;

public class StringValidator {
    private StringValidator() {
    }

    public static boolean isNonEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
