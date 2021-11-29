package be.pxl.je.voorbeeldexamen.resource;

import be.pxl.je.voorbeeldexamen.entity.TestStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.Date;

public class VirusTestResource {

    @NotNull
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private final Date date;

    @NotNull
    private final TestStatus status;

    private final Long patientId;

    public VirusTestResource(@NotNull Date date, @NotNull TestStatus status){
        this.date = date;
        this.status = status;
        this.patientId = getPatientId();
    }

    public Date getDate() {
        return date;
    }

    public TestStatus getStatus() {
        return status;
    }

    public Long getPatientId() {
        return patientId;
    }
}
