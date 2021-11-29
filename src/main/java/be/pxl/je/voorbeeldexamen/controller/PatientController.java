package be.pxl.je.voorbeeldexamen.controller;

import be.pxl.je.voorbeeldexamen.dto.PatientDto;
import be.pxl.je.voorbeeldexamen.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patients")
    @Secured({"ROLE_DOCTOR"})
//    public List<PatientDto> GetAllPatients(){
//        return patientService.getAllPatients();
//    }
    public List<PatientDto> GetAllPatients(){
        return patientService.getAllPatientsByDoctor();
    }

}
