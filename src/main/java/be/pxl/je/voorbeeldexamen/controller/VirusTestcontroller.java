package be.pxl.je.voorbeeldexamen.controller;

import be.pxl.je.voorbeeldexamen.dto.VirusTestDto;
import be.pxl.je.voorbeeldexamen.resource.VirusTestResource;
import be.pxl.je.voorbeeldexamen.service.VirusTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/tests")
@CrossOrigin(origins = "http://localhost:8082")
@Secured({"ROLE_DOCTOR"})
public class VirusTestcontroller {

    @Autowired
    private VirusTestService virusTestService;

    @PostMapping("")
    public ResponseEntity<Void> createTest(@RequestBody @Valid VirusTestResource virusTestResource){
        virusTestService.createVirusTest(virusTestResource);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public VirusTestDto getVirusTestById(@PathVariable(name = "id") Long id){
        return virusTestService.getVirusTestById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteVirusTestById(@PathVariable(name = "id") Long id){
        virusTestService.deleteVirusTest(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateVirusTestById(@PathVariable(name = "id") Long id,
                                                    @RequestBody VirusTestResource virusTestResource){
        virusTestService.updateVirustest(id, virusTestResource);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
