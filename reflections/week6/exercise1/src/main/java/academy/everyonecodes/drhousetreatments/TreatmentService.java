package academy.everyonecodes.drhousetreatments;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentService {
    private final TreatmentRepository treatmentRepository;

    public TreatmentService(TreatmentRepository treatmentRepository) {
        this.treatmentRepository = treatmentRepository;
    }

    public void save(Patient patient) {
        Treatment databaseTreatment = createTreatment(patient);
        treatmentRepository.save(databaseTreatment);
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
