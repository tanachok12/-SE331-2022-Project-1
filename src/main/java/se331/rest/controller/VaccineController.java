package se331.rest.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import se331.rest.entity.Patient;
import se331.rest.entity.Vaccine;
import se331.rest.service.PatientService;
import se331.rest.service.VaccineService;
import se331.rest.util.LabMapper;
@Controller
public class VaccineController {
    @Autowired
    VaccineService vaccineService;

    @Autowired
    PatientService patientService;

    @GetMapping("/vaccine")
    ResponseEntity<?> getVaccines() {
        return ResponseEntity.ok(LabMapper.INSTANCE.getVaccineDto(vaccineService.getAllVaccine()));
    }

    @PostMapping("/vaccine/patient/{id}")
    ResponseEntity<?> addVaccine(@PathVariable("id") Long id,@RequestBody Vaccine vaccine){
        Patient output = patientService.getPatient(id);
        output.getVaccineList().add(vaccine);
        Vaccine output2 = vaccineService.save(vaccine);
        return ResponseEntity.ok(LabMapper.INSTANCE.getVaccineDto(output2));
    }
}
