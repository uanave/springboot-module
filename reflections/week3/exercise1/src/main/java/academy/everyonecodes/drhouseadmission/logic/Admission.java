package academy.everyonecodes.drhouseadmission.logic;

import academy.everyonecodes.drhouseadmission.client.DiagnosesClient;
import academy.everyonecodes.drhouseadmission.domain.Patient;
import org.springframework.stereotype.Service;

@Service
public class Admission {
    private final UUIDProvider uuidProvider;
    private final DiagnosesClient diagnosesClient;

    public Admission(UUIDProvider uuidProvider, DiagnosesClient diagnosesClient) {
        this.uuidProvider = uuidProvider;
        this.diagnosesClient = diagnosesClient;
    }

    public Patient admit(Patient patient) {
        uuidProvider.provideUUID(patient);
        diagnosesClient.send(patient);
        return patient;
    }
}
