package com.servcie.ServiceLayer.controller;

import com.servcie.ServiceLayer.dto.EmployeeDTO;
import com.servcie.ServiceLayer.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name="employeeId") Long id){
        Optional<EmployeeDTO> employeeDTO=employeeService.getEmployeeById(id);

//        return employeeDTO.map(employeeDTO1 -> ResponseEntity.ok(employeeDTO)).orElse(ResponseEntity.notFound().build());
        if (employeeDTO.isPresent()) {
            return ResponseEntity.ok(employeeDTO.get());
        } else {
            return ResponseEntity.notFound().build();
        }


    }


    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(@RequestParam(required=false,name="inputAge") Integer age, @RequestParam(required = false) String sortBy){


        return   ResponseEntity.ok(employeeService.getAllEmployees());
    }



    @PostMapping
    public  ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
        EmployeeDTO savedEmployee=employeeService.createNewEmployee(inputEmployee);
        return  new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping(path="/{emloyeeId}")
    public  ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody EmployeeDTO employeeDTO,@PathVariable Long emloyeeId){

        return ResponseEntity.ok(employeeService.updateEmployeeById(emloyeeId,employeeDTO));


    }

    @DeleteMapping(path="/{emloyeeId}")
    public  ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long emloyeeId){

        boolean gotDeleted=employeeService.deleteEmployeeById(emloyeeId);
        if(gotDeleted){
            return  ResponseEntity.ok(true);
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping(path="/{employeeId}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployeeById(@RequestBody Map<String,Object> updates,@PathVariable Long employeeId){
        EmployeeDTO employeeDTO=employeeService.updatePartialEmployeeById(employeeId,updates);

        if(employeeDTO == null){
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(employeeDTO);

    }













}
