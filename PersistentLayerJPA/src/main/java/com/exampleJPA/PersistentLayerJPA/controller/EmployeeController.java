package com.exampleJPA.PersistentLayerJPA.controller;



import com.exampleJPA.PersistentLayerJPA.dto.EmployeeDTO;
import com.exampleJPA.PersistentLayerJPA.entities.EmployeeEntity;
import com.exampleJPA.PersistentLayerJPA.repository.EmployeeRepository;
import com.exampleJPA.PersistentLayerJPA.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {

    @GetMapping(path ="/getSecretMessage/{id}")
    public String getSecretKey(@PathVariable int id){
        return "I am secret superstar.." + id;
    }

    private  final EmployeeService employeeService;

    public  EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }



    @GetMapping(path="{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name="employeeId") Long id){
        return  employeeService.getEmployeeById(id);
    }


    @GetMapping
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required=false,name="inputAge") Integer age, @RequestParam(required = false) String sortBy){
        //return "Hi age " + age + " " + sortBy;

        return   employeeService.getAllEmployees();
    }



    @PostMapping
    public  EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
        //inputEmployee.setId(100L);

        //return inputEmployee;

        return  employeeService.createNewEmployee(inputEmployee);
    }

//    @PutMapping String updateEnployeeById(){
//        return "Hello from Put";
//    }









}
