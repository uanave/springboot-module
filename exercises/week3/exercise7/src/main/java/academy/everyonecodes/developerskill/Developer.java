package academy.everyonecodes.developerskill;

import java.util.Objects;
import java.util.Set;

public class Developer {
    private String name;
    private Set<String> skills;

    public Developer() {
    }

    public Developer(String name, Set<String> skills) {
        this.name = name;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return Objects.equals(name, developer.name) &&
                Objects.equals(skills, developer.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, skills);
    }
}
