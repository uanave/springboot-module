package academy.everyonecodes.drhouseadmission;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

@Service
public class UUIDProvider {
    private HashMap<String, String> cache = new HashMap<>();

    void provideUUID(Patient patient) {
        if (!cache.containsKey(patient.getName())) {
            if (patient.getUuid().isEmpty()) {
                UUID uuid = UUID.randomUUID();
                patient.setUuid(uuid.toString());
            }
            cache.put(patient.getName(), patient.getUuid());
        }
    }

    public HashMap<String, String> getCacheSnapshot() {
        return cache;
    }

    public Optional<String> findUUID(String patientName) {
        return Optional.of(cache.get(patientName));
    }
}
