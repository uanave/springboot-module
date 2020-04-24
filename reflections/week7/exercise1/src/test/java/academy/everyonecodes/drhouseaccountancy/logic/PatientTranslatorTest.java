package academy.everyonecodes.drhouseaccountancy.logic;

import academy.everyonecodes.drhouseaccountancy.domain.Patient;
import academy.everyonecodes.drhouseaccountancy.domain.PatientDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientTranslatorTest {
    PatientTranslator patientTranslator = new PatientTranslator();

    @Test
    void translateToDTO() {
        Patient patient = new Patient("123", "tom", "test", "test", "test");
        PatientDTO result = patientTranslator.translateToDTO(patient);
        PatientDTO expected = new PatientDTO("123", "tom", "test", "test", "test");
        assertEquals(expected, result);

    }

    @Test
    void translateToPatient() {
        PatientDTO patientDTO = new PatientDTO("123", "tom", "test", "test", "test");
        Patient result = patientTranslator.translateToPatient(patientDTO);
        Patient expected = new Patient("123", "tom", "test", "test", "test");
        assertEquals(expected, result);

    }
}