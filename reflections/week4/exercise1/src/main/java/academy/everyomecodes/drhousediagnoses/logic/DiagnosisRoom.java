package academy.everyomecodes.drhousediagnoses.logic;

import academy.everyomecodes.drhousediagnoses.domain.Patient;
import org.springframework.stereotype.Service;

@Service
public class DiagnosisRoom {
    private final DrHouse drHouse;

    public DiagnosisRoom(DrHouse drHouse) {
        this.drHouse = drHouse;
    }

    public Patient diagnose(Patient patient) {
        drHouse.diagnose(patient);
        System.out.println("Patient with the symptoms: " + patient.getSymptoms() + "; diagnosed with: " + patient.getDiagnosis());
        return patient;
    }

}
