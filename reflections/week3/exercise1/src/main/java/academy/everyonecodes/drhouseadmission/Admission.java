package academy.everyonecodes.drhouseadmission;

import org.springframework.stereotype.Service;

@Service
public class Admission {
    private UUIDProvider uuidProvider;

    public Admission(UUIDProvider uuidProvider) {
        this.uuidProvider = uuidProvider;
    }

    public Patient admit(Patient patient) {
        uuidProvider.provideUUID(patient);
        return patient;
    }

    public UUIDProvider getUuidProvider() {
        return uuidProvider;
    }
}
