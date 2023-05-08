package com.example.web_project.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
@Entity(name = "Groups")
public class Groups{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Поле не може бути пустим")
    @Size(min = 3,max = 25,message = "Назва має бути не менше 3 символів і не більше 25")
    private String name;

    private int course;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department_id;
}
