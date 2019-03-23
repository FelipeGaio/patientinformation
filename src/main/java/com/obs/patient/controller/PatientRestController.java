package com.obs.patient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.obs.patient.entity.Patient;
import com.obs.patient.exception.BadRequestException;
import com.obs.patient.service.PatientService;

/**
 * Exposing the rest api for patient
 * @author Felipe
 *
 */
@RestController
public class PatientRestController
{

    @Autowired
    private PatientService service;

    @PostMapping ("/save")
    public ResponseEntity<Object> insertEvent(@RequestBody Patient patient) throws BadRequestException
    {
        service.save(patient);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping ("/patients")
    public ResponseEntity<Object> findAllPatients()
    {
        return ResponseEntity.ok(service.getAllPatients());
    }

}
