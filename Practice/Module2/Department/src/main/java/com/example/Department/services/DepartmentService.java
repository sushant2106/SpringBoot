package com.example.Department.services;

import com.example.Department.dto.DepartmentDTO;
import com.example.Department.entities.DepartmentEntity;
import com.example.Department.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.util.ReflectionUtils;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private  final ModelMapper modelMapper;

    public  DepartmentService(DepartmentRepository departmentRepository,ModelMapper modelMapper){
        this.departmentRepository=departmentRepository;
        this.modelMapper=modelMapper;
    }

    public  boolean isExistsByDepartmentsBYId(Long departmentId){
        return  departmentRepository.existsById(departmentId);
    }

    public Optional<DepartmentDTO> getDepartmentsBYId(Long id){
       // DepartmentEntity departmentEntity=departmentRepository.findById(id).orElse(null);
        return  departmentRepository.findById(id)
                        .map(departmentEntity -> modelMapper.map(departmentEntity,DepartmentDTO.class));

    }

    public List<DepartmentDTO> getAllDepartment(){
        List<DepartmentEntity>departmentEntityList=departmentRepository.findAll();

        return departmentEntityList.stream().
                map(departmentEntity ->modelMapper.map(departmentEntity,DepartmentDTO.class))
                .collect(Collectors.toList());
    }

    public DepartmentDTO createnewDepartment(DepartmentDTO inputDepartment){
        DepartmentEntity toSaveEntity=modelMapper.map(inputDepartment,DepartmentEntity.class);
        DepartmentEntity savedDepartmentEntity=departmentRepository.save(toSaveEntity);
        return modelMapper.map(savedDepartmentEntity,DepartmentDTO.class);

    }


    public  DepartmentDTO updateDepartmentId(DepartmentDTO departmentDTO,Long departmentId){

        DepartmentEntity departmentEntity=modelMapper.map(departmentDTO,DepartmentEntity.class);
        departmentEntity.setId(departmentId);
        DepartmentEntity savedepartmentEntity=departmentRepository.save(departmentEntity);
        return  modelMapper.map(savedepartmentEntity, DepartmentDTO.class);

    }

    public  boolean deleteDepartmentId(Long departmentId){
        boolean exists=isExistsByDepartmentsBYId(departmentId);
        if(!exists){
            return  false;
        }
        departmentRepository.deleteById(departmentId);
        return  true;

    }

    public  DepartmentDTO updatePartialDepartmentId(Long departmentId, Map<String,Object> updates){
        boolean exists=isExistsByDepartmentsBYId(departmentId);
        if(!exists){
            return  null;
        }
        DepartmentEntity departmentEntity = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        updates.forEach((field, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.findField(DepartmentEntity.class, field);
            if (fieldToBeUpdated != null) {
                fieldToBeUpdated.setAccessible(true);
                ReflectionUtils.setField(fieldToBeUpdated, departmentEntity, value); // <-- use the instance
            }
        });

        return modelMapper.map(departmentRepository.save(departmentEntity), DepartmentDTO.class);


    }









}
