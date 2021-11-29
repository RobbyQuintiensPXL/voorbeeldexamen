package be.pxl.je.voorbeeldexamen.repository;

import be.pxl.je.voorbeeldexamen.entity.Doctor;
import be.pxl.je.voorbeeldexamen.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByFirstNameAndLastName(String firstname, String lastname);

    List<Patient> findAllByDoctor_Username(String username);
}
