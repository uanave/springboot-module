package academy.everyonecodes.drhouseadmission;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdmissionTest {
    Admission admission = new Admission(new UUIDProvider());

    @Test
    void admitPatient() {
        Patient mary = new Patient("Mary", "", List.of("headache"));
        Patient result = admission.admit(mary);
        HashMap<String, String> expected = admission.getUuidProvider().getCacheSnapshot();
        String id = expected.get("Mary");
        assertEquals(result.getUuid(), id);
    }
}