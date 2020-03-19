package academy.everyonecodes.threepwoodcinema;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@ConfigurationProperties("cinema.specialoffer")
public class TemplateMessageFinder {
    private List<Template> templates;
    private String defaultMessage;

    TemplateMessageFinder() {
    }

    public TemplateMessageFinder(List<Template> templates, String defaultMessage) {
        this.templates = templates;
        this.defaultMessage = defaultMessage;
    }

    void setTemplates(List<Template> templates) {
        this.templates = templates;
    }

    void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public String find(String name) {
        return templates.stream()
                .filter(template -> name.contains(template.getName()) || name.startsWith(template.getName()))
                .sorted(Comparator.comparing(Template::getKeyword).reversed())
                .map(Template::getMessage)
                .findFirst().orElse(defaultMessage);
    }
}

