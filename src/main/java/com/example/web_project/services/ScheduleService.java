package com.example.web_project.services;

import com.example.web_project.models.Groups;
import com.example.web_project.models.Schedule;
import com.example.web_project.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public Schedule findById(Long id){
        return scheduleRepository.getOne(id);
    }

    public List<Schedule> findAll(){
        return scheduleRepository.findAll();
    }

    public Schedule saveUser(Schedule schedule){
        return scheduleRepository.save(schedule);
    }

    public void deleteById(Long id){
        scheduleRepository.deleteById(id);
    }
}
