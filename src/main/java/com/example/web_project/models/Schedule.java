package com.example.web_project.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "Schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private Long id;
    @NotEmpty(message = "Поле не може бути пустим")
    @Size(min = 3,max = 25,message = "Назва має бути не менше 3 символів і не більше 25")
    private String name;

    @NotEmpty(message = "Поле не може бути пустим")
    private String time;

    @NotEmpty(message = "Поле не може бути пустим")
    @Size(min = 3,max = 25,message = "Назва має бути не менше 3 символів і не більше 25")
    private String classroom;
/*
    @OneToMany(mappedBy = "schedule_id")
    private List<User> users = new ArrayList<>();*/

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private User teacher_id;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subjects subject_id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Groups group_id;


 /*   @Min(value = 1, message = "Введіть коректну id")
    private int teacher_id;*/
/*    @Min(value = 1, message = "Введіть коректну id")
    private int subject_id;
    @Min(value = 1, message = "Введіть коректну id")
    private int group_id;*/
}
