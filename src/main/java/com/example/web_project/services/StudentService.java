package com.example.web_project.services;

import com.example.web_project.models.Students;
import com.example.web_project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Students findById(Long id){
        return studentRepository.getOne(id);
    }

    public List<Students> findAll(){
        return studentRepository.findAll();
    }
    public Students saveUser(Students students){
        return studentRepository.save(students);
    }

    public void deleteById(Long id){
        studentRepository.deleteById(id);
    }
}
