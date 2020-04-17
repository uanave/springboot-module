package academy.everyomecodes.drhousediagnoses.logic;

import academy.everyomecodes.drhousediagnoses.client.TreatmentsClient;
import academy.everyomecodes.drhousediagnoses.domain.Patient;
import org.springframework.stereotype.Service;

@Service
public class DiagnosisRoom {
    private final DrHouse drHouse;
    private final TreatmentsClient treatmentsClient;

    public DiagnosisRoom(DrHouse drHouse, TreatmentsClient treatmentsClient) {
        this.drHouse = drHouse;
        this.treatmentsClient = treatmentsClient;
    }

    public Patient diagnose(Patient patient) {
        drHouse.diagnose(patient);
        treatmentsClient.send(patient);
        return patient;
    }

}
