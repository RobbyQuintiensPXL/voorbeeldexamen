package be.pxl.je.voorbeeldexamen.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum TestStatus {

    POSITIVE("Positive"), NEGATIVE("Negative");

    private String label;

    private TestStatus(String label){
        this.label = label;
    }

    @JsonValue
    public String getLabel(){
        return label;
    }
}
