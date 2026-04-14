package com.example.HospitalManagement.Hospital;

import com.example.HospitalManagement.Hospital.dto.BloodGroupStats;
import com.example.HospitalManagement.Hospital.dto.CPatientInfo;
import com.example.HospitalManagement.Hospital.dto.IPatientinfo;
import com.example.HospitalManagement.Hospital.entity.Patient;
import com.example.HospitalManagement.Hospital.repository.PatientRepository;
import com.example.HospitalManagement.Hospital.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.PublicKey;
import java.util.List;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatient(){
//        List<Patient>patientList=patientRepository.findAll();
//
//        for(Patient p: patientList){
//            System.out.println(p);
//        }

//        List<IPatientinfo> patientList=patientRepository.getAllPatientsInfo();
//               for(IPatientinfo p: patientList){
//            System.out.println(p);
//        }

//        List<CPatientInfo> patientList=patientRepository.getAllPatientsInfoConcrete();
//        for(CPatientInfo  p: patientList){
//            System.out.println(p);
//        }

        List<BloodGroupStats>bloodGroupStats=patientRepository.getBloodGroupStats();
        for(BloodGroupStats p: bloodGroupStats) {
            System.out.println(p);
        }


    }

    @Test
    public  void updateNameId(){
        int rowsAffected=patientRepository.updatePatientNameWithId("Sachin Dr",1L);
        System.out.println(rowsAffected);

    }

    @Test
    public void  testusingService(){
           patientService.testPatientTranscation();
    }



}
