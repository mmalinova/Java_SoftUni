package loggers.appenders;

import loggers.layouts.Layout;

public class ConsoleAppender extends AppenderImpl {
    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String time, String reportLevel, String message) {
        this.incrementMessagesCount();
        System.out.println(this.getLayout().format(time, reportLevel, message));
    }
}
