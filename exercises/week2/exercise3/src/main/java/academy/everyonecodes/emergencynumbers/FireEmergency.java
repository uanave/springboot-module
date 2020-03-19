package academy.everyonecodes.emergencynumbers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FireEmergency implements EmergencyNumber {
    private final String name;
    private final String telephone;

    public FireEmergency(@Value("${emergency.fire.name}") String name,
                         @Value("${emergency.fire.number}") String telephone) {
        this.name = name;
        this.telephone = telephone;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getNumber() {
        return this.telephone;
    }
}
