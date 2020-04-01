package academy.everyonecodes.jsonplaceholder.communication.dto;

import java.util.Objects;

public class PostDTO {

    private int id;
    private int userId;
    private String title;
    private String body;

    PostDTO() {
    }

    public PostDTO(int id, int userId, String title, String body) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostDTO)) return false;
        PostDTO postDTO = (PostDTO) o;
        return getId() == postDTO.getId() &&
                getUserId() == postDTO.getUserId() &&
                Objects.equals(getTitle(), postDTO.getTitle()) &&
                Objects.equals(getBody(), postDTO.getBody());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserId(), getTitle(), getBody());
    }
}
