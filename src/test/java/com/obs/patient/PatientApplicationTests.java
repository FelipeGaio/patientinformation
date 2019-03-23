package com.obs.patient;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.obs.patient.entity.Patient;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PatientApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PatientApplicationTests {
     
	 @Autowired
     private TestRestTemplate restTemplate;

     @LocalServerPort
     private int port;

     private String getRootUrl() {
         return "http://localhost:" + port;
     }

     @Test
     public void contextLoads() {

     }

     @Test
     public void testGetAllEmployees() {
     HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/patients",
        HttpMethod.GET, entity, String.class);  
        assertNotNull(response.getBody());
    }

    @Test
    public void testCreateEmployee() {
        Patient patient = new Patient();
        patient.setName("test");
        patient.setAddress("address");
        patient.setDate(Calendar.getInstance().getTime());
        
        ResponseEntity<Patient> postResponse = restTemplate.postForEntity(getRootUrl() + "/save", patient, Patient.class);
        assertNotNull(postResponse);
        assertEquals(postResponse.getStatusCode(), HttpStatus.CREATED);
    }

}