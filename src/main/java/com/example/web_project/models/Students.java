package com.example.web_project.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
@Entity(name = "Students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", insertable = false,updatable = false)
    private Long id;

    @NotEmpty(message = "Поле не може бути пустим")
    @Size(min = 3,max = 25,message = "Назва має бути не менше 3 символів і не більше 25")
    private String name;

    @NotEmpty(message = "Імейл не може бути пустим")
    @Email(message = "Введіть коректний імейл")
    private String email;

    @Min(value = 1, message = "Введіть коректний номер телефону")
    private int phone;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Groups group_id;
}
