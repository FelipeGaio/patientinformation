package com.obs.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obs.patient.entity.Patient;

/**
 * Repository class personalization queries 
 * @author Felipe
 *
 */
public interface PatientRepository extends JpaRepository<Patient, String>
{
}
