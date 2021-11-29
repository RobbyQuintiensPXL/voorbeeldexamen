package be.pxl.je.voorbeeldexamen.repository;

import be.pxl.je.voorbeeldexamen.entity.Doctor;
import be.pxl.je.voorbeeldexamen.entity.TestStatus;
import be.pxl.je.voorbeeldexamen.entity.VirusTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VirusTestRepository extends JpaRepository<VirusTest, Long> {

    List<VirusTest> findAllByTestStatus(TestStatus status);
    List<VirusTest> findAllByTestStatusAndPatient_Doctor(TestStatus status, Doctor doctor);
}
