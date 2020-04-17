package academy.everyonecodes.drhousetreatments;

import org.springframework.stereotype.Service;

@Service
public class Nurse {

    public void provideTreatment(Patient patient) {
        patient.setTreatment("spend one day in the hospital bed");
    }
}
