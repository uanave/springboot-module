package academy.everyonecodes.mocky;

import java.util.Objects;

public class Postcard {
    private String from;
    private String to;
    private String content;

    public Postcard(String from, String to, String content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    public Postcard() {
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Postcard postcard = (Postcard) o;
        return Objects.equals(from, postcard.from) &&
                Objects.equals(to, postcard.to) &&
                Objects.equals(content, postcard.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, content);
    }
}
