package be.pxl.je.voorbeeldexamen.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {
    ROLE_DOCTOR("Doctor"), ROLE_PATIENT("patient");
    
    private String label;

    private Role(String label){
        this.label = label;
    }

    @JsonValue
    public String getLabel(){
        return label;
    }
}
