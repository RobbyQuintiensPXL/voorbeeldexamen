package be.pxl.je.voorbeeldexamen.resource;

import com.sun.istack.NotNull;

public class PatientResource {

    @NotNull
    private final String firstName;

    @NotNull
    private final String lastName;

    private final String username;

    public PatientResource(@NotNull String firstName, @NotNull String lastName, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername(){ return username;}
}
