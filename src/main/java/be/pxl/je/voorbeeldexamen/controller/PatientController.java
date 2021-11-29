package be.pxl.je.voorbeeldexamen.controller;

import be.pxl.je.voorbeeldexamen.dto.PatientDto;
import be.pxl.je.voorbeeldexamen.resource.PatientResource;
import be.pxl.je.voorbeeldexamen.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/patients")
@CrossOrigin(origins = "http://localhost:8082")
@Secured({"ROLE_DOCTOR"})
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping()
    public List<PatientDto> getAllPatients(){
        return patientService.getAllPatientsByDoctor();
    }

    @GetMapping("/{id}")
    public PatientDto getPatientById(@PathVariable (name = "id") Long id){
        return patientService.getPatientById(id);
    }

    @PostMapping()
    public ResponseEntity<Void> createPatient(@RequestBody @Valid PatientResource patientResource){
        patientService.createPatient(patientResource);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable(name = "id") Long id){
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updatePatient(@PathVariable(name = "id") Long id,
                                              @RequestBody @Valid PatientResource patientResource){
        patientService.updatePatient(id, patientResource);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/positives")
    public List<PatientDto> getAllPositivePatiens(){
        return patientService.getAllPositiveTestPatients();
    }

}
