package se331.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.rest.entity.Patient;

public interface PatientService {
    Integer getEventSize();

    Page<Patient> getEvents(Integer pageSize, Integer page);

    Patient getEvent(Long id);

    Patient save(Patient patient);
    Page<Patient> getEvents(String title, Pageable pageable);

}
