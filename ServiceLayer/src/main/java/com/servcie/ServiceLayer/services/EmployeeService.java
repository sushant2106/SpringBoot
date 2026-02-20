package com.servcie.ServiceLayer.services;

import com.servcie.ServiceLayer.dto.EmployeeDTO;
import com.servcie.ServiceLayer.entities.EmployeeEntity;
import com.servcie.ServiceLayer.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private  final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository,ModelMapper modelMapper){
        this.employeeRepository=employeeRepository;
        this.modelMapper=modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long id){
        EmployeeEntity employeeEntity=employeeRepository.findById(id).orElse(null);
        // ModelMapper mapper=new ModelMapper();
        return modelMapper.map(employeeEntity,EmployeeDTO.class);

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



}