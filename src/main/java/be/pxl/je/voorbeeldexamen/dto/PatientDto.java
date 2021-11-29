package be.pxl.je.voorbeeldexamen.dto;

import be.pxl.je.voorbeeldexamen.entity.Patient;

public class PatientDto {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String username;

    public PatientDto(Patient patient) {
        this.id = patient.getId();
        this.firstName = patient.getFirstName();
        this.lastName = patient.getLastName();
        this.username = patient.getUsername();
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername(){
        return username;
    }
}
