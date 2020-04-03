package academy.everyomecodes.drhousediagnoses.configuration;

import academy.everyomecodes.drhousediagnoses.domain.Diagnosis;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("diagnoses")
public class DiagnosisConfiguration {
    private List<Diagnosis> diagnoses;

    public void setDiagnoses(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    @Bean
    List<Diagnosis> diagnoses() {
        return diagnoses;
    }
}
