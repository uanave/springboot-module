package academy.everyonecodes.socialnetwork.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @JoinTable(name = "person_friends",
            joinColumns = {
                    @JoinColumn(name = "person_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "friend_id", referencedColumnName = "id")},
            uniqueConstraints = @UniqueConstraint(columnNames = {
                    "person_id", "friend_id"}))

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Person> friends = new HashSet<>();

    public Person(String name, Set<Person> friends) {
        this.name = name;
        this.friends = friends;
    }

    public Person(Long id, @NotBlank String name) {
        this.id = id;
        this.name = name;
    }

    public Person(Long id, @NotBlank String name, Set<Person> friends) {
        this.id = id;
        this.name = name;
        this.friends = friends;
    }



    public Person(String name) {
        this.name = name;
    }


    public Person() {
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

    public Set<Person> getFriends() {
        return friends;
    }

    public void setFriends(Set<Person> friends) {
        this.friends = friends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }


}
