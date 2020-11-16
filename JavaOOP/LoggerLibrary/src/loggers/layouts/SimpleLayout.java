package loggers.layouts;

public class SimpleLayout implements Layout {

    @Override
    public String format(String time, String reportLevel, String message) {
        return String.format(
                "%s - %s - %s"
                , time
                , reportLevel
                , message
        );
    }
}
