package com.example.web_project.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity(name = "Faculty")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", insertable = false,updatable = false)
    private Long id;
    @NotEmpty(message = "Поле не може бути пустим")
    @Size(min = 3,max = 25,message = "Назва має бути не менше 3 символів і не більше 25")
    private String name;
    @NotEmpty(message = "Поле не може бути пустим")
    @Size(min = 1,max = 3,message = "Назва має бути не менше 1 символа і не більше 3")
    private String short_name;
}
