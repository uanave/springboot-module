package academy.everyonecodes.drhouseaccountancy.endpoint;

import academy.everyonecodes.drhouseaccountancy.domain.PatientDTO;
import academy.everyonecodes.drhouseaccountancy.logic.PatientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientEndpoint {
    private final PatientService patientService;

    public PatientEndpoint(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    PatientDTO post(@RequestBody PatientDTO patientDTO) {
        return patientService.post(patientDTO);
    }
}
