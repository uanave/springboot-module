package academy.everyonecodes.drhouseadmission.logic;

import academy.everyonecodes.drhouseadmission.domain.Patient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class UUIDProvider {
    private final Map<String, String> cache = new HashMap<>();

    public void provideUUID(Patient patient) {
        String name = patient.getName();
        String uuid = cache.getOrDefault(name, UUID.randomUUID().toString());
        patient.setUuid(uuid);
        cache.putIfAbsent(name, uuid);
    }

    public HashMap<String, String> getCacheSnapshot() {
        return new HashMap<>(cache);
    }

    public Optional<String> findUUID(String patientName) {
        return Optional.of(cache.get(patientName));
    }
}
