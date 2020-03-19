package academy.everyonecodes.threepwoodcinema;

public class Template {
    private String name;
    private String keyword;
    private String message;

    Template() {
    }

    public Template(String name, String keyword, String message) {
        this.name = name;
        this.keyword = keyword;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public String getKeyword() {
        return keyword;
    }

    void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getMessage() {
        return message;
    }

    void setMessage(String message) {
        this.message = message;
    }
}
