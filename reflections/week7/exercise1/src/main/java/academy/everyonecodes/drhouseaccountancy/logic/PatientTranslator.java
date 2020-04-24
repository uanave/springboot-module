package academy.everyonecodes.drhouseaccountancy.logic;

import academy.everyonecodes.drhouseaccountancy.domain.Patient;
import academy.everyonecodes.drhouseaccountancy.domain.PatientDTO;
import org.springframework.stereotype.Service;

@Service
public class PatientTranslator {
    public PatientDTO translateToDTO(Patient patient) {
        return new PatientDTO(
                patient.getUuid(),
                patient.getName(),
                patient.getSymptoms(),
                patient.getDiagnosis(),
                patient.getTreatment()
        );
    }

    public Patient translateToPatient(PatientDTO patientDTO) {
        return new Patient(
                patientDTO.getUuid(),
                patientDTO.getName(),
                patientDTO.getSymptoms(),
                patientDTO.getDiagnosis(),
                patientDTO.getTreatment()

        );
    }
}
