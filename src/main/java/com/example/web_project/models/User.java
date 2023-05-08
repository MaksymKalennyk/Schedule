package com.example.web_project.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Email;

@Data
@Entity(name ="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id", insertable = false,updatable = false)
    private Long user_id;


    @NotEmpty(message = "Поле не може бути пустим")
    @Size(min = 3,max = 25,message = "Назва має бути не менше 3 символів і не більше 25")
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "Поле не може бути пустим")
    @Size(min = 3,max = 25,message = "Назва має бути не менше 3 символів і не більше 25")
    private String lastName;

    @NotEmpty(message = "Імейл не може бути пустим")
    @Email(message = "Введіть коректний імейл")
    private String email;
/*  @Column(name = "schedule_id", insertable = false,updatable = false)
    private Long schedule_id;*/
    @Min(value = 5, message = "Введіть коректний номер телефону")
    private int phone;

/*    @ManyToOne
    @JoinColumn(name="schedule_id")
    private Schedule schedule;*/


}
