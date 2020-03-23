package academy.everyonecodes.advancedtypes;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("education")
public class AcademyConfiguration {
    private List<Academy> academies;

    void setAcademies(List<Academy> academies) {
        this.academies = academies;
    }

    @Bean
    List<Academy> academies() {
        return academies;
    }
}
