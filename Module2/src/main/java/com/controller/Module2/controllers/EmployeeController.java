package com.controller.Module2.controllers;

import com.controller.Module2.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {

//    @GetMapping(path="/getSecretMessage")
//    public  String getMySuperSecretMessage(){
//        return "Secret Message: ashubv";
//    }

    //@GetMapping(path="/employees/{employeeId}")
    @GetMapping(path="{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId){
        return  new EmployeeDTO(employeeId,"Ram","ramji@gmail.com",26, LocalDate.of(2026,02,17),true);
    }

    //same thing can wriiten in other way also
//    @GetMapping(path="{employeeId}")
//    public  EmployeeDTO getEmployeeById(@PathVariable(name="employeeId") Long id){
//        return  new EmployeeDTO(id,"Ram","ramji@gmail.com",26, LocalDate.of(2026,02,17),true);
//    }

    //@GetMapping(path="/employees")
    @GetMapping
    public  String getAllEmployees(@RequestParam Integer age,@RequestParam(required = false) String sortBy){
        return "Hi age " + age + " " + sortBy;
    }

    @PostMapping
    public  EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
        inputEmployee.setId(100L);
        return inputEmployee;
    }

    @PutMapping String updateEnployeeById(){
        return "Hello from Put";
    }







}
