package com.example.web_project.services;

import com.example.web_project.models.Department;
import com.example.web_project.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {


    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department findById(Long id){
        return departmentRepository.getOne(id);
    }

    public List<Department> findAll(){
        return departmentRepository.findAll();
    }
    public Department saveUser(Department department){
        return departmentRepository.save(department);
    }

    public void deleteById(Long id){
        departmentRepository.deleteById(id);
    }
}
