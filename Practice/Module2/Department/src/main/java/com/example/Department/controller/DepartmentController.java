package com.example.Department.controller;

import com.example.Department.dto.DepartmentDTO;
import com.example.Department.exception.ResourceNotFoundException;
import com.example.Department.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

   private final DepartmentService departmentService;


   public  DepartmentController(DepartmentService departmentService){
       this.departmentService=departmentService;
   }

    @GetMapping("/healthCheck/{id}")
    public String DepartmentHealthCheck(@PathVariable int id) {
        return "Department HealthCheck is running fine with " + id;
    }



    @GetMapping(path="{departmentId}")
    public ResponseEntity<DepartmentDTO> getDepartmentsBYId(@PathVariable(name="departmentId") Long id){
        Optional<DepartmentDTO> departmentDTO=departmentService.getDepartmentsBYId(id);
        if(departmentDTO.isPresent()){
            return  ResponseEntity.ok(departmentDTO.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartment(){
       return  ResponseEntity.ok(departmentService.getAllDepartment());
    }

    @PostMapping
    public  ResponseEntity<DepartmentDTO> createnewDepartment(@RequestBody @Valid DepartmentDTO inputDepartment)  {
       DepartmentDTO savedDepartment=departmentService.createnewDepartment(inputDepartment);
       return  new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @PutMapping(path="/{departmentId}")
    public  ResponseEntity<DepartmentDTO> updateDepartmentId(@RequestBody @Valid DepartmentDTO departmentDTO
    ,@PathVariable(name = "departmentId") Long departmentId){
       DepartmentDTO updateDepartmentId=departmentService.updateDepartmentId(departmentDTO,departmentId);
       return   ResponseEntity.ok(updateDepartmentId);
    }


    @DeleteMapping(path="/{departmentId}")
    public  ResponseEntity<Boolean> deleteDepartmentId(@PathVariable Long departmentId){
       boolean gotDeleted=departmentService.deleteDepartmentId(departmentId);

       if(gotDeleted){
           return  ResponseEntity.ok(true);
       }
       return ResponseEntity.notFound().build();

    }

    @PatchMapping(path="/{departmentId}")
    public  ResponseEntity<DepartmentDTO> updatePartialDepartmentId(@RequestBody @Valid Map<String,
            Object>updates,@PathVariable @Valid Long departmentId){
       DepartmentDTO departmentDTO=departmentService.updatePartialDepartmentId(departmentId,updates);
       if(departmentDTO == null){
           return  ResponseEntity.notFound().build();
       }
        return ResponseEntity.ok(departmentDTO);
    }













}

