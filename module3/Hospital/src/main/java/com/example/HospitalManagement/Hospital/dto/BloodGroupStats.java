package com.example.HospitalManagement.Hospital.dto;


import com.example.HospitalManagement.Hospital.entity.type.BloodGroupType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodGroupStats {

    private BloodGroupType bloodGroupType;
    private Long count;
}
