package com.sms.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name="student_id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name="gender")
    private char gender;
    @Column(name="email")
    private String email;
    @Column(name="address")
    private String address;
    @Column(name="password")
    private String password;
    @ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinTable(name="student_course",
            joinColumns={@JoinColumn(name="user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="course_id",referencedColumnName = "id")})
    private Set<Courses> course=new HashSet<Courses>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="result_id",referencedColumnName = "id")
    private Set<Result> result=new HashSet<Result>();
}





