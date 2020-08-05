package Articles2;

public class Articles {
    private String title;
    private String content;
    private String author;

    public Articles() {}

    public Articles(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public String getAuthor() {
        return this.author;
    }

    @Override
    public String toString () {
        return String.format("%s - %s: %s", this.title, this.content, this.author);
    }
}
