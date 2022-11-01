package se331.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.rest.entity.Patient;

import se331.rest.entity.dao.OrganizerDao;
import se331.rest.entity.Organizer;
import se331.rest.entity.dao.PatientDao;

import javax.transaction.Transactional;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientDao patientDao;

    @Autowired
    OrganizerDao organizerDao;

    @Override
    public Integer getPatientSize() {
        return patientDao.getPatientSize();
    }

    @Override
    public Page<Patient> getPatients(Integer pageSize, Integer page) {
        return patientDao.getPatients(pageSize, page);
    }

    @Override
    public Patient getPatient(Long id) {
        return patientDao.getPatients(id);
    }

    @Override
    @Transactional
    public Patient save(Patient patient) {
        Organizer organizer = organizerDao.findById(patient.getOrganizer().getId()).orElse(null);
        patient.setOrganizer(organizer);
        organizer.getOwnPatients().add(patient);

        return patientDao.save(patient);
    }

    @Override
    public Page<Patient> getPatients(String title, Pageable pageable) {
        return patientDao.getPatients(title,pageable);
    }
}

