package academy.everyonecodes.emergencynumbers;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class EmergencyNumberProvider {
    private final GeneralEmergency generalEmergency;
    private final Set<EmergencyNumber> emergencies;

    public EmergencyNumberProvider(Set<EmergencyNumber> emergencies, GeneralEmergency generalEmergency) {
        this.emergencies = emergencies;
        this.generalEmergency = generalEmergency;
    }

    public String provide(String name) {
        return emergencies.stream()
                .filter(emergencyNumber -> emergencyNumber.getName().equalsIgnoreCase(name))
                .map(EmergencyNumber::getNumber)
                .findFirst()
                .orElse(generalEmergency.getNumber());
    }
}
