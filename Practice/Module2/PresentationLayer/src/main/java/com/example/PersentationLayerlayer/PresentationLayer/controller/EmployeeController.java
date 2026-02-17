package com.example.PersentationLayerlayer.PresentationLayer.controller;

import com.example.PersentationLayerlayer.PresentationLayer.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {


    @GetMapping(path="{employeId}")
    public EmployeeDTO getEmployeById(@PathVariable  Long employeId){
        return new EmployeeDTO(employeId,"Ram","ramji@gmail.com",26, LocalDate.of(2026,02,17),true);
    }

    @GetMapping
    public  String getAllEmploye(@RequestParam Integer age,@RequestParam(required = false) String sortBy){
        return  "Hi age " + age + " " + sortBy;
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmploye){
        inputEmploye.setId(100L);
        return  inputEmploye;
    }








}
