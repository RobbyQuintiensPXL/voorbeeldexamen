package be.pxl.je.voorbeeldexamen.service;

import be.pxl.je.voorbeeldexamen.Exception.BusinessException;
import be.pxl.je.voorbeeldexamen.dto.PatientDto;
import be.pxl.je.voorbeeldexamen.entity.Patient;
import be.pxl.je.voorbeeldexamen.repository.PatientRepository;
import be.pxl.je.voorbeeldexamen.resource.PatientResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public String getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    public List<PatientDto> getAllPatients(){
        return patientRepository.findAll().stream().map(PatientDto::new).collect(Collectors.toList());
    }

    public List<PatientDto> getAllPatientsByDoctor(){
        return patientRepository.findAllByDoctor_Username(getUser()).stream().map(PatientDto::new).collect(Collectors.toList());
    }

    public void createPatient(PatientResource patientResource){
        Optional<Patient> foundPatient = patientRepository.findByFirstNameAndLastName(patientResource.getFirstName(), patientResource.getLastName());
        if(foundPatient.isPresent()){
            throw new BusinessException("Patient already exists");
        }
        Patient patient = new Patient();
        patient.setFirstName(patientResource.getFirstName());
        patient.setLastName(patientResource.getLastName());
        patient.setUsername(patientResource.getUsername());
        
    }


}
