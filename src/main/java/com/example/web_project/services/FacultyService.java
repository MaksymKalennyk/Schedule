package com.example.web_project.services;

import com.example.web_project.models.Faculty;
import com.example.web_project.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty findById(Long id){
        return facultyRepository.getOne(id);
    }

    public List<Faculty> findAll(){
        return facultyRepository.findAll();
    }
    public Faculty saveUser(Faculty faculty){
        return facultyRepository.save(faculty);
    }

    public void deleteById(Long id){
        facultyRepository.deleteById(id);
    }
}