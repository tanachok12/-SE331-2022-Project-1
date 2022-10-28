package se331.rest.entity.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.rest.entity.Patient;
import se331.rest.repository.EventRepository;

@Profile("db")
@Repository
public class EventDaoDbImpl implements EventDao {
    @Autowired
    EventRepository eventRepository;

    @Override
    public Integer getEventSize() {
        return Math.toIntExact(eventRepository.count());
    }

    @Override
    public Page<Patient> getEvents(Integer pageSize, Integer page) {
        return eventRepository.findAll(PageRequest.of(page-1,pageSize));
    }

    @Override
    public Patient getEvents(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public Patient save(Patient patient) {
        return eventRepository.save(patient);
    }

    @Override
    public Page<Patient> getEvents(String name, Pageable page) {
        return eventRepository.findByNameIgnoreCaseContainingOrOrganizer_NameIgnoreCaseContaining(name,name,page);
    }
}
