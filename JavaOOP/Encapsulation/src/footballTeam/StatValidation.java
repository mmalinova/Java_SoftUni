package footballTeam;

public class StatValidation {
    private StatValidation() {
    }

    //Each stat can be in the range [0..100].
    public static boolean isInTheRange (int value) {
        return value >= 0 && value <= 100;
    }
}
