package academy.everyonecodes.drhousetreatments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NurseTest {
    Nurse nurse = new Nurse();

    @Test
    void provideTreatment() {
        Patient patient = new Patient();

        nurse.provideTreatment(patient);

        String result = patient.getTreatment();
        String expected = "spend one day in the hospital bed";
        assertEquals(expected, result);
    }
}