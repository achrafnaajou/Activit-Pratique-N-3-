package com.emsi.patientsmvc.repositories;

import com.emsi.patientsmvc.entities.patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface patientRepository extends JpaRepository<patient,Long> {
Page<patient> findByNomContains(String kw , Pageable pageable);
}

