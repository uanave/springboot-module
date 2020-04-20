package academy.everyonecodes.drhousetreatments;

import org.springframework.stereotype.Service;

@Service
public class Nurse {
    private final TreatmentService treatmentService;

    public Nurse(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    public void provideTreatment(Patient patient) {
        patient.setTreatment("spend one day in the hospital bed");
        treatmentService.save(patient);
    }
}
