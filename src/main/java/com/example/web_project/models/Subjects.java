package com.example.web_project.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity(name = "Subjects")
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", insertable = false,updatable = false)
    private Long id;

    @NotEmpty(message = "Поле не може бути пустим")
    @Size(min = 3,max = 25,message = "Назва має бути не менше 3 символів і не більше 25")
    private String name;
}
