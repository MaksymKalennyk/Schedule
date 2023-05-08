package com.example.web_project.repository;

import com.example.web_project.models.Groups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupsRepository extends JpaRepository<Groups,Long> {
}
