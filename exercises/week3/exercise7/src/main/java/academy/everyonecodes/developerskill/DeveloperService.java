package academy.everyonecodes.developerskill;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@ConfigurationProperties("skills")
public class DeveloperService {
    private List<Developer> developers;

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    public List<Developer> findAll() {
        return developers;
    }

    public List<Developer> findBy(String skills) {
        List<String> neededSkills = List.of(skills.split(" "));
        return developers.stream()
                .filter(developer -> developer.getSkills().containsAll(neededSkills))
                .collect(Collectors.toList());
    }
}
