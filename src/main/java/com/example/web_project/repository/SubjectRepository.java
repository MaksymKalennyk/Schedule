package com.example.web_project.repository;

import com.example.web_project.models.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subjects,Long> {
}
