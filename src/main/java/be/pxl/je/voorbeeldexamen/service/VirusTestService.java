package be.pxl.je.voorbeeldexamen.service;

import be.pxl.je.voorbeeldexamen.Exception.BusinessException;
import be.pxl.je.voorbeeldexamen.dto.VirusTestDto;
import be.pxl.je.voorbeeldexamen.entity.Patient;
import be.pxl.je.voorbeeldexamen.entity.VirusTest;
import be.pxl.je.voorbeeldexamen.repository.PatientRepository;
import be.pxl.je.voorbeeldexamen.repository.VirusTestRepository;
import be.pxl.je.voorbeeldexamen.resource.VirusTestResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class VirusTestService {

    @Autowired
    private VirusTestRepository virusTestRepository;

    @Autowired
    private PatientRepository patientRepository;

    public VirusTestDto getVirusTestById(Long id){
        Optional<VirusTestDto> foundVirusTest = virusTestRepository.findById(id).map(VirusTestDto::new);
        if(foundVirusTest.isEmpty()){
            throw new BusinessException("Could not find id");
        }
        return foundVirusTest.get();
    }

    public void deleteVirusTest(Long id){
        Optional<VirusTest> foundVirustest = virusTestRepository.findById(id);
        if(foundVirustest.isEmpty()){
            throw new BusinessException("Could not find test");
        }

        virusTestRepository.delete(foundVirustest.get());
    }

    @Transactional
    public void updateVirustest(Long id, VirusTestResource virusTestResource){
        Optional<Patient> patient = patientRepository.findById(virusTestResource.getPatientId());
        if (patient.isEmpty()){
            throw new BusinessException("Patient not found");
        }
        Optional<VirusTest> foundVirustest = virusTestRepository.findById(id);
        if(foundVirustest.isEmpty()){
            throw new BusinessException("Could not find test");
        }
        VirusTest virusTest = new VirusTest();
        virusTest.setId(id);
        virusTest.setPatient(patient.get());
        virusTest.setDate(virusTestResource.getDate());
        virusTest.setTestStatus(virusTestResource.getStatus());

        virusTestRepository.save(virusTest);
    }

    public void createVirusTest(VirusTestResource virusTestResource){
        Optional<Patient> patient = patientRepository.findById(virusTestResource.getPatientId());
        if (patient.isEmpty()){
            throw new BusinessException("Patient not found");
        }
        VirusTest virusTest = new VirusTest();
        virusTest.setDate(virusTestResource.getDate());
        virusTest.setTestStatus(virusTestResource.getStatus());
        virusTest.setPatient(patient.get());

        virusTestRepository.save(virusTest);
    }
}
