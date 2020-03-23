package academy.everyonecodes.advancedtypes;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("education")
public class CommunityEventConfiguration {
    private List<CommunityEvent> events;

    void setEvents(List<CommunityEvent> events) {
        this.events = events;
    }

    @Bean
    List<CommunityEvent> events() {
        return events;
    }
}
