package academy.everyonecodes.threepwoodcinema;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("cinema.specialoffer")
public class TemplateConfiguration {
    private List<Template> templates;

    @Bean
    List<Template> templates() {
        return templates;
    }
}
