package loggers.appenders;

import helpers.FileStorage;
import loggers.layouts.Layout;

public class FileAppender extends AppenderImpl {
    private FileStorage fileHelper;

    public FileAppender(Layout layout, FileStorage fileStorage) {
        super(layout);
        this.fileHelper = fileStorage;
    }

    @Override
    public void append(String time, String reportLevel, String message) {
        this.incrementMessagesCount();
        this.fileHelper.write(this.getLayout().format(time, reportLevel, message));
    }

    @Override
    public String toString() {
        return super.toString() + ", " + "File size: " + this.fileHelper.getSize();
    }
}

