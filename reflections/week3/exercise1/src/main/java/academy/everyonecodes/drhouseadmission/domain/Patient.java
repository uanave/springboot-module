package academy.everyonecodes.drhouseadmission.domain;

public class Patient {
    private String uuid;
    private String name;
    private String symptoms;

    public Patient(String name, String symptoms) {
        this.name = name;
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

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

}
