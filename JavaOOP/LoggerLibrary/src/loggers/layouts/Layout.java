package loggers.layouts;

public interface Layout {
    String format(String time, String reportLevel, String message);
}
