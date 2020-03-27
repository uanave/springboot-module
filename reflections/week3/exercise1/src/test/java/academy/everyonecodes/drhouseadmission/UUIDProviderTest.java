package academy.everyonecodes.drhouseadmission;

import academy.everyonecodes.drhouseadmission.domain.Patient;
import academy.everyonecodes.drhouseadmission.logic.UUIDProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UUIDProviderTest {
    UUIDProvider uuidProvider;

    @BeforeEach
    void setup() {
        uuidProvider = new UUIDProvider();
    }

    @Test
    void provideUUIDToUnknownPatient() {
        Patient patient = new Patient("test", "test");
        assertNull(patient.getUuid());

        uuidProvider.provideUUID(patient);
        assertNotNull(patient.getUuid());
    }

    @Test
    void provideUUIDToKnownPatient() {
        Patient patient = new Patient("test", "test");
        assertNull(patient.getUuid());

        uuidProvider.provideUUID(patient);

        String expected = patient.getUuid();
        assertNotNull(expected);

        patient = new Patient("test", "test");
        assertNull(patient.getUuid());

        uuidProvider.provideUUID(patient);

        assertNotNull(patient.getUuid());
        assertEquals(expected, patient.getUuid());
    }
}