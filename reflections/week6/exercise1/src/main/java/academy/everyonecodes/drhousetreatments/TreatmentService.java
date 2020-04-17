package academy.everyonecodes.drhousetreatments;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentService {
    private final TreatmentRepository treatmentRepository;
    private final Nurse nurse;

    public TreatmentService(TreatmentRepository treatmentRepository, Nurse nurse) {
        this.treatmentRepository = treatmentRepository;
        this.nurse = nurse;
    }

    public Patient save(Patient patient) {
        nurse.provideTreatment(patient);
        Treatment databaseTreatment = createTreatment(patient);
        treatmentRepository.save(databaseTreatment);
        return patient;
    }

    public List<Treatment> findAll() {
        return treatmentRepository.findAll();
    }

    public List<Treatment> findAllByUUID(String uuid) {
        return treatmentRepository.findAllByUuid(uuid);
    }

    private Treatment createTreatment(Patient patient) {
        String uuid = patient.getUuid();
        String name = patient.getName();
        String symptoms = patient.getSymptoms();
        String diagnosis = patient.getDiagnosis();
        String treatment = patient.getTreatment();
        return new Treatment(uuid, name, symptoms, diagnosis, treatment);
    }
}
