package be.pxl.je.voorbeeldexamen.service;

import be.pxl.je.voorbeeldexamen.Exception.BusinessException;
import be.pxl.je.voorbeeldexamen.dto.PatientDto;
import be.pxl.je.voorbeeldexamen.entity.Doctor;
import be.pxl.je.voorbeeldexamen.entity.Patient;
import be.pxl.je.voorbeeldexamen.repository.DoctorRepository;
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

    @Autowired
    private DoctorRepository doctorRepository;

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

    public PatientDto getPatientById(Long id){
        Optional<PatientDto> patient = patientRepository.findById_AndDoctor_Username(id, getUser()).map(PatientDto::new);
        if(patient.isEmpty()){
            throw new BusinessException("Could not find patient");
        }
        return patient.get();
    }

    public void createPatient(PatientResource patientResource){
        Doctor doctor = getDocterByUserName(getUser());
        Optional<Patient> foundPatient = patientRepository.findByFirstNameAndLastName(patientResource.getFirstName(), patientResource.getLastName());
        if(foundPatient.isPresent()){
            throw new BusinessException("Patient already exists");
        }
        Patient patient = new Patient();
        patient.setFirstName(patientResource.getFirstName());
        patient.setLastName(patientResource.getLastName());
        patient.setUsername(patientResource.getUsername());
        patient.setDoctor(doctor);

        patientRepository.save(patient);
    }

    public void deletePatient(Long id){
        Optional<Patient> foundPatient = patientRepository.findById(id);
        if(foundPatient.isEmpty()){
            throw new BusinessException("Could not find patient");
        }
        patientRepository.delete(foundPatient.get());
    }

    public void updatePatient(Long id, PatientResource patientResource){
        Doctor doctor = getDocterByUserName(getUser());
        Optional<Patient> foundPatient = patientRepository.findById(id);
        if(foundPatient.isEmpty()){
            throw new BusinessException("Could not find patient");
        }
        Patient patient = new Patient();
        patient.setId(id);
        patient.setFirstName(patientResource.getFirstName());
        patient.setLastName(patientResource.getLastName());
        patient.setUsername(patientResource.getUsername());
        patient.setDoctor(doctor);

        patientRepository.save(patient);
    }

    public Doctor getDocterByUserName(String username){
        Optional<Doctor> foundDoctor = doctorRepository.findByUsername(username);
        if(foundDoctor.isEmpty()){
            throw new BusinessException("Could not find doctor " + username);
        }
        return foundDoctor.get();
    }




}
