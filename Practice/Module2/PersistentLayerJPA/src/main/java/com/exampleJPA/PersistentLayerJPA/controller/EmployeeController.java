package com.exampleJPA.PersistentLayerJPA.controller;



import com.exampleJPA.PersistentLayerJPA.entities.EmployeeEntity;
import com.exampleJPA.PersistentLayerJPA.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {

    @GetMapping(path ="/getSecretMessage/{id}")
    public String getSecretKey(@PathVariable int id){
        return "I am secret superstar.." + id;
    }

    private final EmployeeRepository employeeRepository;

    public  EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }


    @GetMapping(path="{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name="employeeId") Long id){
        return  employeeRepository.findById(id).orElse(null);
    }


    @GetMapping
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required=false,name="inputAge") Integer age, @RequestParam(required = false) String sortBy){
        //return "Hi age " + age + " " + sortBy;

        return  employeeRepository.findAll();
    }

    @PostMapping
    public  EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee){
        //inputEmployee.setId(100L);

        //return inputEmployee;

        return  employeeRepository.save(inputEmployee);
    }

    @PutMapping String updateEnployeeById(){
        return "Hello from Put";
    }









}
