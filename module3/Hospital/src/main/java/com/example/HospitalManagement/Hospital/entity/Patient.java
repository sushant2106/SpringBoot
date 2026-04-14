package com.example.HospitalManagement.Hospital.entity;

import com.example.HospitalManagement.Hospital.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "birth_date")
    private LocalDate birthdate;

    private String email;

    private String gender;

    @Column(name = "blood_group")
    @Enumerated(value=EnumType.STRING)
    private BloodGroupType bloodGroupType;


    @CreationTimestamp
    private LocalDateTime  createdAt;

}
