//package academy.everyonecodes.drhouseadmission;
//
//import academy.everyonecodes.drhouseadmission.domain.Patient;
//import academy.everyonecodes.drhouseadmission.logic.Admission;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertNull;
//
//@SpringBootTest
//class AdmissionTest {
//
//    @Autowired
//    Admission admission;
//
//    @Test
//    void admit() {
//        Patient patient = new Patient("test", "test");
//        assertNull(patient.getUuid());
//
//        Patient admitted = admission.admit(patient);
//        assertNotNull(admitted.getUuid());
//
//    }
//}