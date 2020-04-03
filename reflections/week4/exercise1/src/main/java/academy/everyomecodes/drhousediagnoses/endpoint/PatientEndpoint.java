package academy.everyomecodes.drhousediagnoses.endpoint;

import academy.everyomecodes.drhousediagnoses.logic.DiagnosisRoom;
import academy.everyomecodes.drhousediagnoses.domain.Patient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientEndpoint {
    private final DiagnosisRoom diagnosisRoom;

    public PatientEndpoint(DiagnosisRoom diagnosisRoom) {
        this.diagnosisRoom = diagnosisRoom;
    }

    @PostMapping()
    Patient post(@RequestBody Patient patient) {
        return diagnosisRoom.diagnose(patient);
    }
}
