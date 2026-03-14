package com.example.PersentationLayerlayer.PresentationLayer.controller;

import com.example.PersentationLayerlayer.PresentationLayer.dto.EmployeeDTO;
import com.example.PersentationLayerlayer.PresentationLayer.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {




    private  final EmployeeService employeeService;

    public  EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping(path="/getSecretMessage/{id}")
    public String getgetSecretKey(@PathVariable int id){
        return "lets do it.." +id;
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
    public  ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid  EmployeeDTO inputEmployee){
        EmployeeDTO savedEmployee=employeeService.createNewEmployee(inputEmployee);
        return  new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping(path="/{emloyeeId}")
    public  ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody @Valid  EmployeeDTO employeeDTO,@PathVariable Long emloyeeId){

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
    public ResponseEntity<EmployeeDTO> updatePartialEmployeeById(@RequestBody Map<String,Object> updates, @PathVariable Long employeeId){
        EmployeeDTO employeeDTO=employeeService.updatePartialEmployeeById(employeeId,updates);

        if(employeeDTO == null){
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(employeeDTO);

    }






}
