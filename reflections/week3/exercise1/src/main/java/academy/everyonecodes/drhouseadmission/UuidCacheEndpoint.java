package academy.everyonecodes.drhouseadmission;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/uuids")
public class UuidCacheEndpoint {
    private UUIDProvider uuidProvider;

    public UuidCacheEndpoint(UUIDProvider uuidProvider) {
        this.uuidProvider = uuidProvider;
    }

    @GetMapping
    HashMap<String, String> getCached() {
        return uuidProvider.getCacheSnapshot();
    }

    @GetMapping("/{patientName}")
    String getId(@PathVariable String patientName) {
        Optional<String> name = uuidProvider.findUUID(patientName);
        return name.orElse(null);
    }
}
