package be.pxl.je.voorbeeldexamen.dto;

import be.pxl.je.voorbeeldexamen.entity.TestStatus;
import be.pxl.je.voorbeeldexamen.entity.VirusTest;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

public class VirusTestDto {

    private final Long id;

    @Enumerated(EnumType.STRING)
    private final TestStatus status;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private final Date date;

    public VirusTestDto(VirusTest virusTest){
        this.id = virusTest.getId();
        this.date = virusTest.getDate();
        this.status = virusTest.getTestStatus();
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public TestStatus getStatus() {
        return status;
    }
}
