package academy.everyonecodes.socialnetwork.domain;

import javax.validation.constraints.NotBlank;
import java.util.*;

public class PersonDTO {

    private Long id;

    @NotBlank
    private String name;
    private Set<String> friendNames = new HashSet<>();

    public PersonDTO(Long id, @NotBlank String name, Set<String> friendNames) {
        this.id = id;
        this.name = name;
        this.friendNames = friendNames;
    }

    public PersonDTO() {
    }

    public PersonDTO(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getFriendNames() {
        return friendNames;
    }

    public void setFriendNames(Set<String> friendNames) {
        this.friendNames = friendNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTO personDTO = (PersonDTO) o;
        return Objects.equals(id, personDTO.id) &&
                Objects.equals(name, personDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
