package com.sms.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="course")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name="course_id")
    private int id;
    @Column(name="name")
    private String Name;
    @Column(name="code")
    private int Code;
    @Column(name="sem_no")
    private int sem_no;

    @ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="course")

    private Set<Student> student=new HashSet<Student>();;
}
