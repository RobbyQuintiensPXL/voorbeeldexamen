package be.pxl.je.voorbeeldexamen.entity;

public enum Role {
    DOCTOR("Doctor"), PATIENT("patient");
    
    private String label;

    private Role(String label){
        this.label = label;
    }

    public String getLabel(){
        return label;
    }
}
