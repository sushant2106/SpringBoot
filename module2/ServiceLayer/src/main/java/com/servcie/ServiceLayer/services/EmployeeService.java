package com.servcie.ServiceLayer.services;

import com.servcie.ServiceLayer.dto.EmployeeDTO;
import com.servcie.ServiceLayer.entities.EmployeeEntity;
import com.servcie.ServiceLayer.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private  final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository,ModelMapper modelMapper){
        this.employeeRepository=employeeRepository;
        this.modelMapper=modelMapper;
    }

    public Optional<EmployeeDTO> getEmployeeById(Long id){
//        Optional<EmployeeEntity> employeeEntity=employeeRepository.findById(id).orElse(null);
//        // ModelMapper mapper=new ModelMapper();
//
//        return  employeeEntity.map(employeeEntity1 -> modelMapper.map(employeeEntity1,EmployeeDTO.class));


        return  employeeRepository.findById(id).map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class));



    }

    public List<EmployeeDTO> getAllEmployees(){
        List<EmployeeEntity>employeeEntityList=employeeRepository.findAll();
        return employeeEntityList.stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public  EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee){
        EmployeeEntity toSaveEntity=modelMapper.map(inputEmployee,EmployeeEntity.class);
        EmployeeEntity savedEmployeeEntity=employeeRepository.save(toSaveEntity);
        return  modelMapper.map(savedEmployeeEntity,EmployeeDTO.class);
    }

    public  EmployeeDTO updateEmployeeById(Long emloyeeId,EmployeeDTO employeeDTO){
         EmployeeEntity employeeEntity=modelMapper.map(employeeDTO,EmployeeEntity.class);
         employeeEntity.setId(emloyeeId);
         EmployeeEntity  saveemployeeEntity=employeeRepository.save(employeeEntity);

         return modelMapper.map(saveemployeeEntity,EmployeeDTO.class);

    }

    public  boolean isExistsByEmployeeId(Long emloyeeId){
        return  employeeRepository.existsById(emloyeeId);
    }



    public boolean deleteEmployeeById(Long emloyeeId){
        boolean exists=isExistsByEmployeeId(emloyeeId);
        if(!exists){
            return false;
        }
        employeeRepository.deleteById(emloyeeId);
        return true;
    }



    public EmployeeDTO updatePartialEmployeeById(Long employeeId, Map<String,Object> updates){
        boolean exists=isExistsByEmployeeId(employeeId);
        if(!exists){
            return  null;
        }
        EmployeeEntity employeeEntity=employeeRepository.findById(employeeId).get();
        updates.forEach((field,value)->{
            Field filedToBeUpdated= ReflectionUtils.findField(EmployeeEntity.class,field);

            filedToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(filedToBeUpdated,employeeEntity,value);

        });


        return modelMapper.map(employeeRepository.save(employeeEntity),EmployeeDTO.class);




    }






}