package be.pxl.je.voorbeeldexamen.resource;

import be.pxl.je.voorbeeldexamen.entity.Doctor;
import com.sun.istack.NotNull;

public class PatientResource {

    @NotNull
    private final String firstName;

    @NotNull
    private final String lastName;

    @NotNull
    private final String username;

    private final int doctorId;

    public PatientResource(@NotNull String firstName, @NotNull String lastName,
                           String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.doctorId = getDoctorId();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername(){ return username;}

    public int getDoctorId() {
        return doctorId;
    }
}
