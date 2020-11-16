package loggers.appenders;

import enums.ReportLevel;

public interface Appender {
    void append(String time, String reportLevel, String message);
    void setReportLevel(ReportLevel reportLevel);
    ReportLevel getReportLevel();
}
