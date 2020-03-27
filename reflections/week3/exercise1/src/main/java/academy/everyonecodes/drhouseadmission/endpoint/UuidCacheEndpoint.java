package academy.everyonecodes.drhouseadmission.endpoint;

import academy.everyonecodes.drhouseadmission.logic.UUIDProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/uuids")
public class UuidCacheEndpoint {
    private final UUIDProvider uuidProvider;

    public UuidCacheEndpoint(UUIDProvider uuidProvider) {
        this.uuidProvider = uuidProvider;
    }

    @GetMapping
    HashMap<String, String> getCached() {
        return uuidProvider.getCacheSnapshot();
    }

    @GetMapping("/{patientName}")
    String getId(@PathVariable String patientName) {
        return uuidProvider.findUUID(patientName)
                .orElse(null);
    }
}
