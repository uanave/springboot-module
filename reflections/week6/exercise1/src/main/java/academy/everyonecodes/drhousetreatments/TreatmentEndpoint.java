package academy.everyonecodes.drhousetreatments;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/treatments")
public class TreatmentEndpoint {
    private final TreatmentService treatmentService;

    public TreatmentEndpoint(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @GetMapping
    List<Treatment> get() {
        return treatmentService.findAll();
    }

    @GetMapping("/{uuid}")
    List<Treatment> getByUuid(@PathVariable String uuid) {
        return treatmentService.findAllByUUID(uuid);
    }
}
