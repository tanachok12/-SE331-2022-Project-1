package se331.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.rest.entity.Patient;
import se331.rest.service.PatientService;
import se331.rest.util.LabMapper;

@Controller
public class PatientController {


    @Autowired
    PatientService patientService;

    @GetMapping("patient")
    public ResponseEntity<?> getEventLists(@RequestParam(value = "_limit", required = false) Integer perPage
            , @RequestParam(value = "_page", required = false) Integer page
            , @RequestParam(value = "title", required = false) String title) {
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<Patient> pageOutput;
        if (title == null) {
            pageOutput = patientService.getEvents(perPage, page);
        } else {
            pageOutput = patientService.getEvents(title, PageRequest.of(page - 1, perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();

        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getEventDto(pageOutput.getContent()), responseHeader, HttpStatus.OK);


    }

    @GetMapping("patient/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id) {
        Patient output = patientService.getEvent(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getEventDto(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @PostMapping("/patient")
    public ResponseEntity<?> addEvent(@RequestBody Patient patient) {
        Patient output = patientService.save(patient);
        return ResponseEntity.ok(LabMapper.INSTANCE.getEventDto(output));
    }

}



