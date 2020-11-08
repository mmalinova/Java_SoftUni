package validation;

public class NumericValidator {
    private NumericValidator() {
    }

    public static boolean isNonNegative(double value) {
        return value >= 0.0;
    }
}
