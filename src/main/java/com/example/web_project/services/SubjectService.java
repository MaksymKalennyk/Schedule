package com.example.web_project.services;

import com.example.web_project.models.Subjects;
import com.example.web_project.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Subjects findById(Long id){
        return subjectRepository.getOne(id);
    }

    public List<Subjects> findAll(){
        return subjectRepository.findAll();
}
    public Subjects saveUser(Subjects subjects){
        return subjectRepository.save(subjects);
    }

    public void deleteById(Long id){
        subjectRepository.deleteById(id);
    }
}
