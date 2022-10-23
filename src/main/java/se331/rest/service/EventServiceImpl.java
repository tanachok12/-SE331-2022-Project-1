package se331.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.rest.entity.Vaccine;
import se331.rest.dao.EventDao;

import se331.rest.entity.Event;

import se331.rest.dao.VaccineDao;

import javax.transaction.Transactional;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventDao eventDao;

    @Autowired
    VaccineDao vaccineDao;

    @Override
    public Integer getEventSize() {
        return eventDao.getEventSize();
    }

    @Override
    public Page<Event> getEvents(Integer pageSize, Integer page) {
        return eventDao.getEvents(pageSize, page);
    }

    @Override
    public Event getEvent(Long id) {
        return eventDao.getEvents(id);
    }

    @Override
    @Transactional
    public Event save(Event event) {
        Vaccine vaccine = vaccineDao.findById(event.getVaccine().getId()).orElse(null);
        event.setVaccine(vaccine);
        vaccine.getOwnEvents().add(event);

        return eventDao.save(event);
    }

    @Override
    public Page<Event> getEvents(String title, Pageable pageable) {
        return eventDao.getEvents(title,pageable);
    }
}

