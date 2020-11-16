package helpers;

import java.io.File;

public interface FileStorage {
    void write(String text);
    void setPath(String path);
    void setFile(File file);
    long getSize();
}
