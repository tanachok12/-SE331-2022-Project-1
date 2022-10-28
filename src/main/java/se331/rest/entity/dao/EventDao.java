package se331.rest.entity.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.rest.entity.Patient;

public interface EventDao {
    Integer getEventSize();
    Page<Patient> getEvents(Integer pageSize, Integer page);
    Patient getEvents(Long id);

    Patient save(Patient patient);
    Page<Patient> getEvents(String name, Pageable page);
}

