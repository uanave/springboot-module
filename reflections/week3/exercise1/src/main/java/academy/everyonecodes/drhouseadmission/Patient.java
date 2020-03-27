package academy.everyonecodes.drhouseadmission;

import java.util.List;
import java.util.Objects;

public class Patient {
    private String name;
    private String uuid;
    private List<String> symptoms;

    public Patient(String name, String uuid, List<String> symptoms) {
        this.name = name;
        this.uuid = uuid;
        this.symptoms = symptoms;
    }

    public Patient() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(name, patient.name) &&
                Objects.equals(uuid, patient.uuid) &&
                Objects.equals(symptoms, patient.symptoms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, uuid, symptoms);
    }
}
