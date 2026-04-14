package com.example.HospitalManagement.Hospital.service;

import com.example.HospitalManagement.Hospital.entity.Patient;
import com.example.HospitalManagement.Hospital.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    @Transactional
    public void testPatientTranscation(){
        Patient p1=patientRepository.findById(1L).orElseThrow();
        Patient p2=patientRepository.findById(1L).orElseThrow();

        System.out.println(p1 + "  " + p2);
        System.out.println(p1==p2);
    }
}
