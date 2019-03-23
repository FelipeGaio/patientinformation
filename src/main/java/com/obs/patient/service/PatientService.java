package com.obs.patient.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.obs.patient.entity.Patient;
import com.obs.patient.exception.BadRequestException;
import com.obs.patient.repository.PatientRepository;

/**
 * Service class 
 * @author Felipe
 *
 */
@Service
public class PatientService
{

	@Autowired
    private PatientRepository repository;

    public Patient save(Patient entity) throws BadRequestException
    {
        if (entity.getId() != null && repository.existsById(entity.getId()))
        {
            throw new BadRequestException("Already exist");
        }
        else
        {
        	entity.setId(UUID.randomUUID().toString());
            return repository.save(entity);
        }
    }
    
    public List<Patient> getAllPatients()
    {
        return repository.findAll(new Sort(Sort.Direction.ASC, "id"));
    }

}
