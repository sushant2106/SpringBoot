package com.exampleJPA.PersistentLayerJPA.repository;

import com.exampleJPA.PersistentLayerJPA.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {


}
