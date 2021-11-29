package be.pxl.je.voorbeeldexamen.resource;

import com.sun.istack.NotNull;

public class PatientResource {

    @NotNull
    private final String firstName;

    @NotNull
    private final String lastName;

    private final String email;

    public PatientResource(@NotNull String firstName, @NotNull String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
