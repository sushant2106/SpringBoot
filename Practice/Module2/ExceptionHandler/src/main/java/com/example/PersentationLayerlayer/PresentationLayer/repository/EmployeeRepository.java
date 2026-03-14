package com.example.PersentationLayerlayer.PresentationLayer.repository;

import com.example.PersentationLayerlayer.PresentationLayer.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
