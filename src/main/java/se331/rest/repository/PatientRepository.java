package se331.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import se331.rest.entity.Patient;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    List<Patient> findAll();
    Page<Patient> findByName(String name, Pageable pageRequest);
    Page<Patient> findByNameContaining(String name, Pageable pageRequest);

    Page<Patient> findByNameContainingOrOrganizer_NameContaining(String name, String description, String organizerName, Pageable pageRequest);
    Page<Patient> findByNameIgnoreCaseContainingOrOrganizer_NameIgnoreCaseContaining(String name, String organizerName, Pageable pageRequest);
}
