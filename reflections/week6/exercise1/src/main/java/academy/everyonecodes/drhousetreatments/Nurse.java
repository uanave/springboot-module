package academy.everyonecodes.drhousetreatments;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Nurse {
    private final TreatmentService treatmentService;
    private final String treatment;

    public Nurse(TreatmentService treatmentService, @Value("${patient.treatment}") String treatment) {
        this.treatmentService = treatmentService;
        this.treatment = treatment;
    }

    public void provideTreatment(Patient patient) {
        patient.setTreatment(treatment);
        treatmentService.save(patient);
    }
}
