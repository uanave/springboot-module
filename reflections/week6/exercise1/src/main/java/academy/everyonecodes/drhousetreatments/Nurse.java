package academy.everyonecodes.drhousetreatments;

import academy.everyonecodes.drhousetreatments.client.AccountancyClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Nurse {
    private final TreatmentService treatmentService;
    private final String treatment;
    private final AccountancyClient accountancyClient;

    public Nurse(TreatmentService treatmentService, @Value("${patient.treatment}") String treatment, AccountancyClient accountancyClient) {
        this.treatmentService = treatmentService;
        this.treatment = treatment;
        this.accountancyClient = accountancyClient;
    }

    public void provideTreatment(Patient patient) {
        patient.setTreatment(treatment);
        treatmentService.save(patient);
        accountancyClient.send(patient);
    }
}
