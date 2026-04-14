package com.example.HospitalManagement.Hospital.repository;

import com.example.HospitalManagement.Hospital.dto.BloodGroupStats;
import com.example.HospitalManagement.Hospital.dto.CPatientInfo;
import com.example.HospitalManagement.Hospital.dto.IPatientinfo;
import com.example.HospitalManagement.Hospital.entity.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface PatientRepository  extends JpaRepository<Patient,Long> {
   // List<Patient> findByEmailContaining(String d);


    @Query("select p.id as id,p.name as name,p.email as email from Patient p")
    List<IPatientinfo>getAllPatientsInfo();

//    @Query("select com.example.HospitalManagement.Hospital.dto.CPatientInfo(p.id,p.name)  from Patient p")
//    List<CPatientInfo> getAllPatientsInfoConcrete();



    @Query("select new com.example.HospitalManagement.Hospital.dto.CPatientInfo(p.id, p.name) from Patient p")
    List<CPatientInfo> getAllPatientsInfoConcrete();
//
//    @Query("select new com.example.HospitalManagement.Hospital.dto.BloodGroupStats(p.bloodGroupType ,COUNT(p)) from Patient p" +
//            "group by p.bloodGroupType  order by COUNT(p)")
//    List<BloodGroupStats> getBloodGroupStats();

    @Query("select new com.example.HospitalManagement.Hospital.dto.BloodGroupStats(p.bloodGroupType, COUNT(p)) " +
            "from Patient p " +
            "group by p.bloodGroupType " +
            "order by COUNT(p)")
    List<BloodGroupStats> getBloodGroupStats();


    @Transactional
    @Modifying
    @Query("UPDATE Patient p set p.name = :name where p.id = :id")
    int updatePatientNameWithId(@Param("name") String name,@Param("id") Long id);






}