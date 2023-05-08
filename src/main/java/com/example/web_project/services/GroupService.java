package com.example.web_project.services;

import com.example.web_project.models.Groups;
import com.example.web_project.repository.GroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    private final GroupsRepository groupsRepository;

    @Autowired
    public GroupService(GroupsRepository groupsRepository) {
        this.groupsRepository = groupsRepository;
    }

    public Groups findById(Long id){
        return groupsRepository.getOne(id);
    }

    public List<Groups> findAll(){
        return groupsRepository.findAll();
    }
    public Groups saveUser(Groups groups){
        return groupsRepository.save(groups);
    }

    public void deleteById(Long id){
        groupsRepository.deleteById(id);
    }
}
