package academy.everyonecodes.drhousetreatments;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientEndpoint {
    private final TreatmentService treatmentService;

    public PatientEndpoint(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @PostMapping
    Patient post(@RequestBody Patient patient) {
        return treatmentService.save(patient);
    }
}
