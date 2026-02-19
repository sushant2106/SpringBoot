package com.controller.Module2.controllers;

import com.controller.Module2.dto.EmployeeDTO;
import com.controller.Module2.entities.EmployeeEntity;
import com.controller.Module2.repositiories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {

    @GetMapping(path="/getSecretMessage")
    public  String getMySuperSecretMessage(){
        return "Secret Message: ashubv";
    }

    private  final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }



    //@GetMapping(path="/employees/{employeeId}")
//    @GetMapping(path="{employeeId}")
//    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId){
//        return  new EmployeeDTO(employeeId,"Ram","ramji@gmail.com",26, LocalDate.of(2026,02,17),true);
//    }

    @GetMapping(path="{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name="employeeId") Long id){
        return  employeeRepository.findById(id).orElse(null);
    }

    //same thing can wriiten in other way also
//    @GetMapping(path="{employeeId}")
//    public  EmployeeDTO getEmployeeById(@PathVariable(name="employeeId") Long id){
//        return  new EmployeeDTO(id,"Ram","ramji@gmail.com",26, LocalDate.of(2026,02,17),true);
//    }

    //@GetMapping(path="/employees")
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
