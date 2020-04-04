package academy.everyomecodes.drhousediagnoses.logic;

import academy.everyomecodes.drhousediagnoses.domain.Diagnosis;
import academy.everyomecodes.drhousediagnoses.domain.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrHouse {
    private final List<Diagnosis> diagnoses;

    public DrHouse(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public void diagnose(Patient patient) {
        System.out.println(diagnoses);
        String diagnoseName = diagnoses.stream()
                .filter(diagnosis -> diagnosis.getSymptoms().equals(patient.getSymptoms()))
                .map(Diagnosis::getName)
                .findFirst().orElse("lupus");
        patient.setDiagnosis(diagnoseName);
    }
}
