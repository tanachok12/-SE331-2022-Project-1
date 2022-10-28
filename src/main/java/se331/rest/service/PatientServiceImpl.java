package se331.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.rest.entity.Patient;
import se331.rest.entity.dao.EventDao;
import se331.rest.entity.dao.OrganizerDao;
import se331.rest.entity.Organizer;

import javax.transaction.Transactional;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    EventDao eventDao;

    @Autowired
    OrganizerDao organizerDao;

    @Override
    public Integer getEventSize() {
        return eventDao.getEventSize();
    }

    @Override
    public Page<Patient> getEvents(Integer pageSize, Integer page) {
        return eventDao.getEvents(pageSize, page);
    }

    @Override
    public Patient getEvent(Long id) {
        return eventDao.getEvents(id);
    }

    @Override
    @Transactional
    public Patient save(Patient patient) {
        Organizer organizer = organizerDao.findById(patient.getOrganizer().getId()).orElse(null);
        patient.setOrganizer(organizer);
        organizer.getOwnPatients().add(patient);

        return eventDao.save(patient);
    }

    @Override
    public Page<Patient> getEvents(String title, Pageable pageable) {
        return eventDao.getEvents(title,pageable);
    }
}

