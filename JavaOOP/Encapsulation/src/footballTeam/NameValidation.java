package footballTeam;

public class NameValidation {
    private NameValidation() {
    }

    public static boolean isNonEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
